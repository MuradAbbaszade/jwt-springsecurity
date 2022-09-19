package com.company.repo;

import com.company.entity.Role;
import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "select * from public.user where email = :email", nativeQuery = true)
    User getUserByEmail(@Param("email") String email);

    @Query(value= "select role_id from public.user_role where user_id=:user_id",nativeQuery = true)
    List<Long> getIdsOfUserRoles(@Param("user_id")Long userId);

    @Modifying
    @Query(value= "insert into user_role(user_id,role_id) values(:user_id,:role_id)",nativeQuery = true)
    void addRoleToUser(@Param("role_id")Long roleId,@Param("user_id") Long userId);
}
