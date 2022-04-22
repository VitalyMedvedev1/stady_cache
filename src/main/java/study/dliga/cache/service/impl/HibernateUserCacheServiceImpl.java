package study.dliga.cache.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.dliga.cache.model.UserElement;
import study.dliga.cache.model.UserMapper;
import study.dliga.cache.repository.UserRepository;
import study.dliga.cache.repository.entity.User;
import study.dliga.cache.service.UserCacheService;

import java.util.List;

@Slf4j
@Component("HibernateCache")
@RequiredArgsConstructor
public class HibernateUserCacheServiceImpl implements UserCacheService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CacheManager cacheManager;

    @Override
    public void save(UserElement userElement) {

    }

    @Override
    public List<User> saveAllAndPutInCache(List<UserElement> userElements) {
        return null;
    }

    @Override
    @Transactional
    public UserElement findByName(String name) {
        findByNameHibernate(name);
        findByNameHibernate(name);
        findByNameHibernate(name);
        return null;
    }

    @Override
    @Transactional
    public void findByNameHibernate(String name){
        log.info("FIND IN DATABASE");
        userRepository.findByName(name);
    }

    @Override
    @Transactional
    public UserElement findById(Long id) {
        findByIdHibernate(id);
        findByIdHibernate(id);
        findByIdHibernate(id);
        return null;
    }

    public void findByIdHibernate(Long id){
        log.info("FIND IN DATABASE");
        userRepository.findById(id);
    }

    @Override
    public List<UserElement> findAll() {
        return null;
    }

    @Override
    public List<UserElement> findAllAndPutInCache() {
        return null;
    }

    @Override
    public List<User> findAllUsersAndPutInCache() {
        return null;
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public void deleteAndEvict(String name) {

    }
}
