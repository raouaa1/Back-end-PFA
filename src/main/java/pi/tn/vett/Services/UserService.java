package pi.tn.vett.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pi.tn.vett.DTO.UserDTO;
import pi.tn.vett.Entities.User;
import pi.tn.vett.Repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User registerRequest) {
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already in use");
        }

        User newUser = new User();
        newUser.setName(registerRequest.getName());
        newUser.setPassword(registerRequest.getPassword());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPhone(registerRequest.getPhone());
        newUser.setRole(registerRequest.getRole());  // Set role as UserEnum

        return userRepository.save(newUser);
    }

    public User updateUser(Long id, UserDTO updatedUser) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPhone(updatedUser.getPhone());
            existingUser.setRole(updatedUser.getRole());  // Update role as UserEnum
            return userRepository.save(existingUser);
        }
        return null;
    }
    public User deleteUser(Long id) {userRepository.deleteById(id);
        return null;
    }


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}
