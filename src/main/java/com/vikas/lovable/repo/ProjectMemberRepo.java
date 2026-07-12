package com.vikas.lovable.repo;

import com.vikas.lovable.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMemberRepo extends JpaRepository<ProjectMember,Long> {

}
