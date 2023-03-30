package lk.ijse.supermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String cId;
    private String cusName;
    private String address;
    private double salary;
}
