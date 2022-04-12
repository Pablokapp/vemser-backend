package com.dbc.veiculoprodutorconsumidor.repository;


import com.dbc.veiculoprodutorconsumidor.entity.Registro;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroRepository extends MongoRepository<Registro, String> {

    List<Registro> findAll();



    @Aggregation(pipeline = {
            "{'$group':{ '_id': 'null', 'sum' : {'$sum': $velocidade} }}"
    })
    Double findVelocidadeTotal();

    @Aggregation(pipeline = { "{$group: { _id: '', mediaVelocidade: {$avg: $velocidade }}}" })
    Double findVelocidadeMedia();

    @Aggregation(pipeline = { "{$group: { _id: '', mediaRotacao: {$avg: $rotacao }}}" })
    Double mediaRotacao();






}
