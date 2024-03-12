/*
 * Name: Aditya Nikam
 * Roll No: 3098
 * Problem Statement: Design a base class shape with two double type values and member functions to input the data and compute_area() for calculating area of shape. 
 * 		Derive two classes: triangle and rectangle. Make compute_area() as abstract  function and redefine this function in the derived class to suit their requirements. Write a program that accepts dimensions of triangle/rectangle and display calculated area. 
 * 		Implement dynamic binding for given case study. 
 */

import java.util.Scanner;

class Shape {
	double width;
	double height;
	double side1, side2, side3;

	public void get() {
	}

	public void area() {
	}
}

class Ractangle extends Shape {

	Scanner sc = new Scanner(System.in);

	// overridden method for getting width and height
	public void get() {
		System.out.println("\n\nEnter width and height for ractangle: ");
		width = sc.nextDouble();
		height = sc.nextDouble();
	}

	// overridden method for calculating area of ractangle
	public void area() {
		// validation for ractangle
		if (width < 0 || height < 0) {
			System.out.println("\nInvalid Inputs");
			return;
		}
		System.out.println("\nArea of Ractangle : " + width * height);
	}
}

class Triangle extends Shape {
	Scanner sc = new Scanner(System.in);

	// overridden method for getting sides of ractangle
	public void get() {
		System.out.println("\n\nEnter 3 sides for ractangle: ");
		side1 = sc.nextDouble();
		side2 = sc.nextDouble();
		side3 = sc.nextDouble();
	}

	// overridden method for calculating area of Triangle
	public void area() {
		if ((side1 + side2) < side3) {
			System.out.println("\nEnter valid side"); // validation
			return;
		}
		double s = (side1 + side2 + side3) / 2.0;
		double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		System.out.println("\nArea of Triangle : " + area);
	}
}

public class Main {
	public static void main(String[] args) {
		Shape rectangle = new Ractangle();
		Shape triangle = new Triangle();
		while (true) {
			// for ractangle
			rectangle.get();
			rectangle.area();

			// for Triangle
			triangle.get();
			triangle.area();
		}
	}
}