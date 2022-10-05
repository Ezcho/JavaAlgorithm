import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Oct_2 {

    int name;
    int age;
    static String rank = "silver";




    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        long x1 = Integer.parseInt(st1.nextToken());
        long y1 = Integer.parseInt(st1.nextToken());
        long x2 = Integer.parseInt(st1.nextToken());
        long y2 = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        long x3 = Integer.parseInt(st2.nextToken());
        long y3 = Integer.parseInt(st2.nextToken());
        long x4 = Integer.parseInt(st2.nextToken());
        long y4 = Integer.parseInt(st2.nextToken());

        int a1 = ccw(x1,x2,x3,y1,y2,y3);
        int a2 = ccw(x1,x2,x4,y1,y2,y4);
        int b1 = ccw(x3,x4,x1,y3,y4,y1);
        int b2 = ccw(x3,x4,x2,y3,y4,y2);

        boolean case1 = (a1 * a2 < 0)&&(b1 * b2 < 0);
        boolean case2 = (a1 * a2 == 0)&&(b1 * b2 < 0);
        boolean case3 = (a1 * a2 < 0)&&(b1 * b2 == 0);
        boolean case4 = (a1 * a2 ==0)&&(b1 * b2 == 0)
        boolean case6(((x1<=x3)&&(x3<=x2))||((x1<=x4)&&(x4<=x2))||((x2<=x3)&&(x3<=x1))||((x2<=x4)&&(x4<=x1)));
        boolean case5 = (a1 * a2 ==0)&&(b1 * b2 == 0)&&(a1!=a2);

        if(case1||case2||case3||case4||case5)
            System.out.println("1");
        else
            System.out.println("0");


    }
    public static int ccw(long x1, long x2, long x3, long y1, long y2, long y3){
        long a = x1 * y2 + x2 * y3 + x3 * y1;
        long b = y1 * x2 + y2 * x3 + y3 * x1;
        if (a - b < 0)
            return 1;
        else if(a - b == 0)
            return 0;
        else
            return -1;
    }

}
