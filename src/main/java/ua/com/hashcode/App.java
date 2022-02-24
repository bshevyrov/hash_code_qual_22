package ua.com.hashcode;

import ua.com.hashcode.sancho.ProcessGo;

import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    public static void main(String[] args) {


//        Path path = Paths.get("a_an_example.in.txt");
//        Path pathOut = Paths.get("a_output.txt");
//
//        ProcessGo.run(path,pathOut);
       Path  path = Paths.get("b_better_start_small.in.txt");
       Path  pathOut = Paths.get("b.txt");

        ProcessGo.run(path,pathOut);
         path = Paths.get("c_collaboration.in.txt");
         pathOut = Paths.get("c.txt");

        ProcessGo.run(path,pathOut);
         path = Paths.get("d_dense_schedule.in.txt");
         pathOut = Paths.get("d.txt");

        ProcessGo.run(path,pathOut);
         path = Paths.get("e_exceptional_skills.in.txt");
         pathOut = Paths.get("e.txt");

        ProcessGo.run(path,pathOut);
         path = Paths.get("f_find_great_mentors.in.txt");
         pathOut = Paths.get("f.txt");

        ProcessGo.run(path,pathOut);
    }
}
