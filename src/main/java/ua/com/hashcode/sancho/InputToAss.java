package ua.com.hashcode.sancho;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class InputToAss {
    private static List<Contributor> contributors = new ArrayList<>();
    private static List<Project> projects = new ArrayList<>();

    public static void trim(Path path) {
        List<String> list = Collections.emptyList();
        if (Files.exists(path)) {
            try {
                list = Files.lines(path).toList();
            } catch (IOException e) {
            }
        } else {
            System.out.println("Create and fill file first.");
        }

        int contNumber = Integer.parseInt(list.get(0).split(" ")[0]);
        int projectNumber = Integer.parseInt(list.get(0).split(" ")[1]);
        int n = 1;
        int count = 0;

        for (int i = 1; i < list.size(); i++) {
            if (count == contNumber) break;
            Contributor contributor = new Contributor();
            contributor.setName(list.get(i).split(" ")[0]);
            Map<String, Integer> skills = new HashMap<>();
            int skillsNum = Integer.parseInt(list.get(i).split(" ")[1]);
            for (int j = i + 1; j < skillsNum + i + 1; j++) {
                skills.put(list.get(j).split(" ")[0], Integer.parseInt(list.get(j).split(" ")[1]));
                n++;
            }
            n++;
            i += skillsNum;
            count++;
            contributor.setSkills(skills);
            contributors.add(contributor);
        }
        for (int i = n; i < list.size(); i++) {
            Project project = new Project();
            project.setName(list.get(i).split(" ")[0]);
            project.setDuration(Integer.parseInt(list.get(i).split(" ")[1]));
            project.setScore(Integer.parseInt(list.get(i).split(" ")[2]));
            project.setBestBefore(Integer.parseInt(list.get(i).split(" ")[3]));
            Map<String, Integer> roles = new HashMap<>();
            int projNum = Integer.parseInt(list.get(i).split(" ")[4]);
            for(int j = i + 1; j < i + projNum + 1; j++) {
                roles.put(list.get(j).split(" ")[0], Integer.parseInt(list.get(j).split(" ")[1]));
            }
            i += projNum;
            project.setRoles(roles);
            projects.add(project);
        }
    }

    public static List<Contributor> getContributors() {
        return contributors;
    }

    public static List<Project> getProjects() {
        return projects;
    }
}
