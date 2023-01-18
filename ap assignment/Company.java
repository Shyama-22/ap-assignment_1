import java.util.ArrayList;
import java.util.Date;

public class Company {
    private String name;
    private String role;
    private double packageOffering;
    private double cgpa;
    private Date registeredAt;

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }

    private ArrayList<Student> studentsSelected;
    private ArrayList<Student> studentsApplied;

    public Company(String name, String role, double packageOffering, double cgpa, Date registeredAt) {
        this.name = name;
        this.role = role;
        this.packageOffering = packageOffering;
        this.cgpa = cgpa;
        this.registeredAt = registeredAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getPackageOffering() {
        return packageOffering;
    }

    public void setPackageOffering(double packageOffering) {
        this.packageOffering = packageOffering;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public ArrayList<Student> getStudentsSelected() {
        return studentsSelected;
    }

    public void selectStudent(Student student) {
        studentsSelected.add(student);
    }

    public ArrayList<Student> getStudentsApplied() {
        return studentsApplied;
    }

    public void addStudent(Student student) {
        studentsApplied.add(student);
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public void display() {
        System.out.println("----------------------------------------");
        System.out.println("Name : " + this.name);
        System.out.println("Role : " + this.role);
        System.out.println("Package Offering : " + this.packageOffering);
        System.out.println("Min CGPA required : " + this.cgpa);
        System.out.println("Registered At : " + this.registeredAt);
        System.out.println("----------------------------------------");

    }

}
