package lk.ijse.supermarket.repository;

import javafx.scene.control.Alert;
import lk.ijse.supermarket.entity.Customer;
import lk.ijse.supermarket.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    Session session = FactoryConfiguration.getInstance().getSession();

    public boolean saveCustomer(Customer customer){

        Transaction transaction = session.beginTransaction();
        try{
            Integer cId = (Integer)session.save(customer);
            transaction.commit();
            System.out.println("Customer Id : "+cId);
            return true;
        }catch (Exception e){
            transaction.rollback();
            Alert a = new Alert(Alert.AlertType.ERROR,"An error occurred in CustomerREPO! "+e.getLocalizedMessage());
            a.show();
            return false;
        }
    }

    public boolean updateCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();

        try{
            session.update(customer);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            Alert a = new Alert(Alert.AlertType.ERROR,"An error occurred in CustomerREPO! "+e.getLocalizedMessage());
            a.show();
            return false;
        }
    }

    public Customer findById(int id){
        session.beginTransaction();
        try {
            Customer customer = session.get(Customer.class,id);
            session.close();
            return customer;
        } catch (Exception e) {
            session.getTransaction().rollback();
            Alert a = new Alert(Alert.AlertType.ERROR,"An error occurred in CustomerREPO!");
            a.show();
        }
        return null;
    }

    public ArrayList<Customer> getAll (){
        session.beginTransaction();
        try {
            //select all from customer table
            List<Customer> list = null;

            Query customer = session.createQuery("from Customer");
            list = customer.list();
            //return session.createQuery("from Customer").list();
            return (ArrayList<Customer>) list;

        } catch (Exception e) {
            session.getTransaction().rollback();
            Alert a = new Alert(Alert.AlertType.ERROR,"An error occurred in CustomerREPO!");
            a.show();
        }
        return null;
    }

    public boolean deleteCustomer(String customer){
        Transaction transaction = session.beginTransaction();

        try{
            session.delete(customer);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            Alert a = new Alert(Alert.AlertType.ERROR,"An error occurred in CustomerREPO! "+e.getLocalizedMessage());
            a.show();
            return false;
        }
    }
}