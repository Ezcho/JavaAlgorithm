import java.util.Objects;

public class Student {
    String name;
    String number;
    int birthYear;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, birthYear);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return birthYear == student.birthYear && Objects.equals(name, student.name) && Objects.equals(number, student.number);
    }



    public static void main(String args[]){
        Student s1 = new Student();
        Student s2 = new Student();

        s1.name = "홍길동";
        s1.number = "1234";
        s1.birthYear = 1995;

        s2.name = "홍길동";
        s2.number = "1234";
        s2.birthYear = 1995;

        if(s1.equals(s2))
            System.out.println("They equals");
        else
            System.out.println("not equlas");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());


        String a = "acb";
        String b = "bac";

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

    }

}
