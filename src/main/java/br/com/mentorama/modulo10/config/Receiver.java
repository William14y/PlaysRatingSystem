package br.com.mentorama.modulo10.config;

import br.com.mentorama.modulo10.entities.Plays;
import br.com.mentorama.modulo10.entities.Spectator;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver{

    @JmsListener(destination = "Plays", containerFactory = "myFactory")
    public void receiveRating(Plays plays){
        if(plays.getSpectatorId()==null){
            throw new RuntimeException("Play rating nonexistent");
        }
        System.out.println("Play rating received from the queue <" + plays +">");
    }

    @JmsListener(destination = "Spectator", containerFactory = "myFactory")
    public void receiveSpectator(Spectator spectator){
        if(spectator.getName()==null){
            throw new RuntimeException("Spectator nonexistent");
        }
        System.out.println("Spectator Registration received from the queue <" + spectator +">");
    }

}
