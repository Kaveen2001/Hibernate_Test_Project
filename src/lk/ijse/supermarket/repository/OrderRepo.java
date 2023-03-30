package lk.ijse.supermarket.repository;

import javafx.scene.control.Alert;
import lk.ijse.supermarket.entity.Order;
import lk.ijse.supermarket.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class OrderRepo {
    Session session = FactoryConfiguration.getInstance().getSession();

    public boolean saveOrder(Order order){

        Transaction transaction = session.beginTransaction();
        try{
            Integer oId = (Integer)session.save(order);
            transaction.commit();
            System.out.println("Order ID : "+oId);
            return true;
        }catch (Exception e){
            transaction.rollback();
            Alert a = new Alert(Alert.AlertType.ERROR,"An error occurred in OrderRepo! "+e.getLocalizedMessage());
            a.show();
            return false;
        }
    }

    public boolean updateOrder(Order order){
        Transaction transaction = session.beginTransaction();

        try{
            session.update(order);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            Alert a = new Alert(Alert.AlertType.ERROR,"An error occurred in OrderRepo! "+e.getLocalizedMessage());
            a.show();
            return false;
        }
    }

    public Order findById(int oId){
        session.beginTransaction();
        try {
            Order order = session.get(Order.class,oId);
            session.close();
            return order;
        } catch (Exception e) {
            session.getTransaction().rollback();
            Alert a = new Alert(Alert.AlertType.ERROR,"An error occurred in OrderRepo!");
            a.show();
        }
        return null;
    }

    public ArrayList<Order> getAllOrder (){
        session.beginTransaction();
        try {
            //select all from Order table
            List<Order> list = null;

            Query order = session.createQuery("from Order");
            list = order.list();
            return (ArrayList<Order>) list;

        } catch (Exception e) {
            session.getTransaction().rollback();
            Alert a = new Alert(Alert.AlertType.ERROR,"An error occurred in OrderRepo!");
            a.show();
        }
        return null;
    }

    public boolean deleteOrder(String order){
        Transaction transaction = session.beginTransaction();

        try{
            session.delete(order);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            Alert a = new Alert(Alert.AlertType.ERROR,"An error occurred in OrderRepo! "+e.getLocalizedMessage());
            a.show();
            return false;
        }
    }
}
