package br.com.mentorama.modulo10.services;

import br.com.mentorama.modulo10.entities.Spectator;
import br.com.mentorama.modulo10.repositories.SpectatorRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class SpectatorService {


    private SpectatorRepository spectatorRepository;

    public SpectatorService(SpectatorRepository spectatorRepository ){
        this.spectatorRepository  = spectatorRepository;
    }

    public Mono<Spectator> create (Spectator spectator){
        return spectatorRepository .save(spectator);
    }

    public Mono<Spectator> findById (String id) {
        return spectatorRepository .findById(id);
    }

    public Flux<Spectator> findAll(){
        return spectatorRepository .findAll();
    }
}
