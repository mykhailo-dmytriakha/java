package com.mdmytriaha.service.impl;

import com.mdmytriaha.service.IService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseService<T> implements IService<T> {
    private JpaRepository<T, Long> repository;

    public BaseService(JpaRepository repository) {

        this.repository = repository;
    }

    @Override
    public T add(T entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public T delete(long id) {
        T entity = repository.findOne(id);
        repository.delete(entity);
        return entity;
    }

    @Override
    public T getById(long id) {
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
