/*
 * Name: Om Kishor Kharadkar
 * Roll No: 3097
 * Problem Statement : Design a class ‘Complex ‘with data members for real and imaginary part. Provide default and Parameterized constructors. 
    Write a program to perform arithmetic operations of two complex numbers.
 */

import java.util.Scanner;

public class Complex {
    int real, img;

    public Complex(int real, int img) {
        this.real = real;
        this.img = img;
    }

    void add(Complex B) {
        System.out.println("Addition Of Complex Numbers");

        System.out.println("n1 = " + this.real + " + i" + this.img);
        System.out.println("n2 = " + B.real + " + i" + B.img);

        // Add the two complex numbers
        Complex C = new Complex(this.real + B.real, this.img + B.img);

        System.out.println("Addition = " + C.real + " + i" + C.img);
    }

    void subtract(Complex B) {
        System.out.println("Subtraction Of Complex Numbers");

        System.out.println("n1 = " + this.real + " + i" + this.img);
        System.out.println("n2 = " + B.real + " + i" + B.img);

        // Subtract the second complex number from the first
        Complex C = new Complex(this.real - B.real, this.img - B.img);

        System.out.println("Subtraction = " + C.real + " + i" + C.img);
    }

    void multi(Complex B) {
        System.out.println("Multiplication Of Complex Numbers:");
        System.out.println("n1 = " + this.real + " + i" + this.img);
        System.out.println("n2 = " + B.real + " + i" + B.img);

        // Perform complex number multiplication
        Complex c = new Complex(((this.real * B.real) - (this.img * B.img)),
                ((this.real * B.img) + (this.img * B.real)));

        System.out.println("Multiplication = " + c.real + " + i" + c.img);
    }

    void division(Complex B) {
        System.out.println("Division Of Complex Numbers");
        System.out.println("n1 = " + this.real + " + i" + this.img);
        System.out.println("n2 = " + B.real + " + i" + B.img);

        // check for 0
        int den = (B.real * B.real) + (B.img * B.img);
        if (den != 0) {
            int r = ((this.real * B.real) + (this.img * B.img)) / den;
            int i = ((this.img * B.real) - (this.real * B.img)) / den;
            Complex c = new Complex(r, i);
            System.out.println("Division (quotient) = " + c.real + " + i" + c.img);
        } else {
            System.out.println("Denominator is zero. Division not possible.");
        }
    }

    public static void main(String[] args) {
        Complex X = new Complex(0, 0);
        Complex Y = new Complex(0, 0);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the real part of the first number: ");
        int realA = sc.nextInt();
        System.out.println("Enter the imaginary part of the first number: ");
        int imgA = sc.nextInt();

        System.out.println("Enter the real part of the second number: ");
        int realB = sc.nextInt();
        System.out.println("Enter the imaginary part of the second number: ");
        int imgB = sc.nextInt();

        X = new Complex(realA, imgA);
        Y = new Complex(realB, imgB);
        System.out.println("----------------------------------------------");
        System.out.println("Menu");
        System.out.println("1: addition");
        System.out.println("2: subtraction");
        System.out.println("3: multiplication");
        System.out.println("4: division");
        System.out.println("5: exit");
        System.out.println("----------------------------------------------");
        System.out.println("ENTER CHOICE = ");
        int choice = 0;
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                X.add(Y);
                break;
            case 2:
                X.subtract(Y);
                break;
            case 3:
                X.multi(Y);
                break;
            case 4:
                X.division(Y);
                break;
            case 5:
                int E = 0;
                System.out.println("Exit" + E);
            default:
                break;
        }
    }
}