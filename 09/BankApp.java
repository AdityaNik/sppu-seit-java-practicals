/*
 * Name: Aditya Nikam
 * Roll: 3098
 * Problem Statement: Using concepts of Object-Oriented programming develop solution for any one application - 
                    Banking system having following operations : 1. Create an account 2. Deposit money 3. Withdraw money 
                    4. Honor daily withdrawal limit 5. Check the balance 6. Display Account information. 
 */

import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private double dailyWithdrawalLimit;
    private int pin;
    private String phoneNumber;
    private String email;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance, int pin,
            String phoneNumber, String email) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.dailyWithdrawalLimit = 500.0;
        this.pin = pin;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount, int enteredPin) {
        if (amount > 0 && amount <= dailyWithdrawalLimit) {
            if (amount <= balance) {
                if (enteredPin == pin) {
                    balance -= amount;
                    System.out.println(amount + " withdrawn successfully.");
                } else {
                    System.out.println("Incorrect PIN. Withdrawal failed.");
                }
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
            }
        } else {
            System.out.println("Invalid withdrawal amount or exceeded daily withdrawal limit. Withdrawal failed.");
        }
    }

    public double checkBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("\nAccount Information:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Daily Withdrawal Limit: " + dailyWithdrawalLimit);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
    }

    public void changePin(int currentPin, int newPin) {
        if (currentPin == pin) {
            pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Incorrect current PIN. PIN change failed.");
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Account Number: ");
        String accountNumber = scanner.next();

        System.out.println("Enter Account Holder Name: ");
        String accountHolderName = scanner.next();

        System.out.println("Enter Initial Balance: ");
        double initialBalance;
        while (true) {
            if (scanner.hasNextDouble()) {
                initialBalance = scanner.nextDouble();
                if (initialBalance >= 0) {
                    break;
                } else {
                    System.out.println("Initial balance must be non-negative. Enter again: ");
                }
            } else {
                System.out.println("Invalid input. Enter a valid initial balance: ");
                scanner.next(); // consume the invalid input
            }
        }

        System.out.println("Set a 4-digit PIN: ");
        int pin;
        while (true) {
            if (scanner.hasNextInt()) {
                pin = scanner.nextInt();
                if (String.valueOf(pin).length() == 4) {
                    break;
                } else {
                    System.out.println("PIN must be a 4-digit number. Enter again: ");
                }
            } else {
                System.out.println("Invalid input. Enter a valid 4-digit PIN: ");
                scanner.next(); // consume the invalid input
            }
        }

        System.out.println("Enter Phone Number: ");
        String phoneNumber;
        while (true) {
            phoneNumber = scanner.next();
            if (phoneNumber.matches("\\d{10}")) {
                break;
            } else {
                System.out.println("Invalid phone number. Enter a 10-digit number: ");
            }
        }

        System.out.println("Enter Email: ");
        String email;
        while (true) {
            email = scanner.next();
            if (email.endsWith("gmail.com")) {
                break;
            } else {
                System.out.println("Invalid email. Enter a valid email address: ");
            }
        }

        BankAccount bankAccount = new BankAccount(accountNumber, accountHolderName, initialBalance, pin, phoneNumber,
                email);

        int choice;
        char continueTransaction;

        do {
            System.out.println("\n\nChoices");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Information");
            System.out.println("5. Change PIN");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit: ");
                    double depositAmount;
                    while (true) {
                        if (scanner.hasNextDouble()) {
                            depositAmount = scanner.nextDouble();
                            if (depositAmount >= 0) {
                                break;
                            } else {
                                System.out.println("Deposit amount must be non-negative. Enter again: ");
                            }
                        } else {
                            System.out.println("Invalid input. Enter a valid deposit amount: ");
                            scanner.next(); // consume the invalid input
                        }
                    }
                    bankAccount.deposit(depositAmount);
                    break;

                case 2:
                    System.out.println("Enter amount to withdraw: ");
                    double withdrawalAmount;
                    while (true) {
                        if (scanner.hasNextDouble()) {
                            withdrawalAmount = scanner.nextDouble();
                            if (withdrawalAmount >= 0) {
                                break;
                            } else {
                                System.out.println("Withdrawal amount must be non-negative. Enter again: ");
                            }
                        } else {
                            System.out.println("Invalid input. Enter a valid withdrawal amount: ");
                            scanner.next(); // consume the invalid input
                        }
                    }
                    System.out.println("Enter your PIN: ");
                    int enteredPin;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            enteredPin = scanner.nextInt();
                            if (String.valueOf(enteredPin).length() == 4) {
                                break;
                            } else {
                                System.out.println("Entered PIN must be a 4-digit number. Enter again: ");
                            }
                        } else {
                            System.out.println("Invalid input. Enter a valid 4-digit PIN: ");
                            scanner.next(); // consume the invalid input
                        }
                    }
                    bankAccount.withdraw(withdrawalAmount, enteredPin);
                    break;

                case 3:
                    System.out.println("Current Balance: " + bankAccount.checkBalance());
                    break;

                case 4:
                    bankAccount.displayAccountInfo();
                    break;

                case 5:
                    System.out.println("Enter your current PIN: ");
                    int currentPin;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            currentPin = scanner.nextInt();
                            if (String.valueOf(currentPin).length() == 4) {
                                break;
                            } else {
                                System.out.println("Entered current PIN must be a 4-digit number. Enter again: ");
                            }
                        } else {
                            System.out.println("Invalid input. Enter a valid 4-digit PIN: ");
                            scanner.next(); // consume the invalid input
                        }
                    }
                    System.out.println("Enter your new PIN: ");
                    int newPin;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            newPin = scanner.nextInt();
                            if (String.valueOf(newPin).length() == 4) {
                                break;
                            } else {
                                System.out.println("Entered new PIN must be a 4-digit number. Enter again: ");
                            }
                        } else {
                            System.out.println("Invalid input. Enter a valid 4-digit PIN: ");
                            scanner.next(); // consume the invalid input
                        }
                    }
                    bankAccount.changePin(currentPin, newPin);
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }

            System.out.println("\nDo you want to perform another transaction (y/n)? ");
            continueTransaction = scanner.next().charAt(0);
        } while (continueTransaction == 'y');
    }
}
