package vietnam.com.football_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vietnam.com.football_system.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByUsername(String username);
    boolean existsByUsername (String username);
    boolean existsByEmail(String email);
    List<User> findUserBySkillLevel(String skillLevel);
    List<User> findUserByAgeBetween(int minAge, int maxAge);
    List<User> findUserByRatingGreaterThan(float rating);
}
