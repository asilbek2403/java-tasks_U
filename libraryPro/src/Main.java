import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n<<<<<<  Library Menu >>>>>");
            System.out.println("1. Add new book");
            System.out.println("2. Show all books");
            System.out.println("3. Find book by ID");
            System.out.println("4. Find books by Author");
            System.out.println("5. Delete book by ID");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book id: ");
                    Integer id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();

                    Book book = new Book(id, title, author);
                    if (manager.addBook(book)) {
                        System.out.println("Book added successfully!");
                    }
                    break;

                case 2:
                    manager.getAllBooks().ifPresentOrElse(
                            books -> books.forEach(System.out::println),
                            () -> System.out.println(" No books available.")
                    );
                    break;

                case 3:
                    System.out.print("Enter book id: ");
                    int searchId = sc.nextInt();
                    Book foundBook = manager.getBookById(searchId);
                    if (foundBook != null) {
                        System.out.println(foundBook);
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter author name: ");
                    String searchAuthor = sc.nextLine();
                    for (Book b : manager.getBooksByAuthor(searchAuthor)) {
                        System.out.println(b);
                    }
                    break;

                case 5:
                    System.out.print("Enter book id to delete: ");
                    Integer deleteId = sc.nextInt();
                    if (manager.removeBook(deleteId)) {
                        System.out.println("Book deleted.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exit...(Cancel)");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
