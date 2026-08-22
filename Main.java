import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < n; i++) {

            String hashtag = sc.next();

            if (frequency.containsKey(hashtag)) {
                frequency.put(hashtag, frequency.get(hashtag) + 1);
            } else {
                frequency.put(hashtag, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {

            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        sc.close();
    }
}
