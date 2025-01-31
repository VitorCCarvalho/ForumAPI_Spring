package codespace.forumapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import codespace.forumapi.model.PostReaction;

public interface PostReactionRepository extends JpaRepository<PostReaction, Integer> {

    @Query("SELECT p FROM PostReaction p WHERE p.PostId = :postId")
    List<PostReaction> findByPostId(int postId);
    
    @Query("SELECT p FROM PostReaction p WHERE p.UserId = :userId")
    List<PostReaction> findByUserId(String userId);

    @Modifying
    @Transactional
    @Query("UPDATE PostReaction p SET p.Reaction = :reaction WHERE p.PostId = :postId AND p.UserId = :userId")
    void updateReaction(PostReaction reaction, int postId, String userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM PostReaction p WHERE p.PostId = :postId AND p.UserId = :userId")
    void deleteReaction(int postId, String userId);
}
