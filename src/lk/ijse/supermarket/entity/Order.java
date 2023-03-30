package lk.ijse.supermarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "`Order`")
public class Order implements SuperEntity{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_Id")
    private String oId;
    @CreationTimestamp
    @Column(name = "Order_Date")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Customer customer;

    @ManyToMany(mappedBy = "ordersList",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Item> itemList;
}
