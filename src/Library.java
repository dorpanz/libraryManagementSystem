import java.time.LocalDate;
import java.util.Arrays;

public class Library {
    private Book[] books;
    private int maxBooks; //Max number of books the library can hold
    private int currentCount = 0; //Current number of books in the library

    public Library(int maxBooks) {
        this.maxBooks = maxBooks;
        this.books = new Book[maxBooks];
    }

    //Adds a book to the library if there's space
    //Maximum capacity is controlled in the Main
    public void addBook(Book book){
        if (maxBooks > currentCount ) {
            books[currentCount] = book;
            currentCount++;
            System.out.println("Book added");
        } else {
            System.out.println("Capacity of book has already reached maximum. Not able to add books");
        }
    }

    //Borrows a book identified by its ISBN
    public void borrowBook(String ISBN) {
        //Loop through the books in the library
        for (int i = 0; i < currentCount; i++) {
            if (books[i].getISBN().equals(ISBN)) { // Check if the ISBN of the current book matches the target ISBN
                books[i].borrowBook();
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found. ");
    }

    //Returns a borrowed book using its ISBN
    public void returnBook(String ISBN) {
        for (int i = 0; i < currentCount; i++) {
            if (books[i].getISBN().equals(ISBN)) {
                books[i].returnBook();
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found in the library.");
    }

    public void displayAllBooks() {
        //Check if the library is empty (no books added yet)
        if (currentCount == 0) {
            System.out.println("Empty. Please add books to the library.");
        } else {
            for (int i = 0; i < currentCount; i++) {
                // Display information for each book
                books[i].displayInfo();
            }
        }
    }

    public void displayBooksBorrowedLast7Days() {
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        // Define a flag to check if any books meet the criteria
        boolean found = false;
        for (Book book : books) {
            if (book != null && book.isBorrowed() && book.getBorrowDate() != null) {
                LocalDate borrowDate = book.getBorrowDate();
                if (currentDate.minusDays(7).isBefore(borrowDate) || currentDate.minusDays(7).isEqual(borrowDate)) {
                    // Display information for the book
                    book.displayInfo();
                    found = true; // Set the flag to true if at least one book meets the criteria
                }
            }
        }
        if (!found) {
            System.out.println("No books borrowed for the last 7 days");
        }
    }


    @Override
    public String toString() {
        return "Library{" +
                "books=" + Arrays.toString(books) +
                ", maxBooks=" + maxBooks +
                ", currentCount=" + currentCount +
                '}';
    }


}
