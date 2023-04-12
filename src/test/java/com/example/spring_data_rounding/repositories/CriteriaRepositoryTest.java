package com.example.spring_data_rounding.repositories;

import com.example.spring_data_rounding.AbstractIntegrationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CriteriaRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    CriteriaRepository criteriaRepository;

    @Test
    public void getSummedData() {
        BigDecimal result = criteriaRepository.getSummedValue();

        assertThat(result, equalTo(BigDecimal.valueOf(2429.6030356778)));
    }

    @Test
    public void getCoalesceSummedValue() {
        BigDecimal result = criteriaRepository.getCoalesceSummedValue();

        assertThat(result, equalTo(BigDecimal.valueOf(2429.6030356778)));
    }
}
