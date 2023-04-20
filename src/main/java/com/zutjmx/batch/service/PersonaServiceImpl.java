package com.zutjmx.batch.service;

import com.zutjmx.batch.entities.Persona;
import com.zutjmx.batch.persistence.IPersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {


    @Autowired
    private IPersonaDAO personaDAO;

    @Override
    @Transactional
    public void saveAll(List<Persona> personaList) {
        personaDAO.saveAll(personaList);
    }
}
