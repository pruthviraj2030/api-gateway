package com.suretrust.gateway.gateway.services;

import com.suretrust.gateway.gateway.exception.AuthenticationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final WebClient.Builder webClientBuilder;

    public Mono<User> getUser(HttpHeaders headers){

        return webClientBuilder.build().get()
                .uri("http://user-detail/user-detail/users")
                .headers(h -> h.addAll(headers))
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> Mono.error(new AuthenticationException("Login expired. Please try logout and login")))
                .bodyToMono(User.class);

    }
}
