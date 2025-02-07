import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args){

        try (Scanner sc = new Scanner(System.in)) {
            String s =sc.next();
            int n =s.length();
            int flag=1;
            for ( int i=0;i<n/2;i++){
                if (s.charAt(i)== s.charAt(n-i-1)){
                    continue;
                }
                flag=0;
                System.out.println("Not a palindrome");
                return;
                }
            
            if (flag==1){
                System.out.println("Palindrome");
            }
        }
    }
}     
