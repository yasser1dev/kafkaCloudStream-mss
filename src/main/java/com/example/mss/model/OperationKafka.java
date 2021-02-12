package com.example.mss.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class OperationKafka {
    private Integer numero;
    private Date dateOperation;
    private double montant;
    private TypeOperation typeOperation;
    private long  id_compte;
}

