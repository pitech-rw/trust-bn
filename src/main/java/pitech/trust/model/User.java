package pitech.trust.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Setter
@Getter
@Document(collection = "users")
public class User implements UserDetails {

    @Id
    private  String ID;
    private String nationalId;

    private String firstName;
    private String lastName;

    @Indexed(unique = true)
    @NotNull(message = "Email cannot be null")
    @Email(message = "invalid email")
    private String email;

    private String phoneNumber;
    private String location;
    private String type; // ADMIN, CLIENT, Provider
    private ArrayList<Job> jobs; //
    private String status; // active, locked, suspended
    private String username;

    @NotNull(message = "password cannot be null")
    @Size(min = 6, max = 50)
    private String password;
    private Integer trust;


    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
