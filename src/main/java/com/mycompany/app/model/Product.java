package com.mycompany.app.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Product implements Entity {
    private int id;
    private ProductType productType;
    private String description;
    private double value;

    public Product(int id, ProductType productType, String description, double value) {
        this.id = id;
        this.productType = productType;
        this.description = description;
        this.value = value;
    }

    public Product(ResultSet rs) throws SQLException {
        super();
        this.id = rs.getInt("id");
        this.description = rs.getString("description");
        this.value = Double.parseDouble(rs.getString("value"));
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public ProductType getProductType() {
        return productType;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Método para construir a partir de ResultSet
    @Override
    public Entity constructFromResultSet(ResultSet rs) throws SQLException {
        return new Product(rs);
    }

    // Método para preparar a instrução SQL
    @Override
    public PreparedStatement prepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, getId());
        preparedStatement.setInt(2, getProductType().getId());
        preparedStatement.setString(3, getDescription());
        preparedStatement.setDouble(4, getValue());
        return preparedStatement;
    }

    // Método toString para representação textual
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productType=" + productType.getDescription() +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }

}
