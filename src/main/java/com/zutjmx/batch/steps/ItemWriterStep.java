package com.zutjmx.batch.steps;

import com.zutjmx.batch.entities.Persona;
import com.zutjmx.batch.service.IPersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class ItemWriterStep implements Tasklet {

    @Autowired
    private IPersonaService personaService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        log.info(":::::::: Inicia paso de escritura de registros ::::::::");

        List<Persona> personaList = (List<Persona>) chunkContext.getStepContext()
                                                                .getStepExecution()
                                                                .getJobExecution()
                                                                .getExecutionContext()
                                                                .get("personaList");

        personaList.forEach(persona -> {
            if(persona != null) {
                log.info(persona.toString());
            }
        });

        personaService.saveAll(personaList);

        log.info(":::::::: Inicia paso de finaliza de registros ::::::::");

        return RepeatStatus.FINISHED;
    }
}
