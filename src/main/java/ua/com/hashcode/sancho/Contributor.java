package ua.com.hashcode.sancho;

import java.util.Map;

public class Contributor implements Comparable<Contributor>{

    private String name;
    private Map<String, Integer> skills;
    private int skillCount;

    public int getSkillCount() {
        return skillCount;
    }

    public void setSkillCount(int skillCount) {
        this.skillCount = skillCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getSkills() {
        return skills;
    }

    public void setSkills(Map<String, Integer> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Contributor{" +
                "name='" + name + '\'' +
                ", skills=" + skills +
                '}';
    }

    @Override
    public int compareTo(Contributor o) {
        return 0;
    }
}
