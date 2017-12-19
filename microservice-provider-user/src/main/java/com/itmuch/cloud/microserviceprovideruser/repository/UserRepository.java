package com.itmuch.cloud.microserviceprovideruser.repository;

import com.itmuch.cloud.microserviceprovideruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/********************************************************
 *@Desc:
 *@Author: ZRP
 *@Date: 2017/12/18 11:50
 ********************************************************/
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
