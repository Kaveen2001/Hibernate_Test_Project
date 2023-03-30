package lk.ijse.supermarket.dao.custom.impl;

import lk.ijse.supermarket.dao.custom.OrderDAO;
import lk.ijse.supermarket.entity.Order;
import org.hibernate.Session;

import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public Order add(Order order, Session session) throws Exception {
        order.setOId((String) session.save(order));
        return order;
    }

    @Override
    public Order update(Order order, Session session) throws Exception {
        session.update(order);
        return order;
    }

    @Override
    public boolean delete(Order order, Session session) throws Exception {
        session.delete(order);
        return true;
    }

    @Override
    public Order search(String oId, Session session) throws Exception {
        return session.get(Order.class,oId);
    }

    @Override
    public List<Order> getAll(Session session) throws Exception {
        return session.createCriteria(Order.class).list();
    }
}
