package com.vikas.lovable.mapper;


import com.vikas.lovable.dto.auth.SignupRequest;
import com.vikas.lovable.dto.auth.UserProfileResponse;
import com.vikas.lovable.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {


    User toEntity(SignupRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);
}
