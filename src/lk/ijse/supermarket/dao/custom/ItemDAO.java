package lk.ijse.supermarket.dao.custom;


import lk.ijse.supermarket.dao.SuperDAO;
import lk.ijse.supermarket.entity.Item;
import org.hibernate.Session;

import java.util.List;

public interface ItemDAO extends SuperDAO<Item,String> {
    String generateNewId(Session session) throws Exception;
    boolean update(List<Item> obj, Session session) throws Exception;
}
