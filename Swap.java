import java.util.Arrays;
import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String a1=sc.next();
        char[] a =a1.toCharArray();
        // Arrays.sort(a);
        for (int i=0;i<a.length;i+=2){
                char temp = a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
            }
        System.out.println(new String(a));
        
    }
    
}
