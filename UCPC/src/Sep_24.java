import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sep_24 {
    public static class Point{
        double x, y;
        Point(double x, double y){ this.x = x; this.y = y;}
    }
    public static double ccw(double x1, double x2, double x3, double y1, double y2, double y3){
        double a = x1 * y2 + x2 * y3 + x3 * y1;
        double b = y1 * x2 + y2 * x3 + y3 * x1;
        return (a-b)/2;
    }

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point[] p = new Point[N];
        double res = 0;
        double x, y;


        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());
            p[i] = new Point(x, y);
        }
        for(int i=1;i<N-1;i++){
            res += ccw(p[0].x,p[i].x, p[i+1].x, p[0].y,p[i].y, p[i+1].y);
        }
        System.out.printf("%.1f", Math.abs(res));
    }
}
