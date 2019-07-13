package com.example.springbootredis.service;

import com.example.springbootredis.model.entity.Person;

public interface CacheService {

    Person findPerson(Integer id);
    Person savePerson(Person person);
    void deletePerson(Integer id);

}
