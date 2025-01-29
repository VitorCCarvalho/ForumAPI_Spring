package codespace.forumapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import codespace.forumapi.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    
    Optional<User> findByUsername(String username);

    Optional<User> findById(int id);

    Optional<User> findByEmail(String email);
}
