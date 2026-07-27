import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of employees
        int N = sc.nextInt();

        // Read salaries
        List<Integer> salaries = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            salaries.add(sc.nextInt());
        }

        // Increase each salary by 10%
        List<Integer> updatedSalaries = salaries.stream()
                .map(salary -> salary + (salary * 10 / 100))
                .collect(Collectors.toList());

        // Print updated salaries
        for (int salary : updatedSalaries) {
            System.out.print(salary + " ");
        }

        sc.close();
    }
}
