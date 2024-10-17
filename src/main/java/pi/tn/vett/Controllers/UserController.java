package pi.tn.vett.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.tn.vett.DTO.UserDTO;
import pi.tn.vett.Entities.User;
import pi.tn.vett.Services.UserService;
import pi.tn.vett.Entities.UserEnum;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody UserDTO request) {
        System.out.println("Received Add User Request: " + request);

        User newUser = new User();
        newUser.setName(request.getName());
        newUser.setPassword(request.getPassword());
        newUser.setEmail(request.getEmail());
        newUser.setPhone(request.getPhone());
        newUser.setRole(UserEnum.valueOf(request.getRole().toString()));  // Handle role as UserEnum

        User savedUser = userService.addUser(newUser);

        return ResponseEntity.ok(savedUser);
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody UserDTO addUserRequest) {
        User updatedUser = userService.updateUser(id, addUserRequest);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteuser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

}
