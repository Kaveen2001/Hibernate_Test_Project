package lk.ijse.supermarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "Item")
public class Item implements SuperEntity{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Item_Code")
    private String code;
    @Column(name = "Item_Description",length = 150,nullable = false)
    private String description;
    @Column(name = "Item_UnitPrice")
    private double unitPrice;
    @Column(name = "Item_QtyOnHand")
    private int qtyOnHand;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Order_Details", joinColumns = @JoinColumn(name = "Order_Id"), inverseJoinColumns = @JoinColumn(name = "Item_Code"))
    @ToString.Exclude
    private List<Order> ordersList;
}
