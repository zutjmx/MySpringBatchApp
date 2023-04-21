package com.zutjmx.batch.config;

import com.zutjmx.batch.steps.ItemDecompressStep;
import com.zutjmx.batch.steps.ItemProcessStep;
import com.zutjmx.batch.steps.ItemReaderStep;
import com.zutjmx.batch.steps.ItemWriterStep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfiguration {

    @Bean
    public ItemReaderStep itemReaderStep() {
        return new ItemReaderStep();
    }

    @Bean
    public ItemProcessStep itemProcessStep() {
        return new ItemProcessStep();
    }

    @Bean
    public ItemWriterStep itemWriterStep() {
        return new ItemWriterStep();
    }

    @Bean
    public ItemDecompressStep itemDecompressStep() {
        return new ItemDecompressStep();
    }

}
