package com.mdmytriaha.service;

import java.util.List;

public interface IService<T> {
    T add(T entity);
    T delete(long id);
    T getById(long id);
    T edit (T entity);
    List<T> getAll();
}
