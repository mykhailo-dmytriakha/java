package com.mdmytriaha.service;

import java.util.List;

public interface IService<T, ID> {
    T add(T entity);
    T delete(ID id);
    T getById(ID id);
    T edit (T entity);
    List<T> getAll();
}
