package lk.ijse.supermarket.service.custom.impl;

import lk.ijse.supermarket.dao.custom.CustomerDAO;
import lk.ijse.supermarket.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.supermarket.dto.CustomerDTO;
import lk.ijse.supermarket.entity.Customer;
import lk.ijse.supermarket.service.custom.CustomerService;
import lk.ijse.supermarket.util.Converter;
import lk.ijse.supermarket.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerDAO customerDAO = new CustomerDAOImpl();

    public boolean addCustomer(CustomerDTO customerDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Customer add = customerDAO.add(Converter.getInstance().toCustomer(customerDTO),session);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    public boolean updateCustomer(CustomerDTO customerDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Customer update = customerDAO.update(Converter.getInstance().toCustomer(customerDTO),session);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    public CustomerDTO searchCustomer(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            return Converter.getInstance().fromCustomer(customerDAO.search(id,session));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    public boolean deleteCustomer(CustomerDTO customerDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            boolean delete = customerDAO.delete(Converter.getInstance().toCustomer(customerDTO), session);
            transaction.commit();
            return delete;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public ArrayList<CustomerDTO> getAllCustomer() {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            List<Customer> all = customerDAO.getAll(session);
            ArrayList<CustomerDTO> list = new ArrayList<>();
            for (Customer c : all) {
                list.add(Converter.getInstance().fromCustomer(c));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    public String getNewId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            return customerDAO.getNewId(session);
        } catch (Exception e) {
            return null;
        }finally {
            session.close();
        }
    }
}
