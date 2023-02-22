package cns.assignment2.assignment2.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String username;

    private String email;
    @NotBlank
    @Size(min = 6,message = "Password should be at least 6 characters")
    private String password;

    @NotBlank
    @Size(min = 6,message = "Password should be at least 6 characters")
    private String confirmPassword;

}
