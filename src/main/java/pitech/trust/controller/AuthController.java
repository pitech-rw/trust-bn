package pitech.trust.controller;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pitech.trust.dto.LoginResponseDto;
import pitech.trust.dto.LoginUserDto;
import pitech.trust.dto.RegisterResponseDto;
import pitech.trust.dto.RegisterUserDto;
import pitech.trust.exception.UserAlreadyExistsException;
import pitech.trust.model.User;
import pitech.trust.service.AuthService;
import pitech.trust.service.JWTService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authenticationService;
    private final JWTService jwtService;
    public AuthController(JWTService jwtService, AuthService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginUserDto loginUserDto) {

        try {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setToken(jwtToken);
        loginResponseDto.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponseDto);
        }catch (Exception e){
            LoginResponseDto res = new LoginResponseDto();
            res.setMessage(e.getMessage());

            return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<RegisterResponseDto> signup(@Valid @RequestBody RegisterUserDto registerUserDto) {

        try {
            boolean registeredUser = authenticationService.signup(registerUserDto);

            RegisterResponseDto  res = createResponse( registerUserDto);
            res.setMessage("Created");
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }catch (UserAlreadyExistsException e){
            RegisterResponseDto res = createResponse( registerUserDto);
            res.setMessage(e.toString());
            return new ResponseEntity<>(res, HttpStatus.CONFLICT);
        }
        catch (Exception ex){
            RegisterResponseDto  res = createResponse( registerUserDto);
            res.setMessage(ex.toString());
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
}


    public RegisterResponseDto createResponse(RegisterUserDto user) {
        RegisterResponseDto dto = new RegisterResponseDto();
        dto.setUserName(user.getUserName());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setPhoneNumber(user.getPhoneNumber());
        return dto;
    }

}
