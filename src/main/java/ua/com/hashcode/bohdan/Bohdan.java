package ua.com.hashcode.bohdan;

import ua.com.hashcode.sancho.Comparators;
import ua.com.hashcode.sancho.Project;

import java.util.List;

public  class Bohdan {
    public static List<Project> sortProjectByFormulascore(List<Project> listProject) {
 //ФОРМУЛА score делим на (duration умножить на количество требуемых людей)
listProject.sort(Comparators.FORMULA_SCORE);
return listProject;
    }


}
