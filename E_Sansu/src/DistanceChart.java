import java.util.Scanner;

public class DistanceChart {

    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to distance chart!");
        System.out.println("1. Miles to Kilometers");
        System.out.println("2. Kilometers to Miles");
        System.out.print("Enter an option: ");

        String option = in.nextLine();

        while (!isOptionValid(option)) {
            System.out.println(option + " is an invalid option. Valid options are 1 or 2.");
            System.out.print("Enter an option: ");
            option = in.nextLine();
        }

        // If we reach here, then the option is valid.
        int numOption = Integer.parseInt(option);

        System.out.print("Enter 2 integers between 1 to 1000 (inclusive) separated by a space: ");
        int start = in.nextInt();
        int end = in.nextInt();
        while (!isRangeValid(start, end)) {
            System.out.println("The range " + start + " " + end + " is NOT a valid range. Try again.");
            System.out.print("Enter 2 integers between 1 to 1000 (inclusive) separated by a space: ");
            start = in.nextInt();
            end = in.nextInt();
        }

        switch (numOption) {
            case 1:
                System.out.println("MILES | KMS");
                convertMilesToKilometers(start, end);
                break;

            case 2:
                System.out.println(" KMS | MILES");
                convertKilometersToMiles(start, end);
                break;

            default:
                break;
        }

        System.out.print(sb);

        in.close();

    }

    public static void convertMilesToKilometers(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i < 10)
                sb.append("    ");
            else if (i >= 10 && i <= 99)
                sb.append("   ");
            else if (i == 1000)
                sb.append(" ");
            else
                sb.append("  ");
            double km = (i * 1.609344);
            sb.append(i + " | " + String.format("%.3f", km)).append("\n");
        }
    }
    public static void convertKilometersToMiles(int start, int end){
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
    public static boolean isRangeValid(int start, int end){
        if(start>end) {
            return false;
        }
        else if(start<=0 || end<=0 || start>1000 || end>1000) {
            return false;
        }
        else
            return true;
    }

    public static boolean isOptionValid(String option){
        if(option.length() == 1&& (option.charAt(0)=='1'||option.charAt(0)=='2'))
            return true;
        else
            return false;
    }
}
