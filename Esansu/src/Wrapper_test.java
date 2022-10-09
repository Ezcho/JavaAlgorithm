import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Wrapper_test {
    public static void main(String args[]){


        Integer num2 = new Integer(332); // 박싱
        Integer num1 = 332;         //오토박싱
        int a1 = num2.intValue();   //언박싱
        int a2 = num2;              //오토언박싱

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(num1);
        System.out.println(num2);

        String str1 = "10";
        String str2 = "2";
        String str3 = "true";
        String str4 = "3.2";

        int strint = Integer.parseInt(str1);
        short strshort = Short.parseShort(str2);
        boolean strbool = Boolean.parseBoolean(str3);
        double strdouble = Double.parseDouble(str4);

        System.out.println(strint);
        System.out.println(strshort);
        System.out.println(strbool);
        System.out.println(strdouble);

        Integer i3 = a2;

        String a = new String("abc");

        String s1 = "abc";
        String s2 = "abc";

        String s3 = new String("abc");
        String s4 = new String("abc");

        if(s1==s2)System.out.println("s1==s2");
        else System.out.println("s1!=s2");
        if(s3==s4)System.out.println("s3==s4");
        else System.out.println("s3!=s4");


        ArrayList<Integer> arl = new ArrayList<>();
        arl.add(30);                        //오토박싱
        arl.add(Integer.valueOf(30));     //박싱
        int arr0 = arl.get(0);              //오토언박싱
        int arr1 = arl.get(0).intValue();   //언박싱

        Vector<Integer> v1 = new Vector<>();
        Queue<Integer> queue = new LinkedList<>();



    }
}
