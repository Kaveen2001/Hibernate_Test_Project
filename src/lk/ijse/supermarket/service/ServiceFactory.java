package lk.ijse.supermarket.service;

import lk.ijse.supermarket.service.custom.impl.CustomerServiceImpl;
import lk.ijse.supermarket.service.custom.impl.ItemServiceImpl;
import lk.ijse.supermarket.service.custom.impl.OrdersServiceImpl;

public class ServiceFactory {
    /*public static SuperService getService(ServiceTypes serviceType) {
        switch (serviceType) {
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ORDER:
                return new OrdersServiceImpl();
            case ITEM:
                return new ItemServiceImpl();
            default:
                return null;
        }
    }*/

    // public static ServiceFactory getServiceFactory;
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getServiceFactory() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService(ServiceTypes serviceTypes) {
        switch (serviceTypes) {
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ITEM:
                return new ItemServiceImpl();
            case ORDER:
                return new OrdersServiceImpl();
            default:
                return null;
        }
    }
}