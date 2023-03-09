package works.trips.hellov2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserRepository userRepo;
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
	    Iterable<Users> users = userRepo.findAll();
	    for (Users user : users) {
		String reguser = user.getUsername();
		String regpassword = user.getPassword();
			if (reguser.equals(loginRequest.getUsername())&& regpassword.equals(loginRequest.getPassword())){
			    String Token = JsonWebToken.create(user.getUsername(),user.getRole());
			    return Token;
		}
			
	    }
	    return "invalid login";
	    
	    
		
		

	}
	
	@PostMapping("/register")
	public USER_STATUS registerUser(@Validated @Valid @RequestBody Users newUser) {
        Iterable<Users> users = userRepo.findAll();
        System.out.println("New user: " + newUser.toString());
        for (Users user : users) {
            System.out.println("Registered user: " + newUser.toString());
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return USER_STATUS.USER_ALREADY_EXISTS;
            }
        }
        userRepo.save(newUser);
        return USER_STATUS.SUCCESS;
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
