package com.example.spring_data_rounding.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.math.BigDecimal;

@Entity
public class TestTable {

    @Id
    private long id;

    private BigDecimal value;
}
