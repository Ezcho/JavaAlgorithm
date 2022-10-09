import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Oct_2{
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

        boolean res = false;
        boolean equal = false;
        if(a1 * a2 == 0 && b1 * b2 == 0) {
            equal = true;
            if (check_x(x1,x2,x3,x4) && check_y(y1,y2,y3,y4)) {
                res = true;
            }
        }
        if((a1 * a2 <=0)&&(b1 * b2 <=0)){
            if(!equal){
                res = true;
            }
        }


        if(res)
            System.out.println("1");
        else
            System.out.println("0");

    }

    public static int ccw(long x1,long x2,long x3,long y1,long y2,long y3){
        long a = x1 * y2 + x2 * y3 + x3 * y1;
        long b = y1 * x2 + y2 * x3 + y3 * x1;
        if (a - b < 0)
            return 1;
        else if(a - b == 0)
            return 0;
        else
            return -1;
    }

    public static boolean check_x(long x1, long x2, long x3 ,long x4 ){
        boolean a = Math.min(x1,x2)<=Math.max(x3,x4);
        boolean b = Math.min(x3,x4)<=Math.max(x1,x2);
        return(a&&b);

    }
    public static boolean check_y(long y1, long y2,long y3 ,long y4 ){
        boolean a = Math.min(y1,y2)<= Math.max(y3,y4);
        boolean b = Math.min(y3,y4)<= Math.max(y1,y2);
        return(a&&b);

    }
}
