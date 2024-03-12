/* 
 * Name: Aditya Nikam
 * No: 3098
 * Problem Statement: Design and develop inheritance for a given case study, identify objects and relationships and implement inheritance wherever applicable. 
 * Employee class has Emp_name, Emp_id, Address, Mail_id, and Mobile_no as members. Inherit the classes: Programmer, Team Lead, Assistant Project Manager and Project Manager  from employee class. 
 * Add Basic Pay (BP) as the member of all the inherited classes with 97% of BP as DA, 10 % of BP as HRA, 12% of BP as PF, 0.1% of BP for staff club fund. Generate pay slips for the employees with their gross and net salary.
 */

import java.util.Scanner;

public class Employee {
	String empName, empAddress, empEmailID, empMobileNo;
	int Emp_Id;
	float BP;
	float Gross_Salary, Net_Salary;
	float DA, HRA, PF, SCF;

	void getEmployeeDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter the Employee name:"); // Employee name
		empName = sc.nextLine();

		System.out.println("\nenter the employee Id:"); // employee ID
		Emp_Id = sc.nextInt();

		sc.nextLine();
		System.out.println("\nEnter the Employee Address:"); // Employee empAddress
		empAddress = sc.nextLine();

		System.out.println("\nEnter the Employee Mail Id:"); // employee mail Id
		empEmailID = sc.nextLine();

		// validation for email
		boolean isValid = empEmailID.contains("@gmail.com");
		while (isValid == false) {
			System.out.println("Please enter the valid Email ID");
			empEmailID = sc.nextLine();
			isValid = empEmailID.contains("@gmail.com");
		}

		// employee Mobile no.
		System.out.println("\nEnter the Employee Mobile NO:");
		empMobileNo = sc.nextLine();
		int length = empMobileNo.length();
		// validation for mobile number
		while (length != 10) {
			System.out.println("\nPlease Enter the valid number");
			empMobileNo = sc.nextLine();
			length = empMobileNo.length();
		}
	}

	void generatePaySlip() {

		DA = 0.97f * BP; // DA= Dearness Allowance
		HRA = 0.10f * BP; // HRA= House Rent Allowances
		PF = 0.12f * BP; // PF= Provident Fund
		SCF = 0.001f * BP; // SCF= staff club fund
		Gross_Salary = BP + DA + HRA; // gross salary=BP+DA+HRA
		Net_Salary = Gross_Salary - (PF + SCF);
	}

	void displaySlip() {
		System.out.println("\n*********************** Employee Details ***********************");
		System.out.println("Employee Name         : " + empName);
		System.out.println("Employee ID           : " + Emp_Id);
		System.out.println("Employee Address      : " + empAddress);
		System.out.println("Employee Mail ID      : " + empEmailID);
		System.out.println("Employee Mobile No    : " + empMobileNo);
		System.out.println("*********************** PAY SLIP ***********************");
		System.out.println("Basic Pay             : " + BP);
		System.out.println("Gross Salary          : " + Gross_Salary);
		System.out.println("Net Salary            : " + Net_Salary);
		System.out.println("*************************************************************");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n\n1.Programmer Pay slip " + '\n' + "2.Team Lead pay slip" + '\n'
					+ "3.Assistant project Manager pay slip" + '\n' + "4.Project Manager Pay Slip" + '\n' + "5.Exit");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.println("Programmer Pay Slip Generating\n");
					Programmer pm = new Programmer();
					pm.getEmployeeDetails();
					pm.getBP();
					pm.generatePaySlip();
					pm.displaySlip();
					break;

				case 2:
					System.out.println("Team lead Pay Slip Generating\n");
					TeamLead tm = new TeamLead();
					tm.getEmployeeDetails();
					tm.getBP();
					tm.generatePaySlip();
					tm.displaySlip();
					break;

				case 3:
					System.out.println("Assistant Project Manager Pay Slip Generating\n");
					AssistantProjectManager apm = new AssistantProjectManager();
					apm.getEmployeeDetails();
					apm.getBP();
					apm.generatePaySlip();
					apm.displaySlip();
					break;

				case 4:
					System.out.println(" Project Manager Pay Slip Generating\n");
					ProjectManager pmg = new ProjectManager();
					pmg.getEmployeeDetails();
					pmg.getBP();
					pmg.generatePaySlip();
					pmg.displaySlip();
					break;
				case 5:
					System.out.println("Successfully Exited");
					break;
				default:
					System.out.println("Invalid choice" + '\n' + "Try Again!!!!\n");
					break;
			}
		} while (choice != 5);
		sc.close();
	}
}

// Inheritance
class Programmer extends Employee {
	Scanner sc = new Scanner(System.in);

	void getBP() { // BP= Basic Pay
		System.out.println("\nEnter the Basic Pay for Programmer:");
		BP = sc.nextFloat();
	}
}

class TeamLead extends Employee {
	Scanner sc = new Scanner(System.in);

	// BP = Basic Pay
	void getBP() {
		System.out.println("\nEnter the Basic Pay :");
		BP = sc.nextFloat();
	}
}

class AssistantProjectManager extends Employee {
	Scanner sc = new Scanner(System.in);

	// BP = Basic Pay
	void getBP() {
		System.out.println("\nEnter the Basic Pay :");
		BP = sc.nextFloat();
	}
}

class ProjectManager extends Employee {
	Scanner sc = new Scanner(System.in);

	// BP = Basic Pay
	void getBP() {
		System.out.println("\nEnter the Basic Pay :");
		BP = sc.nextFloat();
	}
}