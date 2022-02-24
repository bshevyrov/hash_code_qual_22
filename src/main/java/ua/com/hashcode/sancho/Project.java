package ua.com.hashcode.sancho;

import java.util.Map;

public class Project implements Comparable<Project> {
    private String name;
    private Integer score;
    private Integer duration;
    private Integer bestBefore;
    private Map<String, Integer> roles;
    //ФОРМУЛА score делим на (duration умножить на количество требуемых людей)
    private Double formulaScore;

    public Double getFormulaScore() {
        return formulaScore;
    }

    public void setFormulaScore(Double formulaScore) {
        this.formulaScore = formulaScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Map<String, Integer> getRoles() {
        return roles;
    }

    public void setRoles(Map<String, Integer> roles) {
        this.roles = roles;
    }

    public Integer getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(Integer bestBefore) {
        this.bestBefore = bestBefore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name  +
                ", score=" + score +
                ", duration=" + duration +
                ", bestBefore=" + bestBefore +
                ", roles=" + roles +
                ", formulaScore=" + formulaScore +
                '}';
    }

    @Override
    public int compareTo(Project o) {
        return 0;
    }
}
