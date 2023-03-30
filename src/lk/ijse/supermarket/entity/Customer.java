package lk.ijse.supermarket.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Customer")
public class Customer implements SuperEntity{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cus_Id")
    private String cId;
    @Column(name = "Cus_Name",length = 150,nullable = false)
    private String cusName;
    @Column(name = "Cus_Address",columnDefinition = "TEXT")
    private String address;
    /*@ElementCollection
    @CollectionTable(name = "Cus_Mobile",joinColumns = @JoinColumn(name = "Cus_Id"))
    private List<CusMobile> CusMobile;*/
    /*@Transient
    private int age;*/
    @Column(name = "Cus_Salary")
    private double salary;

    @OneToMany(mappedBy = "customer",targetEntity = Order.class,cascade = CascadeType.ALL)
    private List<Order> ordersList;
}
