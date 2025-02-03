package edu.ijse.maduratailors.DTO;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmplyeeDTO {
    private int id;
    private String fName;
    private String mName;
    private String lName;
    private Date dob;
    private String bank;
    private String accountNumber;
    private String phone;



    public String getFullName() {
        return (fName != null ? fName : "") +
                (mName != null ? " " + mName : "") +
                (lName != null ? " " + lName : "");
    }
}
