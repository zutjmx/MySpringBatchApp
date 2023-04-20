package com.zutjmx.batch.service;

import com.zutjmx.batch.entities.Persona;

import java.util.List;

public interface IPersonaService {
    public void saveAll(List<Persona> personaList);
}
