package lk.ijse.supermarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "`Order_Details`")
public class Order_Detail extends Item implements SuperEntity{
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Order_Id")
    protected Order order;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Item_Code")
    protected Item item;

    @Column(name = "Item_UnitPrice")
    private double unitPrice;
    @Column(name = "Item_QtyOnHand")
    private int qtyOnHand;
}
