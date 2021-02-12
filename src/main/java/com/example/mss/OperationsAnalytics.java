package com.example.mss;

import com.example.mss.model.OperationKafka;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.function.Function;

@Service
public class OperationsAnalytics {
    @Bean
    public Function<KStream<String, OperationKafka>,KStream<String,String>> CountOperationsPerCompte(){
        return (inputStream)->inputStream
                .map((key,value)->new KeyValue<>(String.valueOf(value.getId_compte()),1))
                .groupByKey(Serialized.with(Serdes.String(),Serdes.Integer()))
                .windowedBy(TimeWindows.of((Duration.ofMillis(5000))))
                .count(Materialized.as("CountOperationsPerCompte"))
                .toStream().map((k,v)-> new KeyValue<>(k.toString(),v.toString()));
    }
}
