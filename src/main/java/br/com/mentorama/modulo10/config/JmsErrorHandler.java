package br.com.mentorama.modulo10.config;

import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Component
public class JmsErrorHandler implements ErrorHandler {
    @Override
    public void handleError(Throwable throwable) {
        System.out.println("Error processing this post" +
                throwable.getMessage());
    }
}