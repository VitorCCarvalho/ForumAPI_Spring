package codespace.forumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import codespace.forumapi.model.Post;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    

    @Query("SELECT p FROM Post p WHERE p.id = :id")
    Optional<Post> findById(int id);  
    
    @Query("SELECT p FROM Post p WHERE p.threadId = :threadId")
    Optional<List<Post>> findByThreadId(int threadId);
    
    @Query("SELECT p FROM Post p WHERE p.userId = :userId")
    Optional<List<Post>> findAllByUserId(String userId);

    @Modifying
    @Transactional
    @Query("UPDATE Post p SET p.text = :text WHERE p.id = :id")
    void updateText(String text, int id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Post p WHERE p.id = :id")
    void deleteById(int id);
}
