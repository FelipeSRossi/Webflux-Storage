package com.Storage.Webflux.Storage.service;

import com.Storage.Webflux.Storage.document.Character;
import com.Storage.Webflux.Storage.repository.MainRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class MainService {
    private final MainRepository mainRepository;

    public MainService(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public Flux<Character> findAll() {
        return Flux.fromIterable(this.mainRepository.findAll());
    }

    public Mono<Character> findByIdCharacter(String id) {
        return Mono.justOrEmpty(this.mainRepository.findById(id));
    }

    public Mono<Character> save(Character character) {
        return Mono.justOrEmpty(this.mainRepository.save(character));
    }

    public Mono<Boolean> deleteByIdCharacter(String id) {
        mainRepository.deleteById(id);
        return Mono.just(true);

    }
}
