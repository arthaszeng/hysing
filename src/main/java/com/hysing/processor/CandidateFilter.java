package com.hysing.processor;


import com.hysing.entity.Candidate;

import java.util.ArrayList;
import java.util.List;

public class CandidateFilter {
    public static final int EXPECTED_STAR_NUM = 10;
    private static final int EXPECTED_REPO_NUM = 10;
    private static final int EXPECTED_FOLLOWER_NUM = 10;
    private static final int EXPECTED_CONTRIBUTION_IN_LAST_YEAR = 100;
    private static final boolean CANDIDATE_FILTER_FLAG = false;
    static private List<String> blankList = new ArrayList<>();

    public CandidateFilter() {
        blankList.add("AndroidWearDemo");
    }

    static boolean isInBlanklist(String nickname) {
        return blankList.contains(nickname);
    }

    public boolean isMrRight(Candidate candidate) {
        return !CANDIDATE_FILTER_FLAG
                || (hasEnoughRepo(candidate)
                && hasEnoughStar(candidate)
                && hasEnoughFollower(candidate)
                && hasEnoughContribution(candidate)
                && hasEmailAddress(candidate));
    }

    private boolean hasEmailAddress(Candidate candidate) {
        return candidate.getEmail() != null;
    }

    private boolean hasEnoughContribution(Candidate candidate) {
        return Integer.valueOf(candidate.getContribution()) > EXPECTED_CONTRIBUTION_IN_LAST_YEAR;
    }

    private boolean hasEnoughFollower(Candidate candidate) {
        return candidate.getFollowerNumber().contains("k") || Integer.valueOf(candidate.getFollowerNumber()) > EXPECTED_FOLLOWER_NUM;
    }

    private boolean hasEnoughStar(Candidate candidate) {
        return candidate.getStarNumber().contains("k") || Integer.valueOf(candidate.getRepoNumber()) > EXPECTED_STAR_NUM;
    }

    private boolean hasEnoughRepo(Candidate candidate) {
        return candidate.getRepoNumber().contains("k") || Integer.valueOf(candidate.getRepoNumber()) > EXPECTED_REPO_NUM;
    }
}