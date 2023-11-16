package com.novProject.domain.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupsRepository extends JpaRepository<Groups, Long> {
    @Query("SELECT p FROM Groups p ORDER BY p.id DESC")
    List<Groups> findAllDesc();
}
