package lk.ijse.supermarket.dao.custom;

import lk.ijse.supermarket.dao.SuperDAO;
import lk.ijse.supermarket.entity.Customer;
import org.hibernate.Session;

public interface CustomerDAO extends SuperDAO<Customer,String> {
    String getNewId(Session session) throws Exception;
}
