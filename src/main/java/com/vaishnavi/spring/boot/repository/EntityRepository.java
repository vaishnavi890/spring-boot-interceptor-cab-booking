package com.vaishnavi.spring.boot.repository;

import java.util.List;

public interface EntityRepository<T> {
    boolean store(T t);
    boolean delete(int id);
    List<T> retrieve();
    T search(int id);
}


