package br.com.mentorama.modulo10.controllers;


import br.com.mentorama.modulo10.entities.Plays;
import br.com.mentorama.modulo10.services.PlaysService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/plays")
public class PlaysController {


    private PlaysService playsService;
    private JmsTemplate jmsTemplate;

    public PlaysController(PlaysService playsService, JmsTemplate jmsTemplate){
        this.playsService = playsService;
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping
    public Mono<ResponseEntity<Void>> create (@RequestBody Plays plays ) {
        jmsTemplate.convertAndSend("Plays", plays);
        System.out.println("Film rating sent to the queue");
        return playsService.create(plays).map(
                peça -> new ResponseEntity<Void>(HttpStatus.CREATED));
    }

    @GetMapping
    public Flux<Plays> findAll(){
        return playsService.findAll();

    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity <Plays>> findById(@PathVariable("id") String id){
        return playsService.findById(id)
                .map(peça-> new ResponseEntity<>(peça, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}