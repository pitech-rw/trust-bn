package pitech.trust.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pitech.trust.model.User;
import pitech.trust.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findUserByID(String id ){
        return userRepository.findById(id);
    }

    public ResponseEntity<?> saveUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        else{
            User newUser = userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    public List<User> findProvidersWithJob(String jobName){
        return userRepository.findProvidersWithJob(jobName);
    }
}
