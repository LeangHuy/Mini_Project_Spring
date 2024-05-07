package org.example.btb_group_01_spring_mini_project.repository;

import org.apache.ibatis.annotations.*;
import org.example.btb_group_01_spring_mini_project.model.dto.request.AppUserRequest;
import org.example.btb_group_01_spring_mini_project.model.entity.AppUser;

@Mapper
public interface AppUserRepository {

    @Results(id = "appUserMapper", value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "profileImage", column = "profile_image")
    })
    @Select("SELECT * FROM users WHERE email = #{email}")
    AppUser findByEmail(String email);


    @ResultMap("appUserMapper")
    @Select("INSERT INTO users (email, password, profile_image) VALUES (#{appUser.email}, #{appUser.password}, #{appUser.profileImage}) RETURNING *")
    AppUser register(@Param("appUser") AppUserRequest appUserRequest);
}
