package lk.ijse.supermarket.repository;

import javafx.scene.control.Alert;
import lk.ijse.supermarket.entity.Item;
import lk.ijse.supermarket.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ItemRepo {
    Session session = FactoryConfiguration.getInstance().getSession();

    public boolean saveItem(Item item){

        Transaction transaction = session.beginTransaction();
        try{
            Integer code = (Integer)session.save(item);
            transaction.commit();
            System.out.println("Item Code : "+code);
            return true;
        }catch (Exception e){
            transaction.rollback();
            Alert a = new Alert(Alert.AlertType.ERROR,"An error occurred in ItemRepo! "+e.getLocalizedMessage());
            a.show();
            return false;
        }
    }

    public boolean updateItem(Item item){
        Transaction transaction = session.beginTransaction();

        try{
            session.update(item);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            Alert a = new Alert(Alert.AlertType.ERROR,"An error occurred in ItemRepo! "+e.getLocalizedMessage());
            a.show();
            return false;
        }
    }

    public Item findByCode(int code){
        session.beginTransaction();
        try {
            Item item = session.get(Item.class,code);
            session.close();
            return item;
        } catch (Exception e) {
            session.getTransaction().rollback();
            Alert a = new Alert(Alert.AlertType.ERROR,"An error occurred in ItemRepo!");
            a.show();
        }
        return null;
    }

    public ArrayList<Item> getAllItem (){
        session.beginTransaction();
        try {
            //select all from item table
            List<Item> list = null;

            Query item = session.createQuery("from Item");
            list = item.list();
            return (ArrayList<Item>) list;

        } catch (Exception e) {
            session.getTransaction().rollback();
            Alert a = new Alert(Alert.AlertType.ERROR,"An error occurred in ItemRepo!");
            a.show();
        }
        return null;
    }

    public boolean deleteItem(String item){
        Transaction transaction = session.beginTransaction();

        try{
            session.delete(item);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            Alert a = new Alert(Alert.AlertType.ERROR,"An error occurred in ItemRepo! "+e.getLocalizedMessage());
            a.show();
            return false;
        }
    }
}
