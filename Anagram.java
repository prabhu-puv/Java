import java.util.Arrays;
import java.util.Scanner;

class Main{
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
    String s1=sc.next();
String s2=sc.next();
if (s1.length()!=s2.length()){
    System.out.println("not a anagram");
    return;
}
    char str1[]=s1.toCharArray();
    char str2[]=s1.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);

    s1=new String(str1);
    s2=new String(str2);
    System.out.println((s1.equals(s2))?"anagram":"not a anagram");
}
}