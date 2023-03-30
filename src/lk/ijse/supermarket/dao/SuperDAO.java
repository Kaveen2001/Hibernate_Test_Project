package lk.ijse.supermarket.dao;


import org.hibernate.Session;

import java.util.List;

public interface SuperDAO<T,ID> {

    T add(T obj, Session session) throws Exception;
    T update(T obj,Session session) throws Exception;
    boolean delete(T obj,Session session) throws Exception;
    T search(ID id,Session session) throws Exception;
    List<T> getAll(Session session) throws Exception;
}
