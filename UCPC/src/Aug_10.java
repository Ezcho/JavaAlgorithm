import java.util.Scanner;

public class Aug_10 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double sqrt = Math.sqrt(N);

        int cnt = 0;

        for(int i=1;i <= sqrt;i++){
            if(N%i==0){
                System.out.println(i+"와"+N/i+"는 "+N+"의 약수입니다.");
                cnt++;
            }
        }

        System.out.println("약수의 개수: "+ cnt);
    }
}

