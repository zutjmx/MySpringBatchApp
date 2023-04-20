package com.zutjmx.batch.config;

import com.zutjmx.batch.steps.ItemReaderStep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfiguration {

    @Bean
    public ItemReaderStep itemReaderStep() {
        return new ItemReaderStep();
    }

}
