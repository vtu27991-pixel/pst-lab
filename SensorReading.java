
import java.util.*;
import java.util.stream.Collectors;
public class Main {
    static class SensorReading {
        String sensorId;
        double temperature;
        SensorReading(String sensorId, double temperature) {
            this.sensorId = sensorId;
            this.temperature = temperature;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<SensorReading> readings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String sensorId = sc.next();
            double temperature = sc.nextDouble();
            readings.add(new SensorReading(sensorId, temperature));
        }

        // Filter, Group, Average
        Map<String, Double> averageTemperatures = readings.stream()
                .filter(r -> r.temperature > 50)
                .collect(Collectors.groupingBy(
                        r -> r.sensorId,
                        Collectors.averagingDouble(r -> r.temperature)
                ));
        // Sort by average temperature in descending order
        averageTemperatures.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry ->
                        System.out.println(entry.getKey() + " " + entry.getValue()));
        sc.close();
    }
}
