package repositoryInterface;

import org.springframework.data.repository.CrudRepository;

import modello.FirmaGenerale;


public interface FirmaRepository extends CrudRepository<FirmaGenerale, String> {

}
