package com.vemser.mongodb.homework_aula_3;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import jdk.swing.interop.SwingInterOpUtils;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;

@SpringBootApplication
public class HomeworkAula3Application {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkAula3Application.class, args);

        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("homework_aula_3");
        MongoCollection<Document> funcionarios = mongoDatabase.getCollection("funcionarios");
        MongoCollection<Document> vendas = mongoDatabase.getCollection("vendas");

        DataBase dataBase = new DataBase();

        dataBase.init();



        System.out.println("\n============== FIND ==============\n");
        System.out.println("\nListar todos os funcionarios");
        funcionarios.find().forEach(System.out::println);

        System.out.println("\n Listar funcionarios por nome em ordem alfabetica");
        funcionarios.find().sort(new Document("nome", 1)).forEach(System.out::println);

        System.out.println("\n Listar funcionarios que o nome começa com a letra 'J'");
        funcionarios.find(new Document("nome", new Document("$regex", "^J"))).forEach(System.out::println);

        System.out.println("\nListar todas as vendas");
        vendas.find().forEach(System.out::println);

        System.out.println("\nListar todas as vendas de um funcionario");
        vendas.find(new Document("vendedor.nome", "João")).forEach(System.out::println);

        System.out.println("\n Listar vendas a partir de uma data");
        vendas.find( new Document("data", new Document("$gte",LocalDate.parse("01/01/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy"))))).forEach(System.out::println);

        System.out.println("\n Listar funcionarios com salario maior que 1400");
        funcionarios.find(new Document("salario", new Document("$gt", 1400))).forEach(System.out::println);


        System.out.println("\n============== INSERT ==============\n");
        System.out.println("\nInserir um novo funcionario");
        System.out.println("\nLista de funcionarios antes da insercao");
        funcionarios.find().forEach(System.out::println);
        funcionarios.insertOne(new Document("nome", "Maria").append("salario", 1380.0).append("cargo", "Vendedor").append("idade", 22).append("sexo", "F"));
        System.out.println("\nLista de funcionarios depois da insercao");
        funcionarios.find().forEach(System.out::println);

        System.out.println("\nInserir uma nova venda");
        System.out.println("\nLista de vendas antes da insercao");
        vendas.find().forEach(System.out::println);
        vendas.insertOne(new Document("Produto", "Sofá")
                        .append("valor", 6000.0)
                        .append("quantidade", 2)
                .append("vendedor", (funcionarios.find(new Document("nome","Carolina")).first())));
        System.out.println("\nLista de vendas depois da insercao");
        vendas.find().forEach(System.out::println);


        System.out.println("\nInserir várias vendas para um funcionario");
        System.out.println("\nLista de vendas antes da insercao");
        vendas.find(new Document("vendedor.nome", "João")).forEach(System.out::println);
        List<Document> lista = new ArrayList<>();
        lista.add(new Document("Produto", "Tapete").append("valor", 300.0).append("quantidade", 2).append("vendedor", (funcionarios.find(new Document("nome","João")).first())));
        lista.add(new Document("Produto", "Cafeteira").append("valor", 100.0).append("quantidade", 1).append("vendedor", (funcionarios.find(new Document("nome","João")).first())));
        lista.add(new Document("Produto", "Cadeira").append("valor", 500.0).append("quantidade", 3).append("vendedor", (funcionarios.find(new Document("nome","João")).first())));
        vendas.insertMany(lista);

        System.out.println("\nVendas Inseridas");
        vendas.find(new Document("vendedor.nome", "João")).forEach(System.out::println);


        System.out.println("\n============== UPDATE ==============\n");
        System.out.println("\nAtualizar o salario de um funcionario");
        funcionarios.updateOne(new Document("nome", "Maria"), new Document("$set", new Document("salario", 1500.0)));
        System.out.println("\n"+funcionarios.find(new Document("nome", "Maria")).first()+"\n");
        System.out.println("\nAtualizar o cargo de um funcionario");
        funcionarios.updateOne(new Document("nome", "Maria"), new Document("$set", new Document("cargo", "Gerente")));
        System.out.println("\n"+funcionarios.find(new Document("nome", "Maria")).first()+"\n");



        System.out.println("\n============== PORJECTION ==============\n");;
        System.out.println("\nListar todos os funcionarios com o nome e o salario");
        funcionarios.find().projection(new Document("nome", 1).append("salario", 1)).forEach(System.out::println);
        System.out.println("\nListar todos os funcionarios com nome e o cargo");
        funcionarios.find().projection(new Document("nome", 1).append("cargo", 1)).forEach(System.out::println);
        System.out.println("\nListar todos os funcionarios com nome cargo e a idade");
        funcionarios.find().projection(new Document("nome", 1).append("cargo", 1).append("idade", 1)).forEach(System.out::println);


        System.out.println("\n============== AGGREGATION ==============\n");
        System.out.println("\nListar todas as vendas de todos os funcionarios somando o valor total");
        vendas.aggregate(Arrays.asList(
                match(Filters.all("vendedor.cargo", "vendedor")),
                group("$vendedor.nome", sum("total", "$valor"))
        )).forEach(System.out::println);

        System.out.println("\n============== DELETE ==============\n");
        System.out.println("\nDeletar todos os funcionarios");
        funcionarios.deleteMany(new Document());
        System.out.println("\nDeletar todas as vendas");
        vendas.deleteMany(new Document());

        System.out.println("\nListar todos os funcionarios\n");
        funcionarios.find().forEach(System.out::println);
        System.out.println("\nListar todas as vendas\n");
        vendas.find().forEach(System.out::println);



        dataBase.close();
    }




}
