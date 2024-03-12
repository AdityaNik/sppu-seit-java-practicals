import java.awt.Color;

public class TestFactoryPattern {

	CarFactory carBuilder;
	Car car;

	public static void main(String[] args) {
		TestFactoryPattern client = new TestFactoryPattern();
		client.buildCarMethod();
	}

	public void buildCarMethod() {

		System.out.println("building Hatchback car");
		carBuilder = new HatchbackCarFactory();
		car = carBuilder.buildCar("Polo", "Michelin", "VW");
		// carBuilder.paintCar(Color.BLUE);
		System.out.println("Car is assembled and painted now. Model of car is: " + car.getModel());

		System.out.println("building SEDAN car");
		carBuilder = new SedanCarFactory();
		car = carBuilder.buildCar("Dzire", "MRF", "Suzuki");
		// carBuilder.paintCar(Color.YELLOW);
		System.out.println("Car is assembled and painted now. Color of car is:" + car.getModel());

		System.out.println("building SUV car");
		carBuilder = new SUVCarFactory();
		car = carBuilder.buildCar("Innova", "Bridgestone", "Fiat");
		// carBuilder.paintCar(Color.RED);
		System.out.println("Car is assembled and painted now. Engine of car is:" + car.getModel());

		// Tomorrow if we want to build new type say MUV then we just hv to create new
		// subclass of Car class and new subclass of CarFactory. No need to update
		// exixtsing class.
		// This is beauty of factory method. Consumer always uses factory interface
		// instead of implementation
	}
}
