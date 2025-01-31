package codespace.forumapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import codespace.forumapi.model.FThread;

public interface FThreadRepository extends JpaRepository<FThread, Integer> {

    @Query("SELECT f FROM FThread f WHERE f.Id = :id")
    List<FThread> getForumById(int id);
    
    @Query("SELECT f FROM FThread f WHERE f.ForumID = :forumId")
    List<FThread> findAllByForumId(int forumId);
    
    @Modifying
    @Transactional
    @Query("SELECT f FROM FThread f WHERE f.UserId = :userId")
    List<FThread> findAllByUserId(String userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM FThread f WHERE f.Id = :id")
    void deleteById(int id);
}
