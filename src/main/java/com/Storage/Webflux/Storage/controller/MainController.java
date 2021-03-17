package com.Storage.Webflux.Storage.controller;

import com.Storage.Webflux.Storage.document.Character;
import com.Storage.Webflux.Storage.repository.MainRepository;
import com.Storage.Webflux.Storage.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.Storage.Webflux.Storage.constants.MainConstants.MAIN_ENDPOINT_LOCAL;




@RestController
@Slf4j
public class MainController {
    MainService mainService;
    MainRepository mainRepository;

    private static final org.slf4j.Logger log=
            org.slf4j.LoggerFactory.getLogger(MainController.class);

    public MainController(MainService mainService, MainRepository mainRepository){
        this.mainRepository = mainRepository;
        this.mainService = mainService;

    }

    @GetMapping(MAIN_ENDPOINT_LOCAL)
    @ResponseStatus(code = HttpStatus.OK)
        public Flux<Character> getAllItems (){
        log.info("requesting character list");
        return mainService.findAll();
    }

    @GetMapping(MAIN_ENDPOINT_LOCAL + "/{id}")
        public Mono <ResponseEntity<Character>>findIdCharacter(@PathVariable String id){
        log.info("requesting character {}", id);
        return mainService.findByIdCharacter(id)
                .map((item)-> new ResponseEntity<>(item,HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(MAIN_ENDPOINT_LOCAL)
    @ResponseStatus(code = HttpStatus.CREATED)
        public Mono <Character> createCharacter(@RequestBody Character character){
            log.info("a new character was added");
            return mainService.save(character);
         }


    @DeleteMapping(MAIN_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono <HttpStatus> deleteByIDCharacter(@PathVariable String id){
        mainService.deleteByIdCharacter(id);
        log.info("removing character {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}
