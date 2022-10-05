import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E_sansu{

    public static int start, end;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to distance chart!");
        System.out.println("1. Miles to Kilometers");
        System.out.println("2. Kilometers to Miles");
        String option = "default";
        while(true){
            System.out.print("Enter an option: ");
            option = br.readLine();
            if(option.length() == 1&& (option.charAt(0)=='1'||option.charAt(0)=='2'))
                break;
            else
                System.out.print(option+ "is an invalid option. Valid options are 1 or 2.\n");
        }
        boolean Checkip = false;
        while(!Checkip){
            System.out.print("Enter 2 integers between 1 to 1000 (inclusive) separated by a space: ");
            String[] input = br.readLine().split(" ");
            start = Integer.parseInt(input[0]);
            end = Integer.parseInt(input[1]);
            Checkip = Check_input();
        }

        if(option.charAt(0)=='1')
            M_to_K();
        else
            K_to_M();

        System.out.print(sb);


    }

    public static boolean Check_input(){
        if(start>end) {
            System.out.print("The range " + start + " " + end + " is NOT a valid range. Try again.\n");
            return false;
        }
        else if(start<=0 || end<=0 || start>1000 || end>1000) {
            System.out.print("The range " + start + " " + end + " is NOT a valid range. Try again.\n");
            return false;
        }
        else
            return true;
    }

    public static void M_to_K(){
        sb.append("MILES | KMS").append("\n");
        for(int i = start;i<=end;i++){
            if(i<10)
                sb.append("    ");
            else if(i>=10&&i<=99)
                sb.append("   ");
            else if(i == 1000)
                sb.append(" ");
            else
                sb.append("  ");
            double km = (i * 1.609344);
            sb.append(i+" | "+String.format("%.3f", km)).append("\n");
        }

    }

    public static void K_to_M(){
        sb.append("KMS | MILES").append("\n");
        for(int i = start;i<=end;i++){
            if(i<10)
                sb.append("    ");
            else if(i>=10&&i<=99)
                sb.append("   ");
            else if(i == 1000)
                sb.append(" ");
            else
                sb.append("  ");
            double mi = (i / 1.609344);
            sb.append(i+" | "+String.format("%.3f", mi)).append("\n");
        }
    }
}