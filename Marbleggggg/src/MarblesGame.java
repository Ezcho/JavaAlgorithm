import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MarblesGame {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Student s1 = new Student("Diana", 1000);
        Student s2 = new Student("Magyeongmi", 1122);
        GradStudent gs1 = new GradStudent ("Yasmin", 1992, "Steve Jobs", "Biotechnology");
        UndergradStudent ugs1 = new UndergradStudent("Kestrel", 1998, "Leopold");

        System.out.print(gs1.getID());
    }
}

class Student{
    public Student(String name, int id){}
    public int CURRENT_YEAR = 2022;
    private String name;
    private int id;
    private int yearOfBirth;
    private static int numStudents;
    public Student(){}
    public String getName(){return name;}
    public int getID(){return id;}
    public int getAge(){return (CURRENT_YEAR-yearOfBirth);}
    public String toString(){return "Student[name ="+getName()+", id = "+getID()+", age = "+getAge()+"]";}
    public static int getNumStudents(){return numStudents;}
    public static int getStudentType(Student student){return 0;}
}

class UndergradStudent extends Student{
    private String residenceHall;
    private static int numStudents;
    public UndergradStudent(String name, int yearOfBirth, String residenceHall){}
    public String getResidenceHall() {return residenceHall;}
    public void setResidenceHall(String residenceHall){}
    public String toString(){return "UndergradStudent[name = "+getName()+", id = "+getID()+", age = "
            +getAge()+ ", residenceHall = "+getResidenceHall()+"]";}
    public static int getNumStudents() { return numStudents;}
}

class GradStudent extends Student{
    private String advisor;
    private String areaOfResearch;
    private static int numStudents;
    public GradStudent(String name, int yearOfBirth, String advisor, String areaOfResearch){}
    public String getAdvisor(){return advisor;}
    public void setAdvisor(String advisor){}
    public String getAreaOfResearch(){return areaOfResearch;}
    public void setAreaOfResearch(String areaOfResearch){}
    public String toString(){return "GradStudent[name ="+getName()+" , id = "+getID()+", age = "+getAge()+
            ", advisor = "+getAdvisor()+", areaOfResearch = "+getAreaOfResearch()+"]";}
    public static int getNumStudents(){return numStudents;}
}

