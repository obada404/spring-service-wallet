package com.mocProject.Wallet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private boolean isAdmin;

    private String userName;

    @Email
    private String email;

    private String password;
    private Date CreatedAt;
    private Date UpdatedAt;

}
