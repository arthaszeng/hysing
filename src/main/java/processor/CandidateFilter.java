package processor;


public class CandidateFilter {
    private static final int EXPECTED_REPO_NUM = -1;
    public static final int EXPECTED_STAR_NUM = -1;
    private static final int EXPECTED_FOLLOWER_NUM = -1;
    private static final int EXPECTED_CONTRIBUTION_IN_LAST_YEAR = -1;


    public boolean isMrRight(Candidate candidate) {
        return hasEnoughRepo(candidate)
                && hasEnoughStar(candidate)
                && hasEnoughFollower(candidate)
                && hasEnoughContribution(candidate)
                && hasEmailAddress(candidate);
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
        return true;
    }

    private boolean hasEnoughRepo(Candidate candidate) {
        return candidate.getFollowerNumber().contains("k") || Integer.valueOf(candidate.getRepoNumber()) > EXPECTED_REPO_NUM;
    }

}