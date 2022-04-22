package study.dliga.cache.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import study.dliga.cache.AbstractTest;
import study.dliga.cache.service.UserCacheService;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class HibernateUserCacheServiceImplTest extends AbstractTest {

    @Autowired
    @Qualifier("HibernateCache")
    private UserCacheService service;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void findByName() {
        log.info("Start finding by name.....");
        service.findByName("vasya");
    }

    @Test
    void findByNameSecondLvlCache() {
        log.info("Start finding by name.....");
        service.findByNameHibernate("vasya");
        service.findByNameHibernate("vasya");
        service.findByNameHibernate("vasya");
    }

    @Test
    void findByIdSecondLvlCache() {
        log.info("Start finding by id ................");
        service.findByIdHibernate(39L);
        service.findByIdHibernate(39L);
        service.findByIdHibernate(39L);
    }

    @Test
    void findByIdFirstLvlCache() {
        log.info("Start finding by id ................");
        service.findById(39L);
    }
}