package com.food.repository;

import com.food.dto.RoleDto;
import com.food.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    Iterable<User> findAllByRole(RoleDto roleDto);
    User findByUsername(String username);
    Page<User> findAllByFullNameContaining(String fullName, Pageable pageable);

    @Query(nativeQuery = true,
            value = "SELECT r.name_role FROM roles r " +
                    "INNER JOIN users u ON r.id = u.role_id " +
                    "WHERE u.username = :username")
    List<String> findRolesByUsername(@Param("username") String username);
}
