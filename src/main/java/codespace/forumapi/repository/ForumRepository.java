package codespace.forumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;
import codespace.forumapi.model.Forum;

public interface ForumRepository extends JpaRepository<Forum, Integer> {
    
    @Query("SELECT f FROM Forum f")
    List<Forum> getAllForums();
    
    Optional<Forum> getForumById(Integer id);
 
    @Query("UPDATE Forum f SET f.title = :title, f.description = :description WHERE f.id = :id")
    void updateTitle(String title, String description, int id);
    
    @Query("DELETE FROM Forum f WHERE f.id = :id")
    void deleteById(int id);
}
