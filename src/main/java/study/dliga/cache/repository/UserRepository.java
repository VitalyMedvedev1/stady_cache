package study.dliga.cache.repository;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import study.dliga.cache.repository.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    Optional<User> findByName(String name);

    void deleteByName(String name);
}
