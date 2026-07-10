package com.vikas.lovable.repo;

import com.vikas.lovable.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query("Select p from Project p where p.deletedAt is null and p.owner.id = :userId order by p.updatedAt Desc")
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId);
}
