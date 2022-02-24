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

    public static void run(Path in,Path out) {

        InputToAss.trim(in);
        contributors = InputToAss.getContributors();
     //   System.out.println("Contributors: ");
        contributors.stream().forEach(System.out::println);
        projects = InputToAss.getProjects();
      //  System.out.println("Projects: ");
        projects.stream().forEach(System.out::println);


        //
projects.sort(Comparators.FORMULA_SCORE);
contributors.sort(Comparators.FROM_MIN_TO_MAX_SKILLS);

    //    System.out.println(contributors.toString());

List<String> rsl = new ArrayList<>();
List<Contributor>  contributorsRsl = new ArrayList<>();
        int totalJobDone=0;


        for (int l = 0; l >-1 ; l++) {


        for (Project project : projects) {
            if (rsl.contains(project.getName())){
                continue;
            }
            List<Contributor> rslContr = new ArrayList<>();
            for (int i = 0; i <project.getRoles().size() ; i++) {
                for (Contributor contributor : contributors) {
                        if(contributor.getBusyUntilTurnNumber()<l){
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
                        contributor.setBusyUntilTurnNumber(project.getDuration());
                        contributorsRsl.add(contributor);
                        rslContr.add(contributor);
                    }
                }
            }
            rsl.add(project.getName());
            totalJobDone++;
            String rslTmpContrib="";
            for (Contributor contributor : rslContr) {
                rslTmpContrib+= contributor.getName() + " ";
            }

            //TODO fix this
            if (rslTmpContrib.length()==0){
                continue;
            }
            String tmpXZ= rslTmpContrib.substring(0,rslTmpContrib.length()-1);
            rslTmpContrib=tmpXZ;

            rsl.add(rslTmpContrib);
        }
            if (projects.size()== totalJobDone){
                break;
            }
        }
    //    System.out.println(contributorsRsl.toString());
        rsl.add(0, String.valueOf(rsl.size()/2));
        System.out.println(rsl.toString());
        OutputFromAss.out(rsl,out);
    }

}
