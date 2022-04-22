package study.dliga.cache.service;

import study.dliga.cache.model.UserElement;
import study.dliga.cache.repository.entity.User;

import java.util.List;

public interface UserCacheService {
    void save(UserElement userElement);

    List<User> saveAllAndPutInCache(List<UserElement> userElements);

    UserElement findByName(String name);

    void findByNameHibernate(String name);

    UserElement findById(Long id);

    List<UserElement> findAll();

    List<UserElement> findAllAndPutInCache();

    List<User> findAllUsersAndPutInCache();

    void delete(String name);

    void deleteAndEvict(String name);

    void findByIdHibernate(Long id);
}