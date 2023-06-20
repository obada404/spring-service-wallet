package com.mocProject.Wallet.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private  int id;

    @NotEmpty
    private String userName;
    @NotEmpty
    @Email
    private String email;

}
