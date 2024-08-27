package com.mycompany.app.dao;

import com.mycompany.app.model.ProductType;
import com.mycompany.app.model.SaleItem;

import java.sql.Connection;
import java.util.List;

public class SaleItemDAO extends GenericDaoImpl<SaleItem> implements GenericDAO<SaleItem>  {

    private Connection connection;
    private final String TABLE_NAME = "saleItem";

    private final List<String> COLUMNS = List.of("product", "quantity", "percentualDiscount");

    public SaleItemDAO(Connection connection) {
        super(SaleItem::new, connection);
        super.tableName = TABLE_NAME;
        super.columns = COLUMNS;
    }


}
