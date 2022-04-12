package com.vemser.mongodb.homework_aula_3;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataBase {
    String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
    MongoClient mongoClient = MongoClients.create(uri);

    MongoDatabase mongoDatabase = mongoClient.getDatabase("homework_aula_3");
    MongoCollection<Document> funcionarios = mongoDatabase.getCollection("funcionarios");
    MongoCollection<Document> vendas = mongoDatabase.getCollection("vendas");

    public void init() {



        Document funcionario2 = new Document();
        funcionario2.append("nome", "João");
        funcionario2.append("idade", "35");
        funcionario2.append("sexo", "M");
        funcionario2.append("salario", "1000");
        funcionario2.append("cargo", "vendedor");

        funcionarios.insertOne(funcionario2);

        Document funcionario3 = new Document();
        funcionario3.append("nome", "Bianca");
        funcionario3.append("idade", "45");
        funcionario3.append("sexo", "F");
        funcionario3.append("salario", "1200");
        funcionario3.append("cargo", "vendedor");

        funcionarios.insertOne(funcionario3);

        Document funcionario4 = new Document();
        funcionario4.append("nome", "Carolina");
        funcionario4.append("idade", "27");
        funcionario4.append("sexo", "F");
        funcionario4.append("salario", "1200");
        funcionario4.append("cargo", "vendedor");

        funcionarios.insertOne(funcionario4);

        Document funcionario5 = new Document();
        funcionario5.append("nome", "Pedro");
        funcionario5.append("idade", "33");
        funcionario5.append("sexo", "M");
        funcionario5.append("salario", "2200");
        funcionario5.append("cargo", "vendedor");

        funcionarios.insertOne(funcionario5);

        Document venda1 = new Document();
        venda1.append("produto", "Notebook");
        venda1.append("quantidade", "2");
        venda1.append("valor", "2000");
        venda1.append("vendedor", funcionario2);
        venda1.append("data",  LocalDate.parse("12/08/1984", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        vendas.insertOne(venda1);

        Document venda2 = new Document();
        venda2.append("produto", "TV");
        venda2.append("quantidade", "1");
        venda2.append("valor", "3000");
        venda2.append("vendedor", funcionario3);
        venda2.append("data",  LocalDate.parse("12/08/1984", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        vendas.insertOne(venda2);

        Document venda3 = new Document();
        venda3.append("produto", "Geladeira");
        venda3.append("quantidade", "1");
        venda3.append("valor", "4000");
        venda3.append("vendedor", funcionario4);
        venda3.append("data",  LocalDate.parse("12/08/2010", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        vendas.insertOne(venda3);

        Document venda4 = new Document();
        venda4.append("produto", "Fogão");
        venda4.append("quantidade", "1");
        venda4.append("valor", "750");
        venda4.append("vendedor", funcionario4);
        venda4.append("data",  LocalDate.parse("12/08/2005", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        vendas.insertOne(venda4);

        Document venda5 = new Document();
        venda5.append("produto", "Balcão");
        venda5.append("quantidade", "3");
        venda5.append("valor", "950");
        venda5.append("vendedor", funcionario5);
        venda5.append("data",  LocalDate.parse("12/08/2012", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        vendas.insertOne(venda5);


        Document venda6 = new Document();
        venda6.append("produto", "Pia");
        venda6.append("quantidade", "1");
        venda6.append("valor", "850");
        venda6.append("vendedor", funcionario5);
        venda6.append("data",  LocalDate.parse("22/07/2014", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        vendas.insertOne(venda6);


    }


    public void close(){
        mongoClient.close();
    }

}