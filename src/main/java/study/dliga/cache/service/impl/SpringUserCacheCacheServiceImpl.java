package study.dliga.cache.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.dliga.cache.model.UserElement;
import study.dliga.cache.model.UserMapper;
import study.dliga.cache.repository.UserRepository;
import study.dliga.cache.repository.entity.User;
import study.dliga.cache.service.UserCacheService;

import java.util.List;


@Slf4j
@Component("springCache")
@RequiredArgsConstructor
@Transactional
public class SpringUserCacheCacheServiceImpl implements UserCacheService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CacheManager cacheManager;


    @Override
    public void save(UserElement userElement) {
        log.info("Save user whit name: {}, without cache", userElement.getName());
        userRepository.save(userMapper.userElementToUser(userElement));
    }

    @Override
    @CachePut(value = "users")
    public List<User> saveAllAndPutInCache(List<UserElement> userElements) {
        log.info("Save all userS and put this in cache");
        return userRepository.saveAll(userMapper.userElementsToUsers(userElements));
    }

    @Override
    @Cacheable(value = "users")
    public UserElement findByName(String name) {
        log.info("Finding user by id: {}", name);
        return userMapper.userToUserElement(userRepository.findByName(name).get());
    }

    @Override
    public void findByNameHibernate(String name) {

    }

    @Override
    public UserElement findById(Long id) {
        return null;
    }

    @Override
    public List<UserElement> findAll() {
        log.info("Finding all users NO CACHE");
        return findAllAndPutInCache();
    }

    @Override
    @Cacheable(value = "users")
    public List<User> findAllUsersAndPutInCache() {
        log.info("Finding all users and put in cache");
        return userRepository.findAll();
    }

    @Override
    @Cacheable(value = "users", key = "#root.caches[0].name")
    public List<UserElement> findAllAndPutInCache() {
        log.info("Finding all users and put in cache");
        return userMapper.usersToUserElements(userRepository.findAll());
    }


    @Override
    public void delete(String name) {
        userRepository.deleteByName(name);
    }

    @Override
    @CacheEvict("users")
    public void deleteAndEvict(String name) {
        userRepository.deleteByName(name);
    }

    @Override
    public void findByIdHibernate(Long id) {

    }
}