import java.util.Scanner;

public class June_30 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = n;
        for(int i=0;i<n;i++){
            String str = sc.next();
            boolean tf[] = new boolean[124];
            tf[str.charAt(0)] = true;
            for(int j=1;j<str.length();j++){
                int num = (int)str.charAt(j);
                if(str.charAt(j-1)==str.charAt(j)) {
                    continue;
                }
                else{
                    if(!tf[num]) {
                        tf[num] = true;
                        continue;
                    }
                    else{
                        cnt--;
                        break;
                    }
                }
            }
        }
        System.out.print(cnt);

    }
}
