package edu.ijse.maduratailors.DTO.TM;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrdersTM {
    int order_id;
    int customer_id;
    String order_type;
    String order_date;
    String order_DueDate;
    String design;
    double order_price;
    int order_quantity;

}
