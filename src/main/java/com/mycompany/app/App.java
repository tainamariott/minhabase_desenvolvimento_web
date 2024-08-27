package com.mycompany.app;

import com.mycompany.app.controller.HelloWordHandler;
import com.mycompany.app.dao.ProductTypeDAO;
import com.mycompany.app.dao.saleDAO;
import com.mycompany.app.model.ProductType;
import com.mycompany.app.model.Sale;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class App
{
    public static void main( String[] args ){

        try{
            HttpServer servidor = HttpServer.create(
                    new InetSocketAddress( 8080),0
            );

            servidor.createContext("/helloWorld",
                    new HelloWordHandler());

            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/baseweb", "postgres", "0403tcm"
            );

            saleDAO saleDAO = new saleDAO(connection);
            Sale sale = saleDAO.getById(1);
            sale.setSaleItems(saleDAO.getSaleItemsBySaleId(1));

            ProductTypeDAO productTypeDAO = new ProductTypeDAO(connection);

            productTypeDAO.getAll().forEach(System.out::println);
            productTypeDAO.upsert(new ProductType(0, "Teste"));
            productTypeDAO.getAll().forEach(System.out::println);
            productTypeDAO.upsert(new ProductType(4, "Teste 2"));
            productTypeDAO.getAll().forEach(System.out::println);
            System.out.println(productTypeDAO.getById(1));
            productTypeDAO.delete(5);
            productTypeDAO.getAll().forEach(System.out::println);


            servidor.setExecutor(null);
            servidor.start();
            System.out.println("Servidor rodando na porta 8080");
        }catch( IOException e ){
            System.out.println(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
