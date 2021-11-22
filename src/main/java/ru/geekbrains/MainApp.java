package ru.geekbrains;

import ru.geekbrains.daos.ProductDao;
import ru.geekbrains.daos.impl.ProductDaoImpl;
import ru.geekbrains.factories.SessionFactoryUtils;
import ru.geekbrains.model.Product;

import java.util.List;


public class MainApp {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);

            Product product = productDao.findById(1L);
            System.out.println(product.toString());
            System.out.println("---------------");

            List<Product> products= productDao.findAll();
            System.out.println(products.toString());
            System.out.println("---------------");

            productDao.saveOrUpdate(new Product("Tea", 67));
            List<Product> products1= productDao.findAll();
            System.out.println(products1.toString());
            System.out.println("---------------");

            productDao.deleteById(6L);
            List<Product> products2= productDao.findAll();
            System.out.println(products2.toString());
            System.out.println("---------------");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }



}

