package processor;

import java.util.List;

public class CandidateFilter {
    private static final int EXPECTED_REPO_NUM = 10;
    public static final int EXPECTED_STAR_NUM = 10;
    private static final int EXPECTED_FOLLOWER_NUM = 10;


    public boolean isMrRight(Candidate candidate) {
        return hasEnoughRepo(candidate) && hasEnoughStar(candidate) && hasEnoughFollower(candidate);
    }

    private boolean hasEnoughFollower(Candidate candidate) {
        return candidate.getFollowerNumber().contains("k") || Integer.valueOf(candidate.getFollowerNumber()) > EXPECTED_FOLLOWER_NUM;
    }

    private boolean hasEnoughStar(Candidate candidate) {
        return true;
    }

    private boolean hasEnoughRepo(Candidate candidate) {
        return candidate.getFollowerNumber().contains("k") || Integer.valueOf(candidate.getRepoNumber()) > EXPECTED_REPO_NUM;
    }

}