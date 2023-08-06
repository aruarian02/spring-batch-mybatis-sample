package com.example.batch_sample;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
@EnableBatchProcessing
public class BatchSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchSampleApplication.class, args);
    }



}
