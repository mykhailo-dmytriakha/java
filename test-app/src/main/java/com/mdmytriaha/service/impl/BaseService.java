package com.mdmytriaha.service.impl;

import com.mdmytriaha.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public abstract class BaseService<R extends JpaRepository<T, ID>, T, ID extends Serializable> implements IService<T, ID> {

    @Autowired
    private R repository;

    @Override
    public T add(T entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public T delete(ID id) {
        T entity = repository.findOne(id);
        repository.delete(entity);
        return entity;
    }

    @Override
    public T getById(ID id) {
        return repository.findOne(id);
    }

    @Override
    public T edit(T entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }
}
