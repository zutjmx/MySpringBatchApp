package com.zutjmx.batch.steps;

import com.zutjmx.batch.entities.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Slf4j
public class ItemProcessStep implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        log.info(":::::::: Inicia paso de procesamiento de registros ::::::::");

        List<Persona> personaList = (List<Persona>) chunkContext.getStepContext()
                                                                .getStepExecution()
                                                                .getJobExecution()
                                                                .getExecutionContext()
                                                                .get("personaList");

        List<Persona> personaListFinal = personaList.stream().map(persona -> {
            persona.setFechaInsercion(new Date());
            return persona;
        }).toList();

        chunkContext.getStepContext()
                .getStepExecution()
                .getJobExecution()
                .getExecutionContext()
                .put("personaList",personaListFinal);

        log.info(":::::::: Finaliza paso de procesamiento de registros ::::::::");

        return null;
    }
}
