import java.util.Scanner;


public class Sep_12 {

    public static void main(String args[]) {
        long[] fibo = new long[70];
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 3; i < 60; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long total = 0;
        while (n > 1) {
            for (int i = 0; i < n+2; i++) {
                if (n == 2) {
                    n--;
                    break;
                }
                if (fibo[i] >= n) {
                    n -= fibo[i - 1];
                    total += (fibo[i - 2]);
                    break;
                }
            }
            if (n == 1) {
                total++;
            }
        }
        System.out.println(total);
    }
}
  /*  public static int Fib(int n){
        if(n==1||n==2){
            return 1;
        }
        if(1>=n){
            return n;
        }
        else{
            return Fib(n-2)+Fib(n-1);
        }
    }
}*/