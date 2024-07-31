// Book Class
class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

// Library Management System
class LibraryManagementSystem {
    private Book[] books;
    private int size;

    public LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Linear Search by Title
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Binary Search by Title (Assuming books are sorted by title)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void printAllBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }
}

// Main Class
public class LibraryManagementSystemDemo {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem(10);

        library.addBook(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("B002", "1984", "George Orwell"));
        library.addBook(new Book("B003", "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("B004", "Pride and Prejudice", "Jane Austen"));

        System.out.println("All Books in the Library:");
        library.printAllBooks();

        System.out.println("\nSearching for '1984' using Linear Search:");
        Book foundBookLinear = library.linearSearchByTitle("1984");
        if (foundBookLinear != null) {
            System.out.println(foundBookLinear);
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nSearching for 'To Kill a Mockingbird' using Binary Search:");
        Book foundBookBinary = library.binarySearchByTitle("To Kill a Mockingbird");
        if (foundBookBinary != null) {
            System.out.println(foundBookBinary);
        } else {
            System.out.println("Book not found.");
        }
    }
}
