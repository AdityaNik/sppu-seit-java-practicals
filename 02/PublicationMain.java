// import java.util.*;

// public class PublicationMain {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         // Create instances of Book and Magazine

//         Book book = new Book("Java Complete Reference", 3000.0, 20, "Balaguru Swami");
//         Magazine magazine = new Magazine("XYZ", 500.0, 200, 25);

//         System.out.println(book);
//         System.out.println(magazine);

//         System.out.println("\nAvailable Book Copies before ordering: " + book.copies);
//         System.out.println("Available Magazine Copies before Ordering: " + magazine.copies);

//         // Order copies
//         System.out.print("\nEnter the quantity of book copies to order: ");
//         int bookOrderQty = scanner.nextInt();
//         book.orderCopies(bookOrderQty);
//         System.out.println("\nCopies Ordered Successfully....\n");

//         System.out.print("\nEnter the quantity of magazine copies to order: ");
//         int magazineOrderQty = scanner.nextInt();
//         magazine.orderQty(magazineOrderQty);
//         System.out.println("\nCopies Ordered Successfully....\n");

//         // Display available copies
//         System.out.println("\nAvailable Book Copies: " + book.copies);
//         System.out.println("Available Magazine Copies: " + magazine.copies);

//         // Sale of copies
//         System.out.print("\nEnter the quantity of book copies to sell: ");
//         int bookSaleQty = scanner.nextInt();
//         if (bookSaleQty > book.copies) {
//             System.out.println("\nNot enough copies available....\n");
//         } else {
//             double bookSaleAmount = book.saleCopy(bookSaleQty);
//             if (bookSaleAmount > 0) {
//                 System.out.println("Sold " + bookSaleQty + " copies of the book.");
//             }
//         }

//         System.out.print("\nEnter the quantity of magazine copies to sell: ");
//         int magazineSaleQty = scanner.nextInt();
//         if (magazineSaleQty > magazine.copies) {
//             System.out.println("\nNot enough copies available.....\n");
//         } else {
//             double magazineSaleAmount = magazine.saleCopy(magazineSaleQty);
//             if (magazineSaleAmount > 0) {
//                 System.out.println("Sold " + magazineSaleQty + " copies of the magazine.");
//             }
//         }

//         // Display total sales
//         double totalSales = book.getTotalSale() + magazine.getTotalSale();
//         System.out.println("Total Sales: $" + totalSales);

//         scanner.close();
//     }
// }