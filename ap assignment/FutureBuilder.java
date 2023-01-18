import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class FutureBuilder {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Student> studentList = new ArrayList<Student>();
    private static ArrayList<Company> companyList = new ArrayList<Company>();
    private static Pcell IIITD = new Pcell();

    public static void main(String[] args) {
        try {
            System.out.println("Welcome to FutureBuilder:\n\n");
            while (true) {
                System.out.println("1) Enter the Application\n2) Exit the Application\n");
                int option = sc.nextInt();
                if (option == 1) {
                    boolean exit;
                    do {
                        exit = true;
                        System.out.println("\nChoose The mode you want to Enter in:-\n");
                        System.out.println(
                                "\n1) Enter as Student Mode\n2) Enter as Company Mode\n3) Enter as Placement Cell Mode\n4) Return To Main Application\n");
                        switch (sc.nextInt()) {
                            case 1:
                                getIntoStudentMode();
                                break;
                            case 2:
                                getIntoCompanyMode();
                                break;
                            case 3:
                                getIntoPlacementMode();
                                break;
                            case 4:
                                exit = false;
                                System.out.println("Returning to Main Menu.. \n");
                                break;
                            default:
                                System.out.println("Invalid Entry try again..\n");
                                break;
                        }
                    } while (exit);

                } else if (option == 2) {
                    System.out.println("\nExiting the application...\n");
                    break;
                } else {
                    System.out.println("Invalid entry. Try Again..\n");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("App misbehaved due to some issues terminating .............\n");
        }
    }

    // Student Mode Handler
    private static void getIntoStudentMode() {
        boolean exit;
        do {
            exit = true;
            System.out.println(
                    "Choose the Student Query to perform\n1) Enter as a Student(Give Student Name, and Roll No.)\n2) Add students\n3) Back\n");
            switch (sc.nextInt()) {
                case 1:
                    enterAsAStudent();
                    break;
                case 2:
                    System.out.println("Please add students Name, Roll No, CGPA, Branch(in order):\n");
                    addStudents();
                    for (Student student : studentList) {
                        student.display();
                    }
                    break;
                case 3:
                    exit = false;
                    System.out.println("Exiting to Application Home\n");
                    break;
                default:
                    System.out.println("Invalid Input try again..\n");
                    break;
            }

        } while (exit);
    }

    // Company Mode Handler
    private static void getIntoCompanyMode() {
        boolean exit;
        do {
            exit = true;
            System.out.println(
                    "Choose the Company Query to perform\n1) Add Company and Details\n2) Choose Company\n3) Get Available Companies\n4) Back\n");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Please add company Name, Role, CTC,Minimum CGPA\n");
                    addCompany();
                    for (Company company : companyList) {
                        System.out.println("Name : " + company.getName() + " Role : " + company.getRole());
                    }
                    break;
                case 2:
                    enterAsACompany();
                    break;
                case 3:
                    getAvailableCompanies();
                    break;
                case 4:
                    exit = false;
                    System.out.println("Exiting to Application Home\n");
                    break;
                default:
                    System.out.println("Invalid Input try again..\n");
                    break;
            }
        } while (exit);
    }

    // Placement Cell Handler
    private static void getIntoPlacementMode() {
        boolean exit;
        do {
            exit = true;
            System.out.println(
                    "Welcome " + IIITD.getName()
                            + "\n1) Open Student Registrations\n2) Open Company Registrations\n3) Get Number of Student Registrations\n4) Get Number of Company Registrations\n5) Get Number of Offered/Unoffered/Blocked Students\n6) Get Student Details\n7) Get Company Details\n8) Get Average Package\n9) Get Results\n10) Back\n");
            switch (sc.nextInt()) {
                case 1:
                    openStudentRegistration();
                    break;
                case 2:
                    openCompanyRegistration();
                    break;
                case 3:
                    System.out.println("\nNo of Student Registration(s) : " + IIITD.getStudentCount() + "\n");
                    break;
                case 4:
                    System.out.println("\nNo of Company Registration(s) : " + IIITD.getCompanyCount() + "\n");
                    break;
                case 5:
                    IIITD.displayStudentStat();
                    break;
                case 6:
                    if (IIITD.getStudentList().size() != 0) {
                        for (Student student : IIITD.getStudentList()) {
                            student.display();
                        }
                    } else {
                        System.out.println("\nNo students registered.\n");
                    }
                    break;
                case 7:
                    if (IIITD.getCompanyList().size() != 0) {
                        for (Company company : IIITD.getCompanyList()) {
                            company.display();
                        }
                    } else {
                        System.out.println("\nNo companies registered.\n");
                    }
                    break;
                case 8:
                    System.out.println("Average Package : " + IIITD.getAveragePacakge());
                    break;
                case 9:
                    IIITD.getResults();
                    break;
                case 10:
                    exit = false;
                    System.out.println("\nExiting to Application Home\n");
                    break;
                default:
                    System.out.println("\nInvalid Input try again..\n");
                    break;
            }
        } while (exit);

    }

    /*
     * Student Helper Functions Starts Here
     */

    private static void enterAsAStudent() {
        System.out.println("Please Enter Name and Roll No :\n");
        // Search student data present in List
        System.out.println("Name :\n");
        String name = sc.next();
        System.out.println("Roll No :\n");
        String rno = sc.next();
        boolean studentIn = false;
        if (studentList.size() != 0) {
            for (Student student : studentList) {
                if (student.getName().equals(name) && student.getRollNo().equals(rno)) {
                    studentIn = true;
                    doStudentOperations(student);
                    break;
                }
            }
        }
        if (!studentIn) {
            System.out.println("Student details not found in list..\n");
        }
    }

    private static void addStudents() {
        System.out.println("Enter number of students to add : \n");
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Enter the details of student " + i + 1);
            System.out.println("Name :\n");
            String name = sc.next();
            System.out.println("Roll No :\n");
            String rollNo = sc.next();
            System.out.println("CGPA :\n");
            double cgpa = sc.nextDouble();
            System.out.println("Branch :\n");
            String branch = sc.next();
            Date registeredAt = new Date(System.currentTimeMillis());
            studentList.add(new Student(name, rollNo, cgpa, branch, registeredAt));
        }
    }

    private static void doStudentOperations(Student student) {
        System.out.println("Welcome " + student.getName());
        boolean exit;
        do {
            exit = true;
            System.out.println(
                    "1) Register For Placement Drive\n2) Register For Company\n3) Get All available companies\n4) Get Current Status\n5) Update CGPA\n6) Accept offer\n7) Reject offer\n8) Back\n");
            switch (sc.nextInt()) {
                case 1:
                    studentRegisterForDrive(student);
                    break;
                case 2:
                    studentRegisterForCompany(student);
                    break;
                case 3:
                    getAllCompanies();
                    break;
                case 4:
                    getCurrentStatus(student);
                    break;
                case 5:
                    updateGPA(student);
                    break;
                case 6:
                    acceptOffer(student);
                    break;
                case 7:
                    rejectOffer(student);
                    break;
                case 8:
                    exit = false;
                    System.out.println("Returning to previous menu\n");
                    break;
                default:
                    System.out.println("Invalid Input try again..\n");
                    break;
            }

        } while (exit);
    }

    private static void studentRegisterForDrive(Student student) {
        IIITD.getStudentList().add(student);
        System.out.println("Student Registered for Drive Successfully\n");
    }

    private static void rejectOffer(Student student) {
        if (IIITD.getCompanyList().size() != 0) {
            int count = 0;
            HashMap<Integer, Company> companyWithIndex = new HashMap<>();
            for (Company company : IIITD.getCompanyList()) {
                if (company.getStudentsSelected().contains(student)) {
                    count++;
                    companyWithIndex.put(count, company);
                    System.out.println(count + ")" + company.getName());
                }
            }
            if (count != 0) {
                System.out.println("Select company to reject offer");
                int opt = sc.nextInt();
                if (companyWithIndex.containsKey(opt)) {
                    student.getOfferedCompanies().add(companyWithIndex.get(opt));
                    student.setStatus("Unoffered");
                    companyWithIndex.get(opt).getStudentsSelected().remove(student);
                    System.out
                            .println(student.getName() + " rejected offer from " + companyWithIndex.get(opt).getName());
                } else {
                    System.out.println("Invalid Option....\n");
                }
            } else {
                System.out.println("Not selected by any company");
            }
        } else {
            System.out.println("No company available");
        }
    }

    private static void acceptOffer(Student student) {
        if (IIITD.getCompanyList().size() != 0) {
            int count = 0;
            HashMap<Integer, Company> companyWithIndex = new HashMap<>();
            for (Company company : IIITD.getCompanyList()) {
                if (company.getStudentsSelected().contains(student)) {
                    count++;
                    companyWithIndex.put(count, company);
                    System.out.println(count + ")" + company.getName());
                }
            }
            if (count != 0) {
                System.out.println("Select company to accept offer");
                int opt = sc.nextInt();
                if (companyWithIndex.containsKey(opt)) {
                    student.getOfferedCompanies().add(companyWithIndex.get(opt));
                    System.out
                            .println(student.getName() + " accepted offer from " + companyWithIndex.get(opt).getName());
                } else {
                    System.out.println("Invalid Option....\n");
                }
            } else {
                System.out.println("Not selected by any company");
            }
        } else {
            System.out.println("No company available");
        }
    }

    private static void updateGPA(Student student) {
        System.out.println("Enter the CGPA to update\n");
        double newcgpa = sc.nextDouble();
        student.setCgpa(newcgpa);
        System.out.println("Student CGPA updated successfully\n");
    }

    private static void getCurrentStatus(Student student) {
        System.out.println("Current Status of Student is : " + student.getStatus());
        if (student.getOfferedCompanies().size() != 0) {
            System.out.println("Got Offer from :");
            for (Company company : companyList) {
                company.display();
            }
        }
    }

    private static void getAllCompanies() {
        if (IIITD.getCompanyList().size() != 0) {
            for (Company company : IIITD.getCompanyList()) {
                company.display();
            }
        } else {
            System.out.println("No companies registered for drives\n");
        }
    }

    private static void studentRegisterForCompany(Student student) {

        int count = 0;
        HashMap<Integer, Company> companyWithIndex = new HashMap<>();
        if (IIITD.getCompanyList().size() != 0) {
            for (Company company : IIITD.getCompanyList()) {
                count++;
                companyWithIndex.put(count, company);
                System.out.println(count + ")" + company.getName());
            }
            System.out.println("Select company for registration\n");
            int opt = sc.nextInt();
            if (companyWithIndex.containsKey(opt)) {
                validateAndRegister(student, companyWithIndex.get(opt));
            } else {
                System.out.println("Invalid Option....\n");
            }
        } else {
            System.out.println("No companies registered for drives\n");
        }

    }

    private static void validateAndRegister(Student student, Company company) {
        boolean eligible;
        if (student.getCgpa() >= company.getCgpa()) {
            if (student.getStatus() == "Unoffered") {
                eligible = true;
            } else if (student.getStatus() == "Offered") {
                if (company.getPackageOffering() > student.getHighestCTCHold() * 3) {
                    eligible = true;
                } else {
                    eligible = false;
                }
            } else if (student.getStatus() == "Blocked") {
                eligible = false;
            } else {
                eligible = false;

            }

        } else {
            eligible = false;
        }

        if (eligible) {
            company.getStudentsApplied().add(student);
            System.out.println("Registered Successfully\n");
        } else {
            System.out.println("Candidate Not Eligible for Registration..\n");
        }

    }
    /*
     * Student Helper Functions Ends Here
     */

    /*
     * Company Helper Functions Starts Here
     */
    private static void addCompany() {
        System.out.println("Enter number of companies to add : \n");
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Enter the details of company " + i + 1);
            System.out.println("Name :\n");
            String name = sc.next();
            System.out.println("Role :\n");
            String role = sc.next();
            System.out.println("CTC :\n");
            double packageOffering = sc.nextDouble();
            System.out.println("Min CGPA :\n");
            double cgpa = sc.nextDouble();
            Date registeredAt = new Date(System.currentTimeMillis());
            companyList.add(new Company(name, role, packageOffering, cgpa, registeredAt));
        }
    }

    private static void enterAsACompany() {
        if (companyList.size() != 0) {
            System.out.println("Choose To enter into mode of Available Companies:-\n");
            int count = 0;
            HashMap<Integer, Company> companyWithIndex = new HashMap<>();
            for (Company company : companyList) {
                count++;
                companyWithIndex.put(count, company);
                System.out.println(count + ")" + company.getName());
            }
            int opt = sc.nextInt();
            if (companyWithIndex.containsKey(opt)) {
                doCompanyOperations(companyWithIndex.get(opt));
            } else {
                System.out.println("Invalid Option....\n");
            }
        } else {
            System.out.println("No companies registered..");
        }
    }

    private static void getAvailableCompanies() {
        if (companyList.size() != 0) {
            for (Company company : companyList) {
                company.display();
            }
        } else {
            System.out.println("No companies registered..");
        }
    }

    private static void doCompanyOperations(Company company) {
        System.out.println("Welcome " + company.getName());
        boolean exit;
        do {
            exit = true;
            System.out.println(
                    "1) Update Role\n2) Update Package\n3) Update CGPA criteria\n4) Register To Institute Drive\n5)Select Students \n6) Back");
            switch (sc.nextInt()) {
                case 1:
                    updateRoleOfCompany(company);
                    break;
                case 2:
                    updatePackageOfCompany(company);
                    break;
                case 3:
                    updateCGPAOfCompany(company);
                    break;
                case 4:
                    registerToInstituteDrive(company);
                    break;
                case 5:
                    selectFromAppliedStudents(company);
                    break;
                case 6:
                    exit = false;
                    System.out.println("Returning to previous menu\n");
                    break;
                default:
                    System.out.println("Invalid Input try again..\n");
                    break;
            }

        } while (exit);
    }

    private static void selectFromAppliedStudents(Company company) {
        if (company.getStudentsApplied().size() != 0) {
            int count = 0;
            HashMap<Integer, Student> studentWithIndex = new HashMap<>();
            for (Student student : company.getStudentsApplied()) {
                count++;
                studentWithIndex.put(count, student);
                System.out.println(count + ")\n");
                student.display();
            }
            System.out.println("Select  qualified student\n");
            int opt = sc.nextInt();
            if (studentWithIndex.containsKey(opt)) {
                company.getStudentsSelected().add(studentWithIndex.get(opt));
                studentWithIndex.get(opt).setStatus("Offered");
                studentWithIndex.get(opt).getOfferedCompanies().add(company);
            } else {
                System.out.println("Invalid Option....\n");
            }

        } else {
            System.out.println("No astudents applied for the role..\n");
        }
    }

    private static void updateRoleOfCompany(Company company) {
        System.out.println("Enter the role to update\n");
        String newRole = sc.next();
        if (newRole != null) {
            company.setRole(newRole);
            System.out.println("Company role updated successfully\n");
        } else {
            System.out.println("Invalid Role provided...\n");

        }
    }

    private static void updatePackageOfCompany(Company company) {
        System.out.println("Enter the package to update\n");
        double newpackage = sc.nextDouble();
        company.setPackageOffering(newpackage);
        System.out.println("Company package updated successfully\n");
    }

    private static void registerToInstituteDrive(Company company) {
        company.setRegisteredAt(new Date(System.currentTimeMillis()));
        IIITD.getCompanyList().add(company);
        System.out.println("Company Registered for the Drive Successfully\n");
    }

    private static void updateCGPAOfCompany(Company company) {
        System.out.println("Enter the CGPA to update\n");
        double newcgpa = sc.nextDouble();
        company.setCgpa(newcgpa);
        System.out.println("Company CGPA updated successfully\n");
    }

    /*
     * Company Helper Functions Ends Here
     */
    /*
     * Placement Cell Helper Functions Starts Here
     */

    private static void openCompanyRegistration() {
        System.out.println(
                "Fill in the details:-\n\t1) Set the Opening time for company registrations\n\t2) Set the Closing time for company registrations");
        String date1 = sc.next();
        sc.nextLine();
        String date2 = sc.next();
        sc.nextLine();
        IIITD.setCompanyRegistrationOpenAt(date1);
        IIITD.setCompanyRegistrationCloseAt(date2);
        System.out.println("Date added successfully");
    }

    private static void openStudentRegistration() {
        System.out.println(
                "Fill in the details:-\n\t1) Set the Opening time for Student registrations\n\t2) Set the Closing time for Student registrations");
        String date1 = sc.next();
        sc.nextLine();
        String date2 = sc.next();
        sc.nextLine();
        IIITD.setStudentRegistrationOpenAt(date1);
        IIITD.setStudentRegistrationCloseAt(date2);
        System.out.println("\nDate added successfully\n");
    }

    /*
     * Placement Cell Helper Functions Ends Here
     */

}