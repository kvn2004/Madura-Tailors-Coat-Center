package edu.ijse.maduratailors.DTO.TM;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class CustomerMesurementTM {
    private int MeasurementId;
    private int customerId;
    private String Name;
    private double chest;
    private double neck;
    private double waist;
    private double sleeve;
    private double shirt;
    private double shoulder;
    private double hip;
    private double inseam;
    private double outseam;
    private double thigh;

}
