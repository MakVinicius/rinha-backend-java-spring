package com.rinha.rinhabackend.controller;

import com.rinha.rinhabackend.entity.People;
import com.rinha.rinhabackend.service.PeopleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @PostMapping("/pessoas")
    public ResponseEntity<?> createPerson(@Valid @RequestBody People people) {
        peopleService.createPerson(people);
        return new ResponseEntity<>(
                "",
                HttpStatus.CREATED
        );
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
