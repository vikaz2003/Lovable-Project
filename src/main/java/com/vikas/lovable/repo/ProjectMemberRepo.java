package com.vikas.lovable.repo;

import com.vikas.lovable.entity.ProjectMember;
import com.vikas.lovable.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepo extends JpaRepository<ProjectMember, ProjectMemberId> {


    List<ProjectMember> findByIdProjectId(Long projectId);
}
