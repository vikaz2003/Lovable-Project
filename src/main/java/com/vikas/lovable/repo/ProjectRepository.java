package com.vikas.lovable.repo;

import com.vikas.lovable.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query("""
        Select p from Project p where p.deletedAt is null and exists (
         select 1 from ProjectMember pm where pm.id.userId= :userId
                 and pm.id.projectId=p.id        
        )
        order by p.updatedAt Desc 
        """    )
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId);

    @Query("""
        Select p from Project p where p.deletedAt is null and exists (
         select 1 from ProjectMember pm where pm.id.userId= :userId
                 and pm.id.projectId=p.id        
        ) and p.id = :projectId
        order by p.updatedAt Desc 
        """  )
   Optional<Project> findAccessibleProjectById(@Param("userId") Long userId,@Param("projectId") Long projectId);


}
