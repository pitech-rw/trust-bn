package pitech.trust.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class RegisterUserDto {
    @Indexed(unique = true)
    @NotNull(message = "Email cannot be null")
    @Email(message = "invalid email")
    private String email;
    @NotNull(message = "Password cannot be null")
    @Size(min = 6, max = 50)
    private String password;
    private String userName;
    private String phoneNumber;

}
