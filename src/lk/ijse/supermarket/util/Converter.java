package lk.ijse.supermarket.util;


import lk.ijse.supermarket.dto.CustomerDTO;
import lk.ijse.supermarket.dto.ItemDTO;
import lk.ijse.supermarket.dto.OrderDTO;
import lk.ijse.supermarket.dto.Order_DetailDTO;
import lk.ijse.supermarket.entity.Customer;
import lk.ijse.supermarket.entity.Item;
import lk.ijse.supermarket.entity.Order;
import lk.ijse.supermarket.entity.Order_Detail;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    private static Converter converter;

    private Converter() {

    }

    public static Converter getInstance() {
        if (converter == null) converter = new Converter();
        return converter;
    }

    /*================================= Customer =================================================*/

    public Customer toCustomer(CustomerDTO customerDTO) {
        Customer customer = toOnlyCustomer(customerDTO);
        return customer;

    }

    public CustomerDTO fromCustomer(Customer customer) {
        CustomerDTO customerDTO = fromOnlyCustomer(customer);
        return customerDTO;
    }

    @SuppressWarnings("Dont Touch")
    private Customer toOnlyCustomer(CustomerDTO customerDTO) {
        return new Customer(customerDTO.getCId(), customerDTO.getCusName(), customerDTO.getAddress(), customerDTO.getSalary(),null);
    }

    @SuppressWarnings("Dont Touch")
    private CustomerDTO fromOnlyCustomer(Customer customer) {
        return new CustomerDTO(customer.getCId(), customer.getCusName(), customer.getAddress(), customer.getSalary());
    }

    /*==========================================================================================*/

    /*================================= Item =================================================*/

    public Item toItem(ItemDTO itemDTO) {
        Item item = toOnlyItem(itemDTO);
        return item;

    }

    public ItemDTO fromItem(Item item) {
        ItemDTO itemDTO = fromOnlyItem(item);
        return itemDTO;

    }

    @SuppressWarnings("Dont Touch")
    private Item toOnlyItem(ItemDTO itemDTO) {
        return new Item(itemDTO.getCode(),itemDTO.getDescription(), itemDTO.getQtyOnHand(), (int) itemDTO.getUnitPrice(),null);
    }

    @SuppressWarnings("Dont Touch")
    private ItemDTO fromOnlyItem(Item item) {
        return new ItemDTO(item.getCode(),item.getDescription(), item.getQtyOnHand(), item.getUnitPrice());
    }

    public List<Item> order_DetailsListToItemList(List<Item> order_detail) {
        ArrayList<Item> items = new ArrayList<>();
        for (Item ob : order_detail) {
            items.add(ob.getItem());
        }
        return items;
    }

    public ArrayList<Item> toOrder_Detail(List<Order_DetailDTO> list) {
        ArrayList<Item> itemList = new ArrayList<>();
        for (Order_DetailDTO ob : list) {
            Order_Detail order_detail = toOnlyOrder_Detail(ob);
            Item item = toOnlyItem(ob.getItemDTO());
            Order order = toOnlyOrder(ob.getOrderTO());

            order.setItemList(itemList);
            order_detail.setItem(item);
            order_detail.setOrder(order);
            itemList.add(order_detail);
        }
        return itemList;
    }

    /*==========================================================================================*/

    /*================================= Order =================================================*/

    public Order toOrder(OrderDTO orderDTO) {
        Order order = toOnlyOrder(orderDTO);
        return order;
    }

    public OrderDTO fromOrder(Order order) {
        OrderDTO orderDTO = fromOnlyOrder(order);
        return orderDTO;
    }

    @SuppressWarnings("Dont Touch")
    private Order toOnlyOrder(OrderDTO orderDTO) {
        return new Order(orderDTO.getOId(), orderDTO.getDate(), toOnlyCustomer(orderDTO.getCustomerDTO()), null);
    }

    @SuppressWarnings("Dont Touch")
    private OrderDTO fromOnlyOrder(Order order) {
        return new OrderDTO(order.getOId(), order.getDate(), fromCustomer(order.getCustomer()));
    }

    public List<Order> toOrderList(List<OrderDTO> orders) {
        ArrayList<Order> list = new ArrayList<>();
        for (OrderDTO item : orders) {
            list.add(toOrder(item));
        }
        return list;
    }

    public List<OrderDTO> fromOrderList(List<Order> order) {
        ArrayList<OrderDTO> list = new ArrayList<>();
        for (Order item : order) {
            list.add(fromOrder(item));
        }
        return list;
    }

    /*==========================================================================================*/

    /*================================= Order_Details =================================================*/

    public Order_DetailDTO fromOrder_Detail(Order_Detail order_detail) {
        Order_DetailDTO order_detailDTO = fromOnlyOrder_Detail(order_detail);
        return order_detailDTO;
    }


    public Order_Detail toOrder_Detail(Order_DetailDTO order_detailDTO) {
        Order_Detail order_detail = toOnlyOrder_Detail(order_detailDTO);
        return order_detail;

    }

    @SuppressWarnings("Dont Touch")
    private Order_DetailDTO fromOnlyOrder_Detail(Order_Detail order_detail) {
        ItemDTO itemDTO = fromOnlyItem(order_detail.getItem());
        OrderDTO orderDTO = fromOnlyOrder(order_detail.getOrder());
        return new Order_DetailDTO(orderDTO, itemDTO, order_detail.getUnitPrice(),order_detail.getQtyOnHand());
    }

    @SuppressWarnings("Dont Touch")
    private Order_Detail toOnlyOrder_Detail(Order_DetailDTO order_detailDTO) {
        return new Order_Detail(null, null, order_detailDTO.getUnitPrice(), order_detailDTO.getQtyOnHand());
    }

    public List<Order_DetailDTO> fromOrder_Detail(List<Order_Detail> order_detail) {
        ArrayList<Order_DetailDTO> order_detailDTO = new ArrayList<>();
        for (Order_Detail ob : order_detail) {
            order_detailDTO.add(fromOrder_Detail(ob));
        }
        return order_detailDTO;
    }
}
