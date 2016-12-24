package com.hysing.mapper;

import com.hysing.model.Candidate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;


public interface CandidateMapper {

    @Insert(
            "INSERT INTO candidate (id, nickname, name, email, description, joined_time, repo_number, star_number, follower_number, contribution, blog, language) " +
                    "VALUES (#{id}, #{nickname}, #{name}, #{email}, #{description}, #{joinedTime}, #{repoNumber}, #{starNumber}, #{followerNumber}, #{contribution}, #{blog}, #{language})"
    )
    @Options(keyProperty = "id", useGeneratedKeys = true)
    Long insert(Candidate candidate);
}