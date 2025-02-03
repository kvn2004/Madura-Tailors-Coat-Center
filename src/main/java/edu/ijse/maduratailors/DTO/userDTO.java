package edu.ijse.maduratailors.DTO;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class userDTO {
    private int id;
    private String name;
    private String password;
    private String role;
}
