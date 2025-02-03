package edu.ijse.maduratailors.DTO.TM;

import lombok.*;

@NoArgsConstructor

@ToString
@Getter
@Setter
public class PayemntTM {
    private int paymentId;
    private int orderId;
    private String paymentDate;
    private double amount;
    private String paymentMethod;
    private String status;
    private int customerId;

    public PayemntTM(int paymentId, int orderId, String paymentDate, double amount, String paymentMethod, String status, int customerId) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.customerId = customerId;
    }
}
