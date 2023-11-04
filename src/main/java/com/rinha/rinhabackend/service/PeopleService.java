package com.rinha.rinhabackend.service;


import com.rinha.rinhabackend.entity.People;

import java.util.List;
import java.util.UUID;

public interface PeopleService {

    People createPerson(People people);

    People getPersonById(String uuid);

    Long countAllPeople();

    List<People> getPersonByTerm(String term);
}
