package study.dliga.cache.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import study.dliga.cache.model.UserElement;
import study.dliga.cache.service.UserCacheService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cache/users")
public class UserController {

    public UserController(@Qualifier("springCache") UserCacheService userCacheService) {
        this.userCacheService = userCacheService;
    }

    private final UserCacheService userCacheService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody UserElement userElement) {
        userCacheService.save(userElement);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAll(@RequestBody List<UserElement> userElements) {
        userCacheService.saveAllAndPutInCache(userElements);
    }

    @GetMapping("/{name}")
    public UserElement find(@PathVariable String name) {
        return userCacheService.findByName(name);
    }

    @GetMapping
    public List<UserElement> findAllAndCache() {
        return userCacheService.findAllAndPutInCache();
    }

    @GetMapping("/no")
    public List<UserElement> findAll() {
        return userCacheService.findAll();
    }

    @DeleteMapping("/{name}")
    public void delete(@PathVariable String name){
        userCacheService.delete(name);
    }
    @DeleteMapping("/evict/{name}")
    public void deleteAndEvict(@PathVariable String name){
        userCacheService.deleteAndEvict(name);
    }
}