package epmaapi.controller;

import org.springframework.web.bind.annotation.*;
import epmaapi.models.users_model;

import java.util.Map;

@RestController
@CrossOrigin(origins = {
    "http://localhost:3000",
    "https://task-manager-frontend-eight-rho.vercel.app"
})
public class UserController {

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> body) {

        users_model model = new users_model();

        return model.registerUser(
                body.get("full_name"),
                body.get("email"),
                body.get("password")
        );
    }
  

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> body) {

    users_model model = new users_model();

    return model.loginUser(
            body.get("email"),
            body.get("password")
        );
    }
}