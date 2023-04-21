package com.zutjmx.batch.config;

import com.zutjmx.batch.steps.ItemDecompressStep;
import com.zutjmx.batch.steps.ItemProcessStep;
import com.zutjmx.batch.steps.ItemReaderStep;
import com.zutjmx.batch.steps.ItemWriterStep;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfiguration {

    @Autowired
    public JobBuilder jobBuilder;

    @Autowired
    public StepBuilder stepBuilder;

    @Bean
    @JobScope
    public ItemDecompressStep itemDecompressStep() {
        return new ItemDecompressStep();
    }

    @Bean
    @JobScope
    public ItemReaderStep itemReaderStep() {
        return new ItemReaderStep();
    }

    @Bean
    @JobScope
    public ItemProcessStep itemProcessStep() {
        return new ItemProcessStep();
    }

    @Bean
    @JobScope
    public ItemWriterStep itemWriterStep() {
        return new ItemWriterStep();
    }

    @Bean
    public Step descompressFileStep() {
        /*return stepBuilderFactory.get("descompressFileStep")
                .tasklet(itemDescompressStep())
                .build();*/

        return null;
    }

}
