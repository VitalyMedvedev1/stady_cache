package study.dliga.cache.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import study.dliga.cache.AbstractTest;
import study.dliga.cache.model.UserElement;
import study.dliga.cache.service.UserCacheService;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class UserCacheServiceTest extends AbstractTest {

    @Autowired
    @Qualifier("springCache")
    private UserCacheService service;

    @Autowired
    private ApplicationContext applicationContext;


    @Test
    void saveAndPut() {
        List<UserElement> userElements = Arrays.asList(
                new UserElement("vasya", "vasya"),
                new UserElement("petya", "vasya")
        );
        service.saveAllAndPutInCache(userElements);
    }

    @Test
    void findAllAndPutInChache() {
        log.info("FIND FIRST");
        service.findAllAndPutInCache();

        log.info("FIND SECOND");
        service.findAllAndPutInCache();

        System.out.println(123);
    }
}