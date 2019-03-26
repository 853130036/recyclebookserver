package com.recyclebookstore.demo.repository;


import com.recyclebookstore.demo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Repository
public interface User_informationRepostitory extends JpaRepository<UserInfo,Long> {
    @Query(value = "select * from user_info where user_id = ?1 ",nativeQuery = true)
    UserInfo getByUser_id(Long user_id);
    //UPDATE Person SET FirstName = 'Fred' WHERE LastName = 'Wilson'

    @Modifying @Transactional
    @Query(value = "update user_info set user_info.phone_num=?1,user_info.user_name=?2,sex=?3,birthday=?4,user_password=?5 where user_id=?6",nativeQuery = true)
   int updateByUser_id(Long phone_num, String username, String sex, String birthday,String password,Long user_id);

}
