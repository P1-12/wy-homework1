package com.example.wyhomework1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class WyHomework1ApplicationTests {
    @Autowired
    private DataSource dataSource;


    @Test
    void contextLoads() {
    }

    @Test
    void getConnection() throws SQLException {
        System.err.println(dataSource.getConnection());
    }
}
