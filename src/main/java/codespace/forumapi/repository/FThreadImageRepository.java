package codespace.forumapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import codespace.forumapi.model.FThreadImage;

public interface FThreadImageRepository extends JpaRepository<FThreadImage, Integer> {

    @Query("SELECT f FROM FThreadImage f WHERE f.fthreadid = :fthreadid")
    List<FThreadImage> getFThreadImagesByFThreadId(@Param("fthreadid") int fthreadid);

    @Query("SELECT f FROM FThreadImage f WHERE f.imgid = :imgid")
    List<FThreadImage> getFThreadImagesByImgId(@Param("imgid") String imgid);
    
}
