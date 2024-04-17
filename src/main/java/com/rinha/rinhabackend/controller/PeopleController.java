package com.rinha.rinhabackend.controller;

import com.rinha.rinhabackend.entity.People;
import com.rinha.rinhabackend.service.PeopleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping
@Validated
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @PostMapping("/pessoas")
    public ResponseEntity<?> createPerson(@Valid @RequestBody People people) {
        People newPeople = peopleService.createPerson(people);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location", "/pessoas/" + newPeople.getId().toString());

        return ResponseEntity.created(URI.create(""))
                .headers(responseHeaders)
                .body("");
    }

    @GetMapping("/pessoas/{uuid}")
    public ResponseEntity<?> getPersonById(@PathVariable String uuid) {
        return new ResponseEntity<>(
                peopleService.getPersonById(uuid),
                HttpStatus.OK
        );
    }

    @GetMapping("/pessoas")
    public ResponseEntity<?> getPersonByTerm(@RequestParam(name = "t") String term) {
        return new ResponseEntity<>(
                peopleService.getPersonByTerm(term),
                HttpStatus.OK
        );
    }

    @GetMapping("/contagem-pessoas")
    public ResponseEntity<?> countAllPeople() {
        return new ResponseEntity<>(
                peopleService.countAllPeople(),
                HttpStatus.OK
        );
    }
}
