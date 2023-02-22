package cns.assignment2.assignment2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank
    private String studentName;

    private String cls;

    @NotNull
    @Size(min = 2, message = "Father Name  must have at least 2 characters")
    private String fatherName;

    @NotBlank
    @Size(min = 6, message = "Mother Name  be at least 6 characters")
    private String motherName;


    private Date dateOfBirth;

    @NotBlank
    private String address;

    private String[] degree;
}
