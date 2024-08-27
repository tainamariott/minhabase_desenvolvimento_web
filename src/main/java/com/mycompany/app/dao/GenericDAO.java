package com.mycompany.app.dao;

import java.util.List;

public interface GenericDAO<T> {
    List<T> getAll();
    T getById(int id);
    void upsert(T entity);
    void delete(int id);
}
