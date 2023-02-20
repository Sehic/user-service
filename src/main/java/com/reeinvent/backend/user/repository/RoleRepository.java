package com.reeinvent.backend.user.repository;

import com.reeinvent.backend.user.entities.RoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

    @Query(value = "SELECT * FROM Roles where name IN (:roles)", nativeQuery = true)
    Set<RoleEntity> findByNameIn(@Param("roles") List<String> roles);
}
