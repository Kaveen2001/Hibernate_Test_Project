package lk.ijse.supermarket.service.custom.impl;

import lk.ijse.supermarket.dao.custom.OrderDAO;
import lk.ijse.supermarket.dao.custom.impl.OrderDAOImpl;
import lk.ijse.supermarket.dto.OrderDTO;
import lk.ijse.supermarket.service.custom.OrdersService;
import lk.ijse.supermarket.util.Converter;
import lk.ijse.supermarket.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrdersServiceImpl implements OrdersService {
    OrderDAO orderDAO=new OrderDAOImpl();

    public OrderDTO addOrder(OrderDTO orderDTO){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            return Converter.getInstance().fromOrder(orderDAO.add(Converter.getInstance().toOrder(orderDTO),session ));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteOrder(OrderDTO orderDTO){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            return orderDAO.delete(Converter.getInstance().toOrder(orderDTO),session );
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public OrderDTO updateOrder(OrderDTO orderDTO){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            return Converter.getInstance().fromOrder(orderDAO.update(Converter.getInstance().toOrder(orderDTO),session ));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
