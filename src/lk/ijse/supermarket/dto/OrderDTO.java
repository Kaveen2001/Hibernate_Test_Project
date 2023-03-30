package lk.ijse.supermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderDTO {
    private String oId;
    private Date date;
    private CustomerDTO customerDTO;
}
