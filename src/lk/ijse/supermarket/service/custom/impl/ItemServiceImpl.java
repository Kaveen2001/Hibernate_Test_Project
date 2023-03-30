package lk.ijse.supermarket.service.custom.impl;

import lk.ijse.supermarket.dao.custom.ItemDAO;
import lk.ijse.supermarket.dao.custom.impl.ItemDAOImpl;
import lk.ijse.supermarket.dto.ItemDTO;
import lk.ijse.supermarket.entity.Item;
import lk.ijse.supermarket.service.custom.ItemService;
import lk.ijse.supermarket.util.Converter;
import lk.ijse.supermarket.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl implements ItemService {
    ItemDAO itemDAO = new ItemDAOImpl();

    public boolean addItem(ItemDTO itemDTO) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Item add = itemDAO.add(Converter.getInstance().toItem(itemDTO),session);
            System.out.println(add.toString());
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }finally {
            session.close();
        }
    }

    public ArrayList<ItemDTO> getAllItem() {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            List<Item> all = itemDAO.getAll(session);
            ArrayList<ItemDTO> list = new ArrayList<>();
            for(Item item : all){
                list.add(Converter.getInstance().fromItem(item));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    public boolean updateItem(ItemDTO itemDTO) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Item item = Converter.getInstance().toItem(itemDTO);
            Item update = itemDAO.update(item,session);
            transaction.commit();
            return true;
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            session.close();
        }
    }

    public String getNewId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            return itemDAO.generateNewId(session);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    public ItemDTO searchItem(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            return Converter.getInstance().fromItem(itemDAO.search(id,session));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    public boolean deleteItem(ItemDTO itemDTO) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            itemDAO.delete(Converter.getInstance().toItem(itemDTO),session);
            transaction.commit();
            return true;
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            session.close();
        }
    }
}
