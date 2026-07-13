package com.vikas.lovable.mapper;

import com.vikas.lovable.dto.member.MemberResponse;
import com.vikas.lovable.entity.ProjectMember;
import com.vikas.lovable.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target="userId",source="id")
    @Mapping(target="role",constant = "OWNER")
    MemberResponse toProjectMemberResponse(User owner);

    @Mapping(target = "userId",source = "user.id")
    @Mapping(target="username",source = "user.username")
    @Mapping(target="name",source = "user.name")
    MemberResponse toMemberResponse(ProjectMember member);
}
