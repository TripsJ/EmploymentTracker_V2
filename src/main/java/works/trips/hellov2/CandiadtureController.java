package works.trips.hellov2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app")
public class CandiadtureController {
    @Autowired
    private CandidatureRepository candiRepo;
    @Autowired
    private UserRepository userRepository;
    
	@GetMapping("/")
	public String getall(@RequestHeader (name="Authorization") String token) {
	    System.out.println(JsonWebToken.getUsername(token));
	    Iterable<Candidature> candidaturesIterable = candiRepo.findByusers_id(JsonWebToken.getId(token));
	    return candidaturesIterable.toString();
	}
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Candidature  add(@Validated @Valid @RequestBody Candidature newCandidature , @RequestHeader (name="Authorization") String token) {
	    newCandidature.setUsers(userRepository.findById(JsonWebToken.getId(token)));
	    candiRepo.save(newCandidature);
	    return newCandidature;
	    
	}
	
	@PostMapping("/test")
	public void test(@RequestHeader (name="Authorization") String token){
	    System.out.println();
	    
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	
	
    

}
