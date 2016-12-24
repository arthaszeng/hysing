package com.hysing.service;

import com.hysing.exception.CannotCreateAccountException;
import com.hysing.mapper.CandidateMapper;
import com.hysing.mapper.MyBatisUtil;
import com.hysing.model.Candidate;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CandidateService {
    private final CandidateMapper candidateMapper;
    private SqlSession sqlSession;

    public CandidateService() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        sqlSessionFactory.getConfiguration().addMapper(CandidateMapper.class);
        sqlSession = sqlSessionFactory.openSession();
        this.candidateMapper = sqlSession.getMapper(CandidateMapper.class);
    }

    public void create(Candidate candidate) throws CannotCreateAccountException {
        try {
            if (!isExistingUser(candidate)) {
                candidateMapper.insert(candidate);
                sqlSession.commit();
            } else {
                System.out.println(candidate.getNickname() + " is duplicate!");
            }
        } catch (Exception e) {
            sqlSession.rollback();
            throw new CannotCreateAccountException();
        }
    }

    private boolean isExistingUser(Candidate candidate) {
        List<Candidate> candidates = candidateMapper.findByNickname(candidate.getNickname());
        return candidates != null;
    }

}
