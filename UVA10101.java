package uva;
import java.util.Scanner;
public class UVA10101 {
	static void solve(long n) {
        if (n >= 10000000) {
            solve(n / 10000000);
            System.out.print(" kuti");
            n %= 10000000;
        }
        if (n >= 100000) {
            solve(n / 100000);
            System.out.print(" lakh");
            n %= 100000;
        }
        if (n >= 1000) {
            solve(n / 1000);
            System.out.print(" hajar");
            n %= 1000;
        }
        if (n >= 100) {
            solve(n / 100);
            System.out.print(" shata");
            n %= 100;
        }
        if (n > 0) {
            System.out.print(" " + n);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = 1;
        while (scanner.hasNextLong()) {
            long n = scanner.nextLong();
            // 輸出格式：4位數寬度的測資編號
            System.out.printf("%4d.", caseNum++);
            if (n == 0) {
                System.out.print(" 0");
            } else {
                solve(n);
            }
            System.out.println();
        }
    }
}

