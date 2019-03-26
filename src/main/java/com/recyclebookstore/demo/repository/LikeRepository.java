package com.recyclebookstore.demo.repository;

import com.recyclebookstore.demo.entity.LikeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface LikeRepository extends JpaRepository<LikeInfo, Long> {

    @Query(nativeQuery = true,value = "select count(*) from like_info where talk_id = ?1 and comment_id = ?2")
    Long CountLikeByTalkIdAndCommentId(Long talk_id, Long comment_id);

    //判断是否点赞
    @Query(nativeQuery = true,value = "select count(*) from like_info where user_id = ?1 and talk_id = ?2 and comment_id = ?3")
    int CountLikeByUserIdAndTalkId(Long user_id,Long talk_id,Long comment_id);

    @Modifying
    @Query(nativeQuery = true,value = "delete from like_info where user_id = ?1 and talk_id = ?2 and comment_id = ?3")
    int DeleteLikeByUserIdAndTalkId(Long user_id,Long talk_id,Long comment_id);
}
