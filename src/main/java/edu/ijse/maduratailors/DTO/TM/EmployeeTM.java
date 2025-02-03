package edu.ijse.maduratailors.DTO.TM;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class EmployeeTM {
    private int id;
    private String name;
    private Date dob;
    private String bank;
    private String accountNumber;
    private String phone;


}
