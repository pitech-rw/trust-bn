package pitech.trust.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
    private String token;
    private long expiresIn;
    private String message;

}
