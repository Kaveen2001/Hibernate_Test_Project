package lk.ijse.supermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ItemDTO {
    private String code;
    private String description;
    private int qtyOnHand;
    private double unitPrice;
}
