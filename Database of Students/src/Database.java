import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    public static void main(String[] args) {
        ArrayList<Data> dat = new ArrayList<Data>();
        try{
            File file = new File("input.txt");
            if(!file.exists())
                throw new Exception();
            else{
                BufferedReader br_file = new BufferedReader(new FileReader(file));
                String Line = null;
                while((Line = br_file.readLine())!=null){
                    String[] input = Line.split(",");
                    for(int i=3;i<input.length;i++) {
                        input[2] += "," + input[i];
                    }
                    dat.add(new Data(input[0],Integer.parseInt(input[1])));

                }
            }
        } catch (FileNotFoundException e) {
            System.out.print("File not exist");
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Scanner sc = new Scanner(System.in);
        Print_msg msg = new Print_msg();
        System.out.print(msg.toString());
        int Option_val = sc.nextInt();
        switch(Option_val){
            case 1:
                Data.toString();
            case 2:
                System.out.print("Search based on ID(1), name(2), age(3), course(4): ");
                int ip = sc.nextInt();
                switch(ip){
                    case 1:
                        System.out.print("Enter the ID to be searched:");
                    case 2:
                        System.out.print("Enter the name to be searched: ");
                    case 3:
                        System.out.print("Enter the age to be searched: ");
                    case 4:
                        System.out.print("Enter the course to be searched.\n" +
                                "<course dept> <course number> <credits>: ");
                }
            case 3:
                String name;
                int birth;
                int course_num;
                System.out.print("Enter the student's name: ");
                name = sc.nextLine();
                System.out.print("Enter the student's year of birth:");
                birth = sc.nextInt();
                System.out.print("Enter the number of courses: ");
                course_num = sc.nextInt();
                for(int i=0;i<course_num;i++){
                    System.out.print("Enter the details of course"+i+" in the below format.");
                    System.out.print("<Course department> <course number> <credits>: ");
                    String[] str = sc.nextLine().split(" ");
                }
            case 4:
                System.out.print("Enter the ID of the student to be removed: ");
                int i = sc.nextInt();

                System.out.print("Student has been removed from the database.");
            case 5:
            case 6:
            default:

        }
    }
}
class Data {
    private static int id=1;
    private int currentyear = 2022;
    private String name;
    private int age;
    private String course;
    private int[] c_num;
    private String[] c_name;
    private int[] c_credits;
    private String out;
    private int i=0;

    public Data(String name, int birth) {
        this.name = name;
        this.age = currentyear - birth;
        this.id = id++;

        this.out = "Dept: " + c_name[i] + ", Course: " + c_num[i] + ", Credits: " + c_credits[i];
    }
    public void set_course(String c_name, int c_num, int c_credits){
        this.c_name[i] = c_name;
        this.c_num[i] = c_num;
        this.c_credits[i] = c_credits;
        i++;
    }



    public String toString() {
        return("Name: " + name + "\nID: " + id + "\nAge: " + age + "\nCourses:"+"   "+out);
    }

}
class Print_msg{
    public String toString(){
        return ("DATABASE OF STUDENTS!\n"
                +"=====================\n"
                +"Choose from the menu of options:\n"
                +"1. Print the student details.\n"
                +"2. Search for a student.\n"
                +"3. Add a student record.\n"
                +"4. Delete a student record.\n"
                +"5. Update a student record.\n"
                +"6. Exit the database.\n");
    }
}
