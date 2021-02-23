package com.prova.demo.repositoryInterface;

import com.prova.demo.modello.Volontario;

import org.springframework.data.repository.CrudRepository;

public interface VolontarioRepository extends CrudRepository<Volontario,Long> {

}
