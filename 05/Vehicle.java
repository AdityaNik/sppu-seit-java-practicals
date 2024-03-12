
interface Vehicle {
    void gearChange(int newGear);

    void speedUp(int increment);

    void applyBrakes(int decrement);
}

class Bicycle implements Vehicle {
    int gear;
    int speed;

    public Bicycle() {
        gear = 1;
        speed = 0;
    }

    public void gearChange(int newGear) {
        System.out.println("Current gear : " + gear);
        if (newGear > 0 && newGear <= 6) {
            gear = newGear;
            System.out.println("Bicycle: Changed gear to " + gear);
        } else {
            System.out.println("Invalid gear change for Bicycle. Gear should be between 1 and 6.");
        }
    }

    public void speedUp(int increment) {
        System.out.println("Current speed: " + speed);
        if (increment > 0) {
            speed += increment;
            System.out.println("Bicycle: Speeding up to " + speed + " km/h");
        } else {
            System.out.println("Invalid speed increase for Bicycle.");
        }
    }

    public void applyBrakes(int decrement) {

        if (decrement > 0) {
            speed = speed - decrement;
            if (speed < 0) {
                speed = 0;
            }
            System.out.println("Bicycle: Applying brakes. Speed is now " + speed + " km/h");
        } else {
            System.out.println("Invalid brake application for Bicycle.");
        }

        System.out.println("Bicycle: Ringing the bell.");
    }
}

class Bike implements Vehicle {
    private int gear;
    private int speed;

    public Bike() {
        gear = 1;
        speed = 0;
    }

    public void gearChange(int newGear) {
        System.out.println("Current gear : " + gear);
        if (newGear > 0 && newGear <= 6) {
            gear = newGear;
            System.out.println("Bike: Changed gear to " + gear);
        } else {
            System.out.println("Invalid gear change for Bike. Gear should be between 1 and 6.");
        }
    }

    public void speedUp(int increment) {
        System.out.println("Current speed : " + speed);
        if (increment > 0) {
            speed += increment;
            System.out.println("Bike: Speeding up to " + speed + " km/h");
        } else {
            System.out.println("Invalid speed increase for Bike.");
        }
    }

    public void applyBrakes(int decrement) {
        if (decrement > 0) {
            speed -= decrement;
            if (speed < 0) {
                speed = 0;
            }
            System.out.println("Bike: Applying brakes. Speed is now " + speed + " km/h");
        } else {
            System.out.println("Invalid brake application for Bike.");
        }

        System.out.println("Bike: Putting up the kickstand.");
    }
}

class Car implements Vehicle {
    private int gear;
    private int speed;

    public Car() {
        gear = 1;
        speed = 0;
    }

    public void gearChange(int newGear) {
        System.out.println("Current gear : " + gear);
        if (newGear > 0 && newGear <= 6) {
            gear = newGear;
            System.out.println("Car: Changed gear to " + gear);
        } else {
            System.out.println("Invalid gear change for Car. Gear should be between 1 and 6.");
        }
    }

    public void speedUp(int increment) {
        System.out.println("Current speed : " + speed);
        if (increment > 0) {
            speed += increment;
            System.out.println("Car: Speeding up to " + speed + " km/h");
        } else {
            System.out.println("Invalid speed increase for Car.");
        }
    }

    public void applyBrakes(int decrement) {
        if (decrement > 0) {
            speed -= decrement;
            if (speed < 0) {
                speed = 0;
            }
            System.out.println("Car: Applying brakes. Speed is now " + speed + " km/h");
        } else {
            System.out.println("Invalid brake application for Car.");
        }

        System.out.println("Car: Starting the engine.");
    }
}