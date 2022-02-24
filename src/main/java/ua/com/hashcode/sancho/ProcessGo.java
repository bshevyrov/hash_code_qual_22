package ua.com.hashcode.sancho;

import ua.com.hashcode.bohdan.Bohdan;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


        //
projects.sort(Comparators.FORMULA_SCORE);
contributors.sort(Comparators.FROM_MIN_TO_MAX_SKILLS);

        System.out.println(contributors.toString());

List<String> rsl = new ArrayList<>();
List<Contributor>  contributorsRsl = new ArrayList<>();
        for (Project project : projects) {
            List<Contributor> rslContr = new ArrayList<>();
            for (int i = 0; i <project.getRoles().size() ; i++) {
                for (Contributor contributor : contributors) {
                        if(contributorsRsl.contains(contributor)){
                            continue;
                        }
                    List<String> projectSkill = new ArrayList<String>(project.getRoles().keySet());
                    List<Integer> projectLevel = new ArrayList<Integer>(project.getRoles().values());
                    List<String> currentContributorSkill = new ArrayList<String>(contributor.getSkills().keySet());
                    List<Integer> currentContributorLevel = new ArrayList<Integer>(contributor.getSkills().values());


                    if(currentContributorSkill.contains((projectSkill.get(i)))
                            &&contributor.getSkills().get(projectSkill.get(i)) >= projectLevel.get(i)) {
                        //increase skill if not max, not 6
                        if(contributor.getSkills().get(projectSkill.get(i))<6){
                            Map<String, Integer> skills = contributor.getSkills();
                            int skillLevel=  contributor.getSkills().get(projectSkill.get(i))+1;

                            skills.put((projectSkill.get(i)),skillLevel);
                            contributor.setSkills(skills);
                        }

                        contributorsRsl.add(contributor);
                        rslContr.add(contributor);
                    }
                }
            }
            rsl.add(project.getName());
            String rslTmp="";
            for (Contributor contributor : rslContr) {
                rslTmp+= contributor.getName() + " ";
            }

            rsl.add(rslTmp);
        }
        System.out.println(contributorsRsl.toString());
        System.out.println(rsl.toString());
    }
}
