package Ecommerce.MyProject.ComputerHouse.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AppUser createUser(AppUser user) {

        // encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // set default role if missing
        if (user.getRole() == null) {
            user.setRole("USER");
        }

        return repo.save(user);
    }
}
