package com.prova.demo.repositoryInterface;

import com.prova.demo.modello.FirmaGenerale;

import org.springframework.data.repository.CrudRepository;


public interface FirmaRepository extends CrudRepository<FirmaGenerale, String> {

}
