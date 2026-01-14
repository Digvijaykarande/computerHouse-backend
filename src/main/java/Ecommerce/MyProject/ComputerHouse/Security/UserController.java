package Ecommerce.MyProject.ComputerHouse.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody AppUser user) {
        userService.createUser(user);
        return "User registered successfully";
    }
}
