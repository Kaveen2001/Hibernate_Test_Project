package lk.ijse.supermarket.dao.custom.impl;

import lk.ijse.supermarket.dao.custom.OrderDetailsDAO;
import lk.ijse.supermarket.entity.Item;
import lk.ijse.supermarket.entity.Order_Detail;
import org.hibernate.Session;

import java.util.List;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public Order_Detail add(Order_Detail obj, Session session) throws Exception {
        session.save(obj);
        return obj;
    }

    @Override
    public Order_Detail update(Order_Detail obj, Session session) throws Exception {
        session.update(obj);
        return obj;
    }

    @Override
    public boolean delete(Order_Detail obj, Session session) throws Exception {
        session.delete(obj);
        return true;
    }

    @Override
    public Order_Detail search(String s, Session session) throws Exception {
        return session.get(Order_Detail.class,s);
    }

    @Override
    public List<Order_Detail> getAll(Session session) throws Exception {
        return session.createCriteria(Order_Detail.class).list();
    }

    @Override
    public boolean add(List<Item> obj, Session session) throws Exception {
        for (Item ob : obj){
            if(add(ob,session)==null){
                return false;
            }
        }
        return true;
    }
}
