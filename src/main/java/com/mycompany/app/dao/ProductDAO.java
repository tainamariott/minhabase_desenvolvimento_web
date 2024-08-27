package com.mycompany.app.dao;

import com.mycompany.app.model.Product;
import com.mycompany.app.model.ProductType;

import java.sql.Connection;
import java.util.List;

public class ProductDAO extends GenericDaoImpl<Product> implements GenericDAO<Product> {

    private Connection connection;
    private final String TABLE_NAME = "product_type";

    private final List<String> COLUMNS = List.of("description", "value", "productType");

    public ProductDAO(Connection connection) {
        super(Product::new, connection);
        super.tableName = TABLE_NAME;
        super.columns = COLUMNS;
    }

}
