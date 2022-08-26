package br.com.mentorama.modulo10.controllers;

import br.com.mentorama.modulo10.entities.Spectator;
import br.com.mentorama.modulo10.services.SpectatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping ("/spec")
public class SpectatorController {


    private SpectatorService spectatorService;

    private JmsTemplate jmsTemplate;

    public SpectatorController(SpectatorService spectatorService, JmsTemplate jmsTemplate) {
        this.spectatorService = spectatorService;
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping
    public Mono<ResponseEntity<Void>> create(@RequestBody Spectator spectator) {
        jmsTemplate.convertAndSend("Spectator", spectator);
        System.out.println("registered spectator");
        return spectatorService.create(spectator).map(user -> new ResponseEntity<Void>(HttpStatus.CREATED));
    }

    @GetMapping
    public Flux<Spectator> findAll() {
        return spectatorService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Spectator>> findById(@PathVariable("id") String id) {
        return spectatorService.findById(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
