import java.util.ArrayList;
import java.util.Date;

public class Student {
    private String name;
    private String rollNo;
    private double cgpa;
    private String branch;
    private Date registeredAt;
    private String status;
    private ArrayList<Company> offeredCompanies = new ArrayList<>();

    public ArrayList<Company> getOfferedCompanies() {
        return offeredCompanies;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public Student(String name, String rollNo, double cgpa, String branch, Date registeredAt) {
        this.name = name;
        this.rollNo = rollNo;
        this.cgpa = cgpa;
        this.branch = branch;
        this.registeredAt = registeredAt;
        this.status = "Unoffered";
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBranch() {
        return branch;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void display() {
        System.out.println("----------------------------------------");
        System.out.println("Name : " + this.name);
        System.out.println("Roll No : " + this.rollNo);
        System.out.println("CGPA : " + this.cgpa);
        System.out.println("Branch : " + this.branch);
        System.out.println("Registered At : " + this.registeredAt);
        System.out.println("----------------------------------------");
    }

    public double getHighestCTCHold() {
        if (offeredCompanies.size() != 0) {
            double max = offeredCompanies.get(0).getPackageOffering();
            for (int i = 1; i < offeredCompanies.size(); i++) {
                if (max < offeredCompanies.get(i).getPackageOffering())
                    max = offeredCompanies.get(i).getPackageOffering();
            }
            return max;
        } else {
            return 0;
        }

    }

}