import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    String isbn;

    // Constructor
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Display book details
    void display() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN  : " + isbn);
        System.out.println("-----------------------");
    }
}

public class LibraryManagement {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);
    }

    // Add a new book
    public static void addBook() {
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        System.out.print("Enter ISBN Number: ");
        String isbn = sc.nextLine();

        Book newBook = new Book(title, author, isbn);
        books.add(newBook);
        System.out.println("Book added successfully!");
    }

    // View all books
    public static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("\n--- Book List ---");
            for (Book b : books) {
                b.display();
            }
        }
    }

    // Search book by title
    public static void searchBook() {
        System.out.print("Enter title to search: ");
        String searchTitle = sc.nextLine();
        boolean found = false;

        for (Book b : books) {
            if (b.title.equalsIgnoreCase(searchTitle)) {
                System.out.println("\nBook Found:");
                b.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }
}
