package com.company.repo;

import com.company.entity.Role;
import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
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

    /*@Query(value= "insert i",nativeQuery = true)
    boolean addRoleToUser(Long roleId,Long userId);*/
}
