import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Aug_31 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        int n = sc.nextInt();
        int cnt1=0;
        int cnt2=0;
        int cnt3=0;
        int cnt4=0;


        int res = 0;

        for(int i=0;i<6;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            switch(a){
                case(1):cnt1++;
                case(2):cnt2++;
                case(3):cnt3++;
                case(4):cnt4++;
            }

            queue1.add(a);
            queue2.add(b);
        }

        if(cnt1>cnt2){
            if(cnt3>cnt4){
                for(int j=0;j<7;j++){
                    if(queue1.peek()==2||queue1.peek()==4){
                        break;
                    }
                    else {
                        queue1.add(queue1.poll());
                        queue2.add(queue2.poll());
                    }
                }
                while(true){
                    if(queue1.peek()==1||queue1.peek()==3){
                        int a1 = queue2.poll();
                        int b1 = queue2.poll();
                        int a2 = queue2.poll();
                        int b2 = queue2.poll();
                        res = a1*b1+a2*b2+a1*b2;
                        break;
                    }
                    else{
                        queue1.remove();
                        queue2.remove();
                    }
                }
            }
            else{
                for(int j=0;j<7;j++){
                    if(queue1.peek()==2||queue1.peek()==3){
                        break;
                    }
                    else {
                        queue1.add(queue1.poll());
                        queue2.add(queue2.poll());
                    }
                }
                while(true){
                    if(queue1.peek()==1||queue1.peek()==4){
                        int a1 = queue2.poll();
                        int b1 = queue2.poll();
                        int a2 = queue2.poll();
                        int b2 = queue2.poll();
                        res = a1*b1+a2*b2+a1*b2;
                        break;
                    }
                    else{
                        queue1.remove();
                        queue2.remove();
                    }
                }
            }
        }
        else{
            if(cnt3>cnt4){
                for(int j=0;j<7;j++){
                    if(queue1.peek()==1||queue1.peek()==4){
                        break;
                    }
                    else {
                        queue1.add(queue1.poll());
                        queue2.add(queue2.poll());
                    }
                }
                while(true){
                    if(queue1.peek()==2||queue1.peek()==3){
                        int a1 = queue2.poll();
                        int b1 = queue2.poll();
                        int a2 = queue2.poll();
                        int b2 = queue2.poll();
                        res = a1*b1+a2*b2+a1*b2;
                        break;
                    }
                    else{
                        queue1.remove();
                        queue2.remove();
                    }
                }
            }
            else{
                for(int j=0;j<7;j++){
                    if(queue1.peek()==1||queue1.peek()==3){
                        break;
                    }
                    else {
                        queue1.add(queue1.poll());
                        queue2.add(queue2.poll());
                    }
                }
                while(true){
                    if(queue1.peek()==2||queue1.peek()==4){
                        int a1 = queue2.poll();
                        int b1 = queue2.poll();
                        int a2 = queue2.poll();
                        int b2 = queue2.poll();
                        res = a1*b1+a2*b2+a1*b2;
                        break;
                    }
                    else{
                        queue1.remove();
                        queue2.remove();
                    }
                }
            }
        }

        System.out.println(res);
    }

}
