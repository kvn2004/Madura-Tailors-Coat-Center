package edu.ijse.maduratailors.DTO;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderPaymentDTO {
    private int customerID;
    private String orderType;
    private String orderDate;
    private String dueDate;
    private String design;
    private double price;
    private int quantity;
    private int itemID;
    private String paymentMethod;
    private String paymentDate;
    private double amount;
    private String status;
}
