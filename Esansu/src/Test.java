public class Test {
    public int phoneNumber;
    Test(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public static void main(String args[]){

        Test a = new Test(4);
        Test b = a;
        b.phoneNumber = 5;
        System.out.println(a.phoneNumber);
    }
}


