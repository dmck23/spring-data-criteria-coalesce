package com.example.spring_data_rounding.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class TestTable {

    @Id
    private long id;

    private BigDecimal value;
}
