package lk.ijse.supermarket.service.custom;

import lk.ijse.supermarket.dao.custom.ItemDAO;
import lk.ijse.supermarket.dao.custom.OrderDAO;
import lk.ijse.supermarket.dao.custom.OrderDetailsDAO;
import lk.ijse.supermarket.dao.custom.impl.ItemDAOImpl;
import lk.ijse.supermarket.dao.custom.impl.OrderDAOImpl;
import lk.ijse.supermarket.dao.custom.impl.OrderDetailsDAOImpl;
import lk.ijse.supermarket.dto.OrderDTO;
import lk.ijse.supermarket.dto.Order_DetailDTO;
import lk.ijse.supermarket.entity.Item;
import lk.ijse.supermarket.entity.Order;
import lk.ijse.supermarket.service.SuperService;
import lk.ijse.supermarket.util.Converter;
import lk.ijse.supermarket.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public interface Order_DetailService extends SuperService {
    OrderDAO orderDAO = new OrderDAOImpl();
    OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
    ItemDAO itemDAO = new ItemDAOImpl();

    public static  boolean placeOrder(OrderDTO orderDTO, ArrayList<Order_DetailDTO> list){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Order orders1 = Converter.getInstance().toOrder(orderDTO);
            ArrayList<Item> order_details = Converter.getInstance().toOrder_Detail(list);
            List<Item> items = Converter.getInstance().order_DetailsListToItemList(order_details);

            orders1.setItemList(items);
            Order add1 = orderDAO.add(orders1, session);
            if(add1!=null){
                boolean add = orderDetailsDAO.add(order_details, session);
                if(add){
                    boolean update = itemDAO.update(items, session);
                    if(update){
                        transaction.commit();
                        return true;
                    }
                }
            }

            transaction.rollback();
            return false;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }
}
