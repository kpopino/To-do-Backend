package br.com.davidkim.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Modificador
 * public
 * private
 * protected
 */

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private IUserRepositor userRepository;

    @PostMapping("/")
    public UserModel create(@RequestBody UserModel userModel) {

        lombok.var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user != null) {
            System.out.println("Usuário já Existe");
            return null;
        }

        lombok.var userCreated = this.userRepository.save(userModel);
        return userCreated;
    }
    
}
