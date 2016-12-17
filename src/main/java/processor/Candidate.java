package processor;

public class Candidate {
    private String name;
    private String nickname;
    private String email;
    private String description;
    private String joinedTime;
    private String repoNumber;
    private String starNumber;
    private String followerNumber;
    private String contribution;

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public String getRepoNumber() {
        return repoNumber;
    }

    public void setRepoNumber(String repoNumber) {
        this.repoNumber = repoNumber;
    }

    public String getStarNumber() {
        return starNumber;
    }

    public void setStarNumber(String starNumber) {
        this.starNumber = starNumber;
    }

    public String getFollowerNumber() {
        return followerNumber;
    }

    public void setFollowerNumber(String followerNumber) {
        this.followerNumber = followerNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? "" : email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? "" : description;
    }

    public String getJoinedTime() {
        return joinedTime;
    }

    public void setJoinedTime(String joinedTime) {
        this.joinedTime = joinedTime == null ? "" : joinedTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", joinedTime='" + joinedTime + '\'' +
                ", repoNumber='" + repoNumber + '\'' +
                ", starNumber='" + starNumber + '\'' +
                ", followerNumber='" + followerNumber + '\'' +
                ", contribution='" + contribution + '\'' +
                '}';
    }
}
