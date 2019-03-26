package com.recyclebookstore.demo.repository;

import com.recyclebookstore.demo.entity.CommentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CommentRepository extends JpaRepository<CommentInfo, Long> {

    @Query(value = "select count(*) from comment_info where talk_id = ?1 and parent_comment_id = ?2",nativeQuery = true)
    Long CountCommentByTalkIdAndParentCommentId(Long talk_id, Long parent_comment_id);

    @Query(value = "select * from comment_info where talk_id = ?1 and parent_comment_id = ?2",nativeQuery = true)
    List<CommentInfo> findCommentInfoByTalkIdAndParentCommentId(Long talk_id,Long parent_comment_id);

    @Modifying
    @Query(value = "delete from comment_info where comment_id = ?1",nativeQuery = true)
    int deleteCommentInfoById(Long comment_id);
}
