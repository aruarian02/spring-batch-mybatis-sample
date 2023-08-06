package com.example.batch_sample.config;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.mybatis.spring.batch.builder.MyBatisPagingItemReaderBuilder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Log4j2
@Configuration
public class SampleJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final SqlSessionFactory sqlSessionFactory;

    @Autowired
    public SampleJobConfig(JobBuilderFactory jobBuilderFactory,
                           StepBuilderFactory stepBuilderFactory,
                           SqlSessionFactory sqlSessionFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Bean
    public Job sampleJob(Step sampleStep) {
        return jobBuilderFactory.get("sampleJob")
                .start(sampleStep)
                .build();
    }

    @JobScope
    @Bean
    public Step sampleStep(ItemReader<String> reader) {
        return stepBuilderFactory.get("sampleStep")
                .<String, String>chunk(1)
                .reader(reader)
                .processor(new ItemProcessor<String, String>() {
                    @Override
                    public String process(String item) throws Exception {
                        log.info(item);
                        return null;
                    }
                })
                .writer(new ItemWriter<String>() {
                    @Override
                    public void write(List<? extends String> items) throws Exception {

                    }
                })
                .build();
    }

    @StepScope
    @Bean
    public MyBatisPagingItemReader<String> reader() {
        return new MyBatisPagingItemReaderBuilder<String>()
                .pageSize(100)
                .sqlSessionFactory(sqlSessionFactory)
                .queryId("com.example.batch_sample.mapper.BatchMapper.selectAllBoardContent")
                //.parameterValues()
                .build();
    }
}
