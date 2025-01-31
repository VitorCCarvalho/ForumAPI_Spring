package codespace.forumapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import codespace.forumapi.model.FThreadImage;

public interface FThreadImageRepository extends JpaRepository<FThreadImage, Integer> {

    @Query("SELECT f FROM FThreadImage f WHERE f.FThreadId = :fthreadid")
    List<FThreadImage> getFThreadImagesByFThreadId(@Param("fthreadid") int fthreadid);

    @Query("SELECT f FROM FThreadImage f WHERE f.ImgId = :imgid")
    List<FThreadImage> getFThreadImagesByImgId(@Param("imgid") String imgid);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM FThreadImage f WHERE f.FThreadId = :fthreadid")
    void deleteFThreadImagesByFThreadId(@Param("fthreadid") int fthreadid);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM FThreadImage f WHERE f.ImgId = :imgid")
    void deleteFThreadImagesByImgId(@Param("imgid") String imgid);
}
