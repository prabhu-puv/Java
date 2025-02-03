import java.util.*;
interface LibraryOperations {
    void addBook(Book book);
    boolean borrowBook(int bookID);
    boolean returnBook(int bookID);
    void viewBooks();
}
abstract class Book {
    protected int bookID;
    protected String title;
    protected String author;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
    }
    public int getBookID() {
        return bookID;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public abstract void displayInfo();
}
class LibraryBook extends Book {
    private boolean isBorrowed;
    public LibraryBook(int bookID, String title, String author) {
        super(bookID, title, author);
        this.isBorrowed = false;
    }
    public boolean isBorrowed() {
        return isBorrowed;
    }
    public void borrow() {
        isBorrowed = true;
    }
    public void returnBook() {
        isBorrowed = false;
    }
    @Override
    public void displayInfo() {
        System.out.println("Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Status: " + (isBorrowed ? "Borrowed" : "Available"));
    }
}
class Library implements LibraryOperations {
    private Map<Integer, LibraryBook> books = new HashMap<>();
    @Override
    public void addBook(Book book) {
        if (book instanceof LibraryBook) {
            books.put(book.getBookID(), (LibraryBook) book);
            System.out.println("Book added: " + book.getTitle());
        }
    }
    @Override
    public boolean borrowBook(int bookID) {
        LibraryBook book = books.get(bookID);
        if (book != null && !book.isBorrowed()) {
            book.borrow();
            System.out.println("Book borrowed: " + book.getTitle());
            return true;
        } else {
            System.out.println("Book not available.");
            return false;
        }
    }
    @Override
    public boolean returnBook(int bookID) {
        LibraryBook book = books.get(bookID);
        if (book != null && book.isBorrowed()) {
            book.returnBook();
            System.out.println("Book returned: " + book.getTitle());
            return true;
        } else {
            System.out.println("Invalid return request.");
            return false;
        }
    }
    @Override
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (LibraryBook book : books.values()) {
                book.displayInfo();
            }
        }
    }
}
public class Librarymanagementsystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new LibraryBook(bookID, title, author));
                    break;
                case 2:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowID = scanner.nextInt();
                    library.borrowBook(borrowID);
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnID = scanner.nextInt();
                    library.returnBook(returnID);
                    break;
                case 4:
                    library.viewBooks();
                    break;
                case 5:
                    System.out.println("Exiting Library System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 5);

        scanner.close();
}
}