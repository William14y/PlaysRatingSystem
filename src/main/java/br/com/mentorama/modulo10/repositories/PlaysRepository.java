package br.com.mentorama.modulo10.repositories;


import br.com.mentorama.modulo10.entities.Plays;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
public interface PlaysRepository extends ReactiveCrudRepository<Plays, String> {
}
