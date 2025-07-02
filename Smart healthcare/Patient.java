public class Patient {
    private String name;
    private int age;
    private String gender;
    private String issue;

    public Patient(String name, int age, String gender, String issue) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.issue = issue;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getIssue() {
        return issue;
    }
}
