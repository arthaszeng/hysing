package com.hysing.mapper;

import com.hysing.entity.Candidate;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface CandidateMapper {

    @Insert(
            "INSERT INTO candidate (id, nickname, name, email, description, joined_time, repo_number, star_number, follower_number, contribution, blog, language) " +
                    "VALUES (#{id}, #{nickname}, #{name}, #{email}, #{description}, #{joinedTime}, #{repoNumber}, #{starNumber}, #{followerNumber}, #{contribution}, #{blog}, #{language})"
    )
    @Options(keyProperty = "id", useGeneratedKeys = true)
    Long insert(Candidate candidate);


    @Select("SELECT id, nickname, name, email, description, joined_time, repo_number, star_number, follower_number, contribution, blog, language " +
            "FROM candidate " +
            "WHERE nickname=#{nickname}")
    List<Candidate> findByNickname(String nickname);

    @Select("SELECT id, nickname, name, email, description, joined_time, repo_number, star_number, follower_number, contribution, blog, language " +
            "FROM candidate")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property="nickname", column = "nickname"),
            @Result(property="name", column = "name"),
            @Result(property="email", column = "email"),
            @Result(property="description", column = "description"),
            @Result(property="joinedTime", column = "joined_time"),
            @Result(property="repoNumber", column = "repo_number"),
            @Result(property ="starNumber", column = "star_number"),
            @Result(property ="followerNumber", column = "follower_number"),
            @Result(property ="contribution", column = "contribution"),
            @Result(property ="blog", column = "blog"),
            @Result(property ="language", column = "language")
    })
    List<Candidate> findAll();
}