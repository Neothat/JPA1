package ru.geekbrains.daos;

import ru.geekbrains.model.Product;

import java.util.List;

public interface ProductDao {
    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    void saveOrUpdate(Product product);
}
