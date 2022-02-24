package ua.com.hashcode.sancho;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ProcessGo {

    private static List<Contributor> contributors;
    private static List<Project> projects;

    public static void run() {
        Path path = Paths.get("a_an_example.in.txt");
        Path pathOut = Paths.get("a_output.txt");
        InputToAss.trim(path);
        contributors = InputToAss.getContributors();
        System.out.println("Contributors: ");
        contributors.stream().forEach(System.out::println);
        projects = InputToAss.getProjects();
        System.out.println("Projects: ");
        projects.stream().forEach(System.out::println);

    }
}
