package com.care4india.restapi;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.postgresql.Driver;
import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("postgres://yasweybg:AHQvaDnFyU9kEsca86cYopbBfkqpyEoh@john.db.elephantsql.com:5432/yasweybg");
        dataSourceBuilder.username("yasweybg");
        dataSourceBuilder.password("AHQvaDnFyU9kEsca86cYopbBfkqpyEoh");
        return dataSourceBuilder.build();
    }
}