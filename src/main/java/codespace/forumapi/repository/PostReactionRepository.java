package codespace.forumapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import codespace.forumapi.model.PostReaction;

public interface PostReactionRepository extends JpaRepository<PostReaction, Integer> {

    @Query("SELECT p FROM PostReaction p WHERE p.postid = :postId")
    List<PostReaction> findByPostId(int postId);
    
    @Query("SELECT p FROM PostReaction p WHERE p.userid = :userId")
    List<PostReaction> findByUserId(String userId);

    @Query("UPDATE PostReaction p SET p.reaction = :reaction WHERE p.postid = :postId AND p.userid = :userId")
    void updateReaction(PostReaction reaction, int postId, String userId);

    @Query("DELETE FROM PostReaction p WHERE p.postid = :postId AND p.userid = :userId")
    void deleteReaction(int postId, String userId);
}
