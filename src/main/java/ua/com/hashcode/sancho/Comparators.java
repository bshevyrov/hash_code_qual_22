package ua.com.hashcode.sancho;

import java.util.Comparator;

public class Comparators {

    public static final Comparator<Project> FORMULA_SCORE = Comparator.comparingDouble(Project::getFormulaScore);
    public static final Comparator<Contributor> FROM_MIN_TO_MAX_SKILLS = Comparator.comparing(Contributor::getSkillCount);

//    public static final Comparator<Client> MAX_DIS = Comparator.comparingDouble(Client::getDislikesSize).reversed();
//    public static final Comparator<Client> MIN_LIKE = Comparator.comparingDouble(Client::getLikesSize);
//    public static final Comparator<Client> EFFICIENT = Comparator.comparingDouble(Client::getEfficient);
//    public static final Comparator<Client> OP_AND_EFF = (Client o1, Client o2) -> EFFICIENT.thenComparing(OP_SIZE).compare(o1, o2);
//    public static final Comparator<Client> MAX_DIS_MIN_LIKE = (Client o1, Client o2) -> MAX_DIS.thenComparing(MIN_LIKE).compare(o1, o2);
}