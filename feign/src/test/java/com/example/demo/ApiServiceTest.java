package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiServiceTest {


    @Autowired
    private ApiService apiService;

    @Test
    public void test() {
        System.out.println(apiService.index());
    }

}