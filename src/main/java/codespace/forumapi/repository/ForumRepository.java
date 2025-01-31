package codespace.forumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import codespace.forumapi.model.Forum;

public interface ForumRepository extends JpaRepository<Forum, Integer> {
    
    @Query("SELECT f FROM Forum f")
    List<Forum> getAllForums();
    
    @Query("SELECT f FROM Forum f WHERE f.id = :id")
    Optional<Forum> getForumById(Integer id);
 
    @Modifying
    @Transactional
    @Query("UPDATE Forum f SET f.name = :name, f.description = :description WHERE f.id = :id")
    void updateForum(String name, String description, int id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Forum f WHERE f.id = :id")
    void deleteById(int id);
}
