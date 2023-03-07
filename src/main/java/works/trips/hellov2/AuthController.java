package works.trips.hellov2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserRepository userRepo;
	@GetMapping("/login")
	public String login() {
		
		String Token = JsonWebToken.create("Usernam","Role");
		return JsonWebToken.getUsername(Token);

	}
	
	@PostMapping("/register")
	public USER_STATUS registerUser(@Validated @RequestBody Users newUser) {
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

}
