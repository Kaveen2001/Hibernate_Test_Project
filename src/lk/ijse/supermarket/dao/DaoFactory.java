package lk.ijse.supermarket.dao;

import lk.ijse.supermarket.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.supermarket.dao.custom.impl.ItemDAOImpl;
import lk.ijse.supermarket.dao.custom.impl.OrderDAOImpl;
import lk.ijse.supermarket.dao.custom.impl.OrderDetailsDAOImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public static DaoFactory getInstance(){
        return daoFactory==null?(daoFactory=new DaoFactory()):daoFactory;
    }

    //factory method
    public SuperDAO getDAO(DaoTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAILS:
                return new OrderDetailsDAOImpl();
            default:
                return null;
        }
    }
}
