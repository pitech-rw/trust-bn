package pitech.trust.service;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pitech.trust.dto.LoginUserDto;
import pitech.trust.dto.RegisterUserDto;
import pitech.trust.exception.UserAlreadyExistsException;
import pitech.trust.model.User;
import pitech.trust.repository.UserRepository;


@Service
public class AuthService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User authenticate(LoginUserDto input) {

        try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );


        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
        } catch (Exception e) {
            System.err.println("Authentication failed: " + e.getMessage());
            throw e;
        }
    }

    public boolean signup(RegisterUserDto input) {
        User user = new User();
                user.setEmail(input.getEmail());
                user.setPhoneNumber(input.getPhoneNumber());
                user.setUsername(input.getUserName());
                user.setPassword(passwordEncoder.encode(input.getPassword()));


                if(userRepository.existsByEmail(user.getEmail())){
                    throw new UserAlreadyExistsException("User with email "+user.getEmail()+" already exists");
                }
        User newUser =  userRepository.save(user);
                System.out.println("The new user issssssssssssssssss "+ newUser.getEmail());
        return  true;

    }
    }

