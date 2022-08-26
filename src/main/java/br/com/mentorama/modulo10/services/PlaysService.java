package br.com.mentorama.modulo10.services;


import br.com.mentorama.modulo10.entities.Plays;
import br.com.mentorama.modulo10.repositories.PlaysRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaysService {

    private PlaysRepository playsRepository;

    public PlaysService(PlaysRepository PlaysRepository){
        this.playsRepository = playsRepository;
    }

    public Mono<Plays> create (Plays plays){
        return playsRepository.save(plays);
    }

    public Mono<Plays> findById(String id){
        return playsRepository.findById(id);
    }

    public Flux<Plays> findAll(){
        return  playsRepository.findAll();

    }

}
