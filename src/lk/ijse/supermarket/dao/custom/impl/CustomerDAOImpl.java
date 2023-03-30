package lk.ijse.supermarket.dao.custom.impl;

import lk.ijse.supermarket.dao.custom.CustomerDAO;
import lk.ijse.supermarket.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public Customer add(Customer customer, Session session) throws Exception {
        String save = (String) session.save(customer);
        customer.setCId(save);
        return customer;
    }

    @Override
    public Customer update(Customer customer, Session session) throws Exception {
        session.update(customer);
        return customer;
    }

    @Override
    public boolean delete(Customer customer, Session session) throws Exception {
        session.delete(customer);
        return true;
    }

    @Override
    public Customer search(String cId, Session session) throws Exception {
        return session.get(Customer.class, cId);
    }

    @Override
    @SuppressWarnings("Unchecked")
    public List<Customer> getAll(Session session) throws Exception {
        return session.createCriteria(Customer.class).list();
    }

    @Override
    public String getNewId(Session session) throws Exception {
        try {
            String lastId = getLastId(session);
            if (lastId == null) return "C-001";
            String[] split = lastId.split("[C][-]");
            int i = Integer.parseInt(split[1]);
            System.out.println(i);
            return String.format("C-%03d", ++i);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    private String getLastId(Session session) throws Exception {
        try {
            NativeQuery sqlQuery = session.createSQLQuery("select cId from Customer ORDER BY cId DESC LIMIT 1");
            Object singleResult = sqlQuery.getSingleResult();
            return singleResult.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
