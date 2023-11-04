package com.rinha.rinhabackend.service;


import com.rinha.rinhabackend.entity.People;
import com.rinha.rinhabackend.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PeopleServiceImpl implements PeopleService{

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    @Override
    public People createPerson(People people) {
        Optional<People> personExists = peopleRepository.findByNickname(people.getNickname());

        if (personExists.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        People newPerson = new People(
                people.getNickname(),
                people.getName(),
                people.getBirth(),
                people.getStack()
        );

        return peopleRepository.save(newPerson);
    }

    @Override
    public People getPersonById(String uuid) {
        return peopleRepository.findById(UUID.fromString(uuid))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<People> getPersonByTerm(String term) {
        return peopleRepository.findByConcatenatedContaining(term)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Long countAllPeople() {
        return peopleRepository.findAll().stream().count();
    }
}
