import java.util.Scanner;

public class MaximumProfitAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        int N = sc.nextInt();

        int[] profit = new int[N];

       
        for (int i = 0; i < N; i++) {
            profit[i] = sc.nextInt();
        }

        
        int maxEndingHere = profit[0];
        int maxSoFar = profit[0];

        
        for (int i = 1; i < N; i++) {

            maxEndingHere = Math.max(profit[i], maxEndingHere + profit[i]);

            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        
        System.out.println(maxSoFar);

        sc.close();
    }
}