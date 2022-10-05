import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;

public class StudentsGradeReport{
    public static void main(String args[]) throws Exception {
        String filename = "StudentReport.txt";
        ArrayList<Student> student = new ArrayList<Student>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ip=0;
        while(true){
            try{
                System.out.print("Enter the number of students: ");
                ip =Integer.parseInt(br.readLine());
                if(ip<=0)throw new Exception();
                break;
            }
            catch(Exception e){
                System.out.print("Wrong input!\n");
            }

        }
        String name = "default";
        double score = 0;
        double total = 0;
        double max = 0;
        for (int i = 0; i < ip; i++) {
            while (true) {
                try{
                    System.out.print("Enter name and score of student " + (i + 1) + ": ");
                    String[] input = br.readLine().split(" ");
                    name = input[0];
                    score = Double.parseDouble(input[1]);
                    if(score<0 || score>100){throw new Exception();}
                    break;
                }
                catch(Exception e){
                    System.out.println("Wrong Input");
                }
            }
            total += score;
            max = Math.max(max, score);
            student.add(new Student(name, score));
        }
        System.out.print("Report saved in StudentReport.txt file");


        BufferedWriter fw = new BufferedWriter(new FileWriter(filename, true));
        fw.write("\nThe average score = ");
        double avg = total/ip;
        String average = String.valueOf(avg);
        fw.write(average+"\n");
        fw.write("\nThe Maximum score = ");
        String Maximum = String.valueOf(max);
        fw.write(Maximum+"\n");
        fw.write("\nThe student(s) with the maximum score: \n");
        for(int j=0; j<ip; j++){
            if(student.get(j).getScore()==max){fw.write(student.get(j).getName()+"\n");}
        }
        fw.write("\nGRADE REPORT\n");
        for(int k=0; k<ip; k++){
            fw.write(student.get(k).getName()+" - "+student.get(k).getGrade()+"\n");
        }
        fw.flush();
        fw.close();

    }
}
class Student{
    private char Grade;
     private String Name;
     private double Score;

     public Student(String Name, double Score){
        this.Name = Name;
         this.Score = Score;
         if(Score >= 90){this.Grade = 'A';}
         else if (Score>=80&&Score<90){this.Grade = 'B';}
         else if (Score>=70&&Score<80){this.Grade = 'C';}
         else{this.Grade = 'F';}
     }

     public String getName() {return Name;}
     public char getGrade() {return Grade;}
     public double getScore() {return Score;}

 }
