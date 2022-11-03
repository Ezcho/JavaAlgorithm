import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DPCoinChange {
    public static void main(String args[]) throws IOException {

        int MAX = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []input = br.readLine().split(", ");  //코인 입력
        int Ec = Integer.parseInt(br.readLine());         //줘야할 거스름돈 입력

        int n = input.length;       //n은 코인의 개수를 변수로 지정
        int []ip = new int[n];      //ip는 각각의 코인을 문자열 -> 정수열 로 저장할 배열
        int []min = new int[Ec+1];  //min은 각각의 금액에 필요한 최소 동전개수 저장하는 배열

        for(int i=0;i<n;i++) {
            ip[i] = Integer.parseInt(input[i]);
        }                           //for문을 통해 문자열 -> 정수 형변환

        for(int j = 1; j<= Ec; j++){    //min[1]부터 접근시작 -> 필요한 코인의 개수 계산
            min[j] = MAX; //min배열을 초기화 시킴,
            for(int k = 0; k< n; k++){
                if(ip[k]<=j){      //코인 계산을 위해서 증가하는 값(j) 보다 작거나 같은 동전이 존재해야함
                    if(min[j-ip[k]]==MAX){continue;}  //그리고 그 동전은 j에서 뺏을 때 존재하거나 조합이 가능한 동전이어야 함
                    if (min[j] == MAX) {              //이떄의 동전값이 이전에 탐색해서 조합되지 않았다면
                        min[j] = min[j - ip[k]] + 1;  //j를 주기위한 동전은 min[j-ip[k]](이미존재함) 의 동전갯수에 하나를 추가!
                    }
                    else if (min[j - ip[k]] + 1 < min[j]) { //하나를 추가했는데도 min[j] 보다 작은경우
                        min[j] = min[j - ip[k]] + 1;        //min[j]의 개수를 하나 증가시켜준다.
                    }
                }
            }
        }
        System.out.println(min[Ec]);        //Ec위치의 동전 개수 출력
    }
}
