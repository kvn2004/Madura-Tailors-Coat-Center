package edu.ijse.maduratailors.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerMesurementDTO {
    private int customerId;
    private int MeasurementId;
    private String Name;
    private String Address;
    private String Telephone;
    private double neck;
    private double shoulder;
    private double chest;
    private double waist;
    private double hip;
    private double sleeve;
    private double shirt;
    private double thigh;
    private double inseam;
    private double outseam;
}
