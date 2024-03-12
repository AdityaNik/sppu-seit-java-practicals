// /* Name : Aditya Nikam
//     Roll no : 3098
//     Problem Statement : Identify commonalities and differences between Publication, Book and Magazine classes.  
//     Title, Price, Copies are common instance variables and saleCopy is common method. The differences are, Bookclass has author and order Copies(). 
//     Magazine Class has methods orderQty, Currentissue, receiveissue().
//     Write a program to find how many copies of the given books  are ordered and  display  total sale of  publication. 
// */

// class Publication {
//     protected String title;
//     protected double price;
//     protected int copies;
//     protected int soldCopies;

//     // Constructor for the Publication class
//     public Publication(String title, double price, int copies) {
//         this.title = title;
//         this.price = price;
//         this.copies = copies;
//         this.soldCopies = 0;
//     }

//     // Method to sell copies
//     public double saleCopy(int qty) {
//         if (qty <= 0) {
//             System.out.println("\nInvalid quantity. Please enter a positive number.\n");
//             return 0.0;
//         }
//         if (qty > copies) {
//             System.out.println("\nNot enough copies available.....");
//             return 0.0;
//         }

//         soldCopies += qty;
//         copies -= qty;
//         return qty * price;
//     }

//     // Method to calculate the total sale amount
//     public double getTotalSale() {
//         return soldCopies * price;
//     }
// }

// class Book extends Publication {
//     private String author;

//     // Constructor for the Book class
//     public Book(String title, double price, int copies, String author) {
//         super(title, price, copies);
//         this.author = author;
//     }

//     // Method to order additional copies of the book
//     public void orderCopies(int qty) {
//         if (qty < 0) {
//             System.out.println("\nInvalid quantity for ordering copies. Please enter a non-negative number.");
//         } else {
//             copies += qty;
//         }
//     }

//     // Override the saleCopy method to provide a specific implementation for books
//     @Override
//     public double saleCopy(int qty) {
//         if (qty <= 0) {
//             System.out.println("\nInvalid quantity. Please enter a positive number.");
//             return 0.0;
//         }
//         if (qty > copies) {
//             System.out.println("\nNot enough copies available for the Book....");
//             return 0.0;
//         }

//         soldCopies += qty;
//         copies -= qty;
//         return qty * price;
//     }

//     @Override
//     public String toString() {
//         return "\nBook Title: " + title + "\nAuthor: " + author;
//     }
// }

// class Magazine extends Publication {
//     private int currentIssue;

//     // Constructor for the Magazine class
//     public Magazine(String title, double price, int copies, int currentIssue) {
//         super(title, price, copies);
//         this.currentIssue = currentIssue;
//     }

//     // Method to order additional copies of the magazine
//     public void orderQty(int qty) {
//         if (qty < 0) {
//             System.out.println("\nInvalid quantity for ordering copies. Please enter a non-negative number.");
//         } else {
//             copies += qty;
//         }
//     }

//     // Method to receive a new issue of the magazine
//     public void receiveIssue() {
//         currentIssue++;
//     }

//     // Override the saleCopy method to provide a specific implementation for
//     // magazines
//     @Override
//     public double saleCopy(int qty) {
//         if (qty <= 0) {
//             System.out.println("\nInvalid quantity. Please enter a positive number.");
//             return 0.0;
//         }
//         if (qty > copies) {
//             System.out.println("\nNot enough copies available for the Magazine....");
//             return 0.0;
//         }

//         soldCopies += qty;
//         copies -= qty;
//         return qty * price;
//     }

//     @Override
//     public String toString() {
//         return "\nMagazine Title: " + title + "\nCurrent Issue: " + currentIssue;
//     }
// }
