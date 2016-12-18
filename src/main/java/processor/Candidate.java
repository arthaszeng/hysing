package processor;

class Candidate {
    private String nickname;
    private String name;
    private String email;
    private String description;
    private String joinedTime;
    private String repoNumber;
    private String starNumber;
    private String followerNumber;
    private String contribution;
    private String blog;
    private String language;

    public Candidate() {
        this.language = GithubSpider.LANGUAGE;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    String getContribution() {
        return contribution;
    }

    void setContribution(String contribution) {
        this.contribution = contribution;
    }

    String getRepoNumber() {
        return repoNumber;
    }

    void setRepoNumber(String repoNumber) {
        this.repoNumber = repoNumber;
    }

    public String getStarNumber() {
        return starNumber;
    }

    void setStarNumber(String starNumber) {
        this.starNumber = starNumber;
    }

    String getFollowerNumber() {
        return followerNumber;
    }

    void setFollowerNumber(String followerNumber) {
        this.followerNumber = followerNumber;
    }

    String getNickname() {
        return nickname;
    }

    void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email == null ? "" : email;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description == null ? "" : description;
    }

    public String getJoinedTime() {
        return joinedTime;
    }

    void setJoinedTime(String joinedTime) {
        this.joinedTime = joinedTime == null ? "" : joinedTime;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                ", language='" + language + '\'' +
                "nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", blog='" + blog + '\'' +
                ", description='" + description + '\'' +
                ", repoNumber='" + repoNumber + '\'' +
                ", starNumber='" + starNumber + '\'' +
                ", followerNumber='" + followerNumber + '\'' +
                ", contribution='" + contribution + '\'' +
                ", joinedTime='" + joinedTime + '\'' +
                '}';
    }
}
