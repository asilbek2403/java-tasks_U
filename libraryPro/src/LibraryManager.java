import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class LibraryManager {
    private final List<Book> books = new ArrayList<>();

    public boolean addBook(Book book) {
        for (Book b : books) {
            if (b.getId().equals(book.getId())) {
                System.out.println("Book with this ID already exists!");
                return false;
            }
        }
        books.add(book);
        return true;
    }

    public Optional<List<Book>> getAllBooks() {
        if (books.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new ArrayList<>(books));
    }

    public Book getBookById(Integer id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                result.add(b);
            }
        }
        return result;
    }

    public boolean removeBook(Integer id) {
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}
