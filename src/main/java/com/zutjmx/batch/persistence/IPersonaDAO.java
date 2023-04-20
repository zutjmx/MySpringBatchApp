package com.zutjmx.batch.persistence;

import com.zutjmx.batch.entities.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDAO extends CrudRepository<Persona, Long> {

}
