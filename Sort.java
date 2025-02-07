import java.util.Scanner;

public class Sort {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] s= sc.next().toCharArray();
        for(int i=0; i<s.length;i++){
            int min=i;
            for(int j=i+1;j<s.length;j++){
                if(s[min]>s[j])
                {
                    char temp = s[min];
                    s[min]=s[j];
                    s[j]=temp;
                }
            }
        }
        String s1=new String(s);
        System.out.println("Sorted string:"+s1);
    }
    
}
