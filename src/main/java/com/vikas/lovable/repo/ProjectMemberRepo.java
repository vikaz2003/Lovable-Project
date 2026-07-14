package com.vikas.lovable.repo;

import com.vikas.lovable.entity.ProjectMember;
import com.vikas.lovable.entity.ProjectMemberId;
import com.vikas.lovable.enums.ProjectRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectMemberRepo extends JpaRepository<ProjectMember, ProjectMemberId> {


    List<ProjectMember> findByIdProjectId(Long projectId);

    @Query("Select pm.role from ProjectMember pm where pm.id.projectId= :projectId and pm.id.userId= :userId")
    Optional<ProjectRole> findRoleByProjectIdAndUserId(@Param("projectId") Long projectId,@Param("userId") Long userId);
}
