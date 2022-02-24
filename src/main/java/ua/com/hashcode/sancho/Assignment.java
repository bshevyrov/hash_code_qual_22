package ua.com.hashcode.sancho;

public class Assignment {

    private Project project;
    private Contributor contributor;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Contributor getContributor() {
        return contributor;
    }

    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "project=" + project +
                ", contributor=" + contributor +
                '}';
    }
}
