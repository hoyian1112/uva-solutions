package uva1023;
import java.util.Scanner;
public class uva00272 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isFirst = true; 

        
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                
                if (c == '"') {
                    if (isFirst) {
                        System.out.print("``"); 
                    } else {
                        System.out.print("''");
                    }
                    isFirst = !isFirst; 
                } else {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
        
        sc.close();
    }
}
