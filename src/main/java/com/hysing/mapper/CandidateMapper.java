package com.hysing.mapper;

import com.hysing.model.Candidate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

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
}