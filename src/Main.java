import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(10); //Set maximum capacity of the library
        //Create a menu-driven program
        while (true) {
            {
                System.out.println("---- LIBRARY MENU ----");
                System.out.println("1) Add a book to the library");
                System.out.println("2) Borrow a book using its ISBN");
                System.out.println("3) Return a book using its ISBN");
                System.out.println("4) Display details of all books");
                System.out.println("5) Display books borrowed in the last 7 days");
                System.out.println("6) Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt(); //Read the user's choice from the console
                scanner.nextLine();
                //Use a switch statement to handle different menu choices
                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String ISBN = scanner.nextLine();
                        //Check if the title,author and isbn were written correctly
                        if (title.isEmpty() || author.isEmpty() || ISBN.isEmpty()) {
                            System.out.println("Error. Please provide all required information.");
                        } else {
                            Book newBook = new Book(title, author, ISBN);
                            library.addBook(newBook);
                        }
                        break;

                    case 2:
                        System.out.print("Enter ISBN of the book to borrow: ");
                        ISBN = scanner.nextLine();
                        library.borrowBook(ISBN); //Call the library's borrowBook method to borrow the book
                        break;
                    case 3:
                        System.out.print("Enter ISBN of the book to return: ");
                        ISBN = scanner.nextLine();
                        library.returnBook(ISBN);//library's returnBook method
                        break;
                    case 4:
                        System.out.println("Details of all books in the library:");
                        library.displayAllBooks();
                        break;
                    case 5:
                        library.displayBooksBorrowedLast7Days();
                        break;
                    case 6:
                        System.out.println("Exiting the program.");
                        scanner.close();
                        System.exit(0);
                    default:
                        //Handle invalid input
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
                System.out.println("\nPress any key to go back to the MAIN MENU...");
                scanner.nextLine();
            }
        }
    }


}




