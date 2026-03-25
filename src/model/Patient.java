package model;

public class Patient {
    private int patientId;
    private String name;
    private int age;
    private String problem;
    private String priorityType;

    public Patient(int patientId, String name, int age, String problem, String priorityType) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.problem = problem;
        this.priorityType = priorityType;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getProblem() {
        return problem;
    }

    public String getPriorityType() {
        return priorityType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public void setPriorityType(String priorityType) {
        this.priorityType = priorityType;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
                ", Name: " + name +
                ", Age: " + age +
                ", Problem: " + problem +
                ", Priority: " + priorityType;
    }
}
