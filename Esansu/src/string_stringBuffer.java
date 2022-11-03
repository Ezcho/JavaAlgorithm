public class string_stringBuffer {

    public static void main(String args[]){

        String str1 = "hello";
        String str2 = " world";
        System.out.println(str1+str2);

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        str1 = str1 + str2;
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        StringBuilder sb = new StringBuilder().append("abc");
        System.out.println(sb.hashCode());
        sb.append("cde");
        System.out.println(sb.hashCode());

        int a = Math.max(1,2);
    }
}
