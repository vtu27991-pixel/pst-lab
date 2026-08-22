import java.util.Scanner;

// Custom Exception Class
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Supporting Placeholder Classes
class Rider {
    private String name, id;
    public Rider(String name, String id) {
        this.name = name;
        this.id = id;
    }
}

class Driver {
    private String name, id;
    public Driver(String name, String id) {
        this.name = name;
        this.id = id;
    }
}

abstract class Vehicle {
    protected String vehicleId;
    public Vehicle(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    public abstract double getRate();
}

class Bike extends Vehicle {
    public Bike(String vehicleId) { super(vehicleId); }
    @Override public double getRate() { return 10.0; }
}

class Auto extends Vehicle {
    public Auto(String vehicleId) { super(vehicleId); }
    @Override public double getRate() { return 15.0; }
}

class Cab extends Vehicle {
    public Cab(String vehicleId) { super(vehicleId); }
    @Override public double getRate() { return 20.0; }
}

class Trip {
    private Rider rider;
    private Driver driver;
    private Vehicle vehicle;
    private double distance;

    public Trip(Rider rider, Driver driver, Vehicle vehicle, double distance) {
        this.rider = rider;
        this.driver = driver;
        this.vehicle = vehicle;
        this.distance = distance;
    }

    public double getFare() {
        return distance * vehicle.getRate();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int n = sc.nextInt();

            if (n < 1 || n > 100000) {
                throw new InvalidBookingException(
                    "Number of trips must be between 1 and 100000"
                );
            }

            Rider rider = new Rider("Rider1", "R001");
            Driver driver = new Driver("Driver1", "D001");

            for (int i = 0; i < n; i++) {
                String rideType = sc.next();
                double distance = sc.nextDouble();

                if (distance <= 0) {
                    throw new InvalidBookingException(
                        "Distance must be greater than zero"
                    );
                }

                Vehicle vehicle;

                // Polymorphism
                switch (rideType.toLowerCase()) {
                    case "bike":
                        vehicle = new Bike("B101");
                        break;
                    case "auto":
                        vehicle = new Auto("A101");
                        break;
                    case "cab":
                        vehicle = new Cab("C101");
                        break;
                    default:
                        throw new InvalidBookingException(
                            "Invalid ride type: " + rideType
                        );
                }

                Trip trip = new Trip(
                    rider, driver, vehicle, distance
                );

                System.out.println(
                    (int) trip.getFare()
                );
            }

        } catch (InvalidBookingException e) {
            System.out.println("Booking Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Invalid input.");
        }

        sc.close();
    }
}