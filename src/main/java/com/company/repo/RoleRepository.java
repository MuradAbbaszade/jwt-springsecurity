package com.company.repo;

import com.company.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query(value = "select * from role where role.name = :name", nativeQuery = true)
    Role getRoleByName(@Param("name") String name);
}
