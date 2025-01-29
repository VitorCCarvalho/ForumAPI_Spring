package codespace.forumapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import codespace.forumapi.model.FThreadReaction;

public interface FThreadReactionRepository extends JpaRepository<FThreadReaction, Integer> {
    
    @Query("SELECT fr FROM FThreadReaction fr WHERE fr.threadid = :threadId")
    List<FThreadReaction> findAllByThreadId(int threadId);

    @Query("SELECT fr FROM FThreadReaction fr WHERE fr.userid = :userId")
    List<FThreadReaction> findAllByUserId(String userId);
}
