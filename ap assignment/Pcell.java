import java.util.ArrayList;

public class Pcell {
    private String name;

    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Company> companyList = new ArrayList<>();
    private String companyRegistrationOpenAt;
    private String companyRegistrationCloseAt;
    private String studentRegistrationOpenAt;
    private String studentRegistrationCloseAt;

    public String getCompanyRegistrationOpenAt() {
        return companyRegistrationOpenAt;
    }

    public void setCompanyRegistrationOpenAt(String companyRegistrationOpenAt) {
        this.companyRegistrationOpenAt = companyRegistrationOpenAt;
    }

    public String getCompanyRegistrationCloseAt() {
        return companyRegistrationCloseAt;
    }

    public void setCompanyRegistrationCloseAt(String companyRegistrationCloseAt) {
        this.companyRegistrationCloseAt = companyRegistrationCloseAt;
    }

    public String getStudentRegistrationOpenAt() {
        return studentRegistrationOpenAt;
    }

    public void setStudentRegistrationOpenAt(String studentRegistrationOpenAt) {
        this.studentRegistrationOpenAt = studentRegistrationOpenAt;
    }

    public String getStudentRegistrationCloseAt() {
        return studentRegistrationCloseAt;
    }

    public void setStudentRegistrationCloseAt(String studentRegistrationCloseAt) {
        this.studentRegistrationCloseAt = studentRegistrationCloseAt;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public ArrayList<Company> getCompanyList() {
        return companyList;
    }

    public Pcell() {
        this.name = "IIITD Placement Cell";
    }

    public int getStudentCount() {
        if (studentList.size() != 0) {
            return studentList.size();
        }
        return 0;
    }

    public int getCompanyCount() {
        if (companyList.size() != 0) {
            return companyList.size();
        }
        return 0;
    }

    public double getAveragePacakge() {
        double sum = 0, count = 0;
        if (companyList.size() != 0) {
            for (Company company : companyList) {
                count++;
                sum += company.getPackageOffering();
            }
        }
        if (count != 0) {
            return sum;
        } else {
            return 0;
        }
    }

    public void displayStudentStat() {
        int offered = 0, unoffered = 0, blocked = 0;
        if (studentList.size() != 0) {
            for (Student student : studentList) {
                if (student.getStatus() == "Offered") {
                    offered++;
                } else if (student.getStatus() == "Blocked") {
                    blocked++;
                } else if (student.getStatus() == "Unoffered") {
                    unoffered++;
                }
            }
        }
        System.out.println("Offered : " + offered);
        System.out.println("Unoffered : " + unoffered);
        System.out.println("Blocked : " + blocked);
        System.out.println();
    }

    public void getResults() {
        if (companyList.size() != 0) {
            for (Company company : companyList) {
                System.out.println("Company : " + company.getName());
                System.out.println("-----------------------------------\n");
                if (company.getStudentsSelected().size() != 0) {
                    for (Student student : company.getStudentsSelected()) {
                        student.display();
                    }
                } else {
                    System.out.println("No Students Selected\n");
                }

            }
        } else {
            System.out.println("No Companies Registered\n");
        }

    }

}