package com.recyclebookstore.demo.repository;

import com.recyclebookstore.demo.entity.UserInfo;
import com.recyclebookstore.demo.vo.LoginResponseVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserManageRepository extends JpaRepository<UserInfo, Long> {
    @Query(value="select * from user_info  where user_name = ?1 and user_password = ?2",nativeQuery = true)
    List<UserInfo> login (String userName, String password);


}
