package edu.ijse.maduratailors.DTO;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    //private int measurementID;
    private int customerID;
    private String name;
    private String address;
    private String telephone;

   // private String type;
//    private BigDecimal neckSize;
//    private BigDecimal shoulderWidth;
//    private BigDecimal chestSize;
//    private BigDecimal waistSize;
//    private BigDecimal hipSize;
//    private BigDecimal sleeveLength;
//    private BigDecimal shirtLength;
//    private BigDecimal thighSize;
//    private BigDecimal inseamLength;
//    private BigDecimal outseamLength;
}
