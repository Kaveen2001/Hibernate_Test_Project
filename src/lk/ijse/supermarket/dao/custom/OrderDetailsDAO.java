package lk.ijse.supermarket.dao.custom;

import lk.ijse.supermarket.dao.SuperDAO;
import lk.ijse.supermarket.entity.Item;
import lk.ijse.supermarket.entity.Order_Detail;
import org.hibernate.Session;

import java.util.List;

public interface OrderDetailsDAO extends SuperDAO<Order_Detail,String> {
    boolean add(List<Item> obj, Session session) throws Exception;
}
