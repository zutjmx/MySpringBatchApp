package com.zutjmx.batch.steps;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.zutjmx.batch.entities.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.io.FileReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class ItemReaderStep implements Tasklet {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info(":::::::: Inicia paso de lectura ::::::::");

        Reader reader = new FileReader(resourceLoader
                .getResource("classpath:files/destination/personas.csv")
                .getFile());

        CSVParser csvParser = new CSVParserBuilder()
                .withSeparator(',')
                .build();

        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build();

        List<Persona> personaList = new ArrayList<>();
        String[] lineaActual;

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        while ((lineaActual = csvReader.readNext()) != null) {
            Date fechaNacimiento = formato.parse(lineaActual[4]);
            Persona persona = new Persona();

            persona.setNombre(lineaActual[0]);
            persona.setAPaterno(lineaActual[1]);
            persona.setAMaterno(lineaActual[2]);
            persona.setEmail(lineaActual[3]);
            persona.setFechaNacimiento(fechaNacimiento);

            personaList.add(persona);
        }

        csvReader.close();
        reader.close();

        log.info(":::::::: Finaliza paso de lectura ::::::::");

        return RepeatStatus.FINISHED;
    }
}
