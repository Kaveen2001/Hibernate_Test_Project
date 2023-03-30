package lk.ijse.supermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Order_DetailDTO {
    private OrderDTO orderTO;
    private ItemDTO itemDTO;
    private double unitPrice;
    private int qtyOnHand;
}
