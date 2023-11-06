package com.rinha.rinhabackend.service;


import com.rinha.rinhabackend.entity.People;

import java.util.List;

public interface PeopleService {

    People createPerson(People people);

    People getPersonById(String uuid);

    List<People> getPersonByTerm(String term);

    Long countAllPeople();
}
