package lk.ijse.supermarket.dao.custom.impl;

import lk.ijse.supermarket.dao.custom.ItemDAO;
import lk.ijse.supermarket.entity.Item;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public Item add(Item item, Session session) throws Exception {
        String save = (String) session.save(item);
        item.setCode(save);
        return item;
    }

    @Override
    public Item update(Item item, Session session) throws Exception {
        session.update(item);
        return item;
    }

    @Override
    public boolean delete(Item item, Session session) throws Exception {
        session.delete(item);
        return true;
    }

    @Override
    public Item search(String code, Session session) throws Exception {
        try {
            Item item = session.get(Item.class, code);
            return item;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    @SuppressWarnings("Unchecked")
    public List<Item> getAll(Session session) throws Exception {
        return session.createCriteria(Item.class).list();
    }

    @Override
    public String generateNewId(Session session) throws Exception {
        String lastId = getLastId(session);
        String[] split = lastId.split("[I][T][-]");
        int i = Integer.parseInt(split[1]);
        return String.format("IT-%03d", ++i);
    }

    @Override
    public boolean update(List<Item> obj, Session session) throws Exception {
        for(Item item:obj){
            if(update(item,session)==null)return false;
        }
        return true;
    }

    public String getLastId(Session session) {
        Query query = session.createNativeQuery("select code from Item ORDER BY code DESC LIMIT  1");
        Object singleResult = query.getSingleResult();
        return singleResult.toString();
    }
}
