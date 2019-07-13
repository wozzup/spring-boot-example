package com.example.springbootredis;

import com.example.springbootredis.model.entity.Person;
import com.example.springbootredis.service.CacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheServiceTests {

    @Autowired
    private CacheService cacheService;

    @Test
    public void findPersonTest() {
        System.out.println(cacheService.findPerson(1)); // 进入方法
        System.out.println(cacheService.findPerson(1)); // 访问缓存
        System.out.println(cacheService.findPerson(1)); // 访问缓存
    }

    @Test
    public void savePersonTest() {
        System.out.println(cacheService.savePerson(new Person(5, "p5", 23))); // 进入方法
        System.out.println(cacheService.findPerson(5)); // 访问缓存
        System.out.println(cacheService.findPerson(5)); // 访问缓存
        System.out.println(cacheService.findPerson(5)); // 访问缓存
    }

    @Test
    public void deletePersonTest() {
        cacheService.deletePerson(5); // 进入方法
        cacheService.deletePerson(5); // 进入方法
        cacheService.deletePerson(5); // 进入方法
    }

}
