package com.example.springbootredis.service.impl;

import com.example.springbootredis.model.entity.Person;
import com.example.springbootredis.service.CacheService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheServiceImpl implements CacheService {

    private static final Map<Integer, Person> database = new HashMap<>();

    static {
        database.put(1, new Person(1, "p1", 19));
        database.put(2, new Person(2, "p2", 20));
        database.put(3, new Person(3, "p3", 21));
        database.put(4, new Person(4, "p4", 22));
    }

    /**
     * 根据方法的请求参数对其结果进行缓存
     */
    @Cacheable(value = "person", key = "#id")
    @Override
    public Person findPerson(Integer id) {
        System.out.println("进入 findPerson() 方法");
        return database.get(id);
    }

    /**
     * 根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的是，它每次都会触发真实方法的调用
     */
    @CachePut(value = "person", key = "#person.id")
    @Override
    public Person savePerson(Person person) {
        System.out.println("进入 savePerson() 方法");
        database.put(person.getId(), person);
        return person;
    }

    /**
     * 根据条件对缓存进行清空
     */
    @CacheEvict(value = "person", key = "#id")
    @Override
    public void deletePerson(Integer id) {
        System.out.println("进入 deletePerson() 方法");
        database.remove(id);
    }

}
