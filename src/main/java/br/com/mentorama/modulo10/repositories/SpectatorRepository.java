package br.com.mentorama.modulo10.repositories;


import br.com.mentorama.modulo10.entities.Spectator;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
public interface SpectatorRepository extends ReactiveCrudRepository<Spectator, String>{
}
