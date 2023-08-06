package com.example.batch_sample.config;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*
    Spring batch 메타 테이블 생성하지 않기.

    DefaultBatchConfigurer 클래스를 상속받은 Config 클래스를 만들어 주고
    setDataSource 메소드를 오버라이딩 후 공백으로 남겨둔다.
 */
@Configuration
class CustomBatchConfigurer extends DefaultBatchConfigurer {
    @Override
    public void setDataSource(DataSource dataSource) {

    }
}