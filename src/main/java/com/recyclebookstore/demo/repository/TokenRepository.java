package com.recyclebookstore.demo.repository;

import com.recyclebookstore.demo.entity.TokenInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface TokenRepository extends JpaRepository<TokenInfo, Long> {
    @Query(value="select * from token_info  where token_str = ?1 and user_id = ?2",nativeQuery = true)
    List<TokenInfo> findByTokenStrAndUserId (String token,Long user_id);

    @Modifying
    @Query(value="delete  from token_info  where user_id = ?1",nativeQuery = true)
    int deleteByUserId (Long user_id);

    @Query(value="select *  from token_info  where user_id = ?1",nativeQuery = true)
    List<TokenInfo> findByUserId (Long user_id);
}
