package com.recyclebookstore.demo.repository;

import com.recyclebookstore.demo.entity.TalkInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository

public interface TalksRepository extends JpaRepository<TalkInfo, Long>
{

    @Query(value = "select * from talk_info order by talk_datetime desc limit 0,10",nativeQuery = true)
    List<TalkInfo> GetNewTalks();

    @Query(value = "select * from talk_info where talk_id > ?1 order by talk_datetime desc limit 0,10",nativeQuery = true)
    List<TalkInfo> GetMoreTalks(Long last_talk_id);
}
