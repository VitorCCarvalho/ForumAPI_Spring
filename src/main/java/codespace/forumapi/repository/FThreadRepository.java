package codespace.forumapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import codespace.forumapi.model.FThread;

public interface FThreadRepository extends JpaRepository<FThread, Integer> {

    @Query("SELECT f FROM FThread f WHERE f.id = :id")
    List<FThread> findById(int id);
    
    @Query("SELECT f FROM FThread f WHERE f.forumid = :forumid")
    List<FThread> findAllByForumId(int forumId);
    
    @Query("SELECT f FROM FThread f WHERE f.userid = :userid")
    List<FThread> findAllByUserId(String userId);

    @Query("UPDATE FThread f SET f.text = :text WHERE f.id = :id")
    void updateText(String text, int id);

    @Query("DELETE FROM FThread f WHERE f.id = :id")
    void deleteById(int id);
}
