import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isBorrowed;
    private LocalDate borrowDate;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.borrowDate = null;
    }

    // Creating getters for ISBN, IsBorrowed and borrowDate
    public String getISBN() {
        return ISBN;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    //Changes the isBorrowed status to true, if it has not been borrowed before
    //Also saves the borrow date
    public void borrowBook(){
        if(!isBorrowed) {
            isBorrowed = true;
            borrowDate = LocalDate.now();
            System.out.println("Book has been borrowed");
        } else {
        System.out.println("Book not available");
        }
    }

    //Changes the isBorrowed status to false
    public void returnBook(){
        if(isBorrowed) {
            isBorrowed = false;
            borrowDate = null;
            System.out.println("Book has been returned");
        }
          else {
                System.out.println("Book is not borrowed");
            }
        }

    //Prints the details of the book
    public void displayInfo(){
        System.out.println("--- Book Information ---");
        System.out.println("Book title: " + title +
                "\nAuthor: " + author +
                "\nISBN: " + ISBN +
                "\nIs Borrowed: " + (isBorrowed ? "Yes" : "No"));
        if (isBorrowed) {
            System.out.println("Borrow Date: " + borrowDate);
        }

    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", isBorrowed=" + isBorrowed +
                ", borrowDate=" + borrowDate +
                '}';
    }


}
