package com.example.spring_data_rounding.repositories;

import com.example.spring_data_rounding.entities.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface UseJpaRepository extends JpaRepository<TestTable, Long> {

    @Query(
            value = "Select coalesce(sum(tt.value), 0) from test_table tt ",
            nativeQuery = true
    )
    BigDecimal getSummedValue();

}
