package libraryManager;
import java.util.ArrayList;
import java.util.Scanner;

    public class BookList {

        ArrayList<Book> myBooks = new ArrayList<>();
        //This method is to create the original number of books in library
        public BookList() {
            Book book1 = new Book("B101","The flying bird", "Anny Miller", false);
            Book book2 = new Book("B102", "The darken part", "Brittney Green", true);
            Book book3 = new Book("B103", "A retired life", "Peter Howard", true);
            Book book4 = new Book("B104", "Bark at a wrong tree", "Marry Peak", false);
            Book book5 = new Book("B105", "The memoir of human", "Peter Punk", false);
            myBooks.add(book1);
            myBooks.add(book2);
            myBooks.add(book3);
            myBooks.add(book4);
            myBooks.add(book5);
        }
        //This add method to allow the library manager add more books to the library
        String id = "";
        public void add() {
            System.out.println("Enter information for your new book below: ");
            Scanner input = new Scanner(System.in);

            System.out.print("Enter the book id: ");
            do {
                id = input.nextLine();

                if (isIdExisted(id)) {
                    System.out.println("This ID was already existed. Please try a new ID");
                }
            } while(isIdExisted(id));

            System.out.print("Enter the book's title: ");
            String title = input.nextLine();

            System.out.print("Enter the book's author: ");
            String author = input.nextLine();

            System.out.print("Is the book borrowed? Enter 1 if yes and 0 if no: ");
            int choice = input.nextInt();
            Boolean isBorrowed = false;
            switch (choice) {
                case 1:
                    isBorrowed = true;
                case 2:
                    isBorrowed = false;
            }
            addToList(id, title, author, false);
            System.out.println("A new book has been added!");
        }

        public void addToList(String id, String title, String author, Boolean isBorrowed) {
            Book Book = new Book(id, title, author, isBorrowed);
            myBooks.add(Book);
        }

        //This method is to check if the new ID that the manager wanted to add already existed on the system
        public boolean isIdExisted(String id) {
            for(Book book : myBooks) {
                if (id.toUpperCase().equals(book.getId())){
                    return true;
                }
            }
            return false;
        }

        //this method to allow user to search the book by its title using key words
        public void search() {
            ArrayList<Book> booksFound = new ArrayList<>();
            System.out.println("Enter book title to search: ");
            Scanner src = new Scanner(System.in);
            String searchKey = src.next();

            for (Book book : myBooks) {
                if (book.getTitle().toLowerCase().contains(searchKey)) {
                    booksFound.add(book);
                }
            }

            if (booksFound.isEmpty()) {
                System.out.println("No book was found");
            } else {
                System.out.println(String.format("%-10s%-20s%-20s%-20s", "ID", "Title", "Author", "Is borrowed"));
                for (Book book : booksFound) {
                    System.out.println(book.toString());
                }
            }
        }
        //this method is to display books in library
        public void display() {
            System.out.println(String.format("%-10s%-25s%-20s%-20s", "ID", "Title", "Author", "Is borrowed"));
            for (Book book : myBooks) {
                System.out.println(String.format("%-10s%-25s%-20s%-20s", book.getId(), book.getTitle(), book.getAuthor(), book.getBorrowed()));

            }
            System.out.println();
        }
        //this method allows user to borrow the book  by ID
        public void borrow() {
            System.out.println("Enter book ID to borrow: ");
            Scanner brr = new Scanner(System.in);
            String  searchId = brr.next();

            boolean isFound = false;


            for (Book aBook : myBooks) {
                if (aBook.getId().equalsIgnoreCase(searchId)) {
                    isFound = true;
                    if (aBook.getBorrowed()) {
                        System.out.println("The book has been borrowed. Please come back and try next time!");
                    } else {
                        aBook.setBorrowed(true);
                        System.out.println("You have successfully checking out the book: " + aBook.getTitle());
                        return;
                    }
                }
            }

            if(!isFound)
                System.out.println("Unfortunately, our library doesn't have the book with ID " + searchId);


        }
        //this is the goodbye message to the user after finishing the program
        public void exit() {
            System.out.println("You have successfully exit the program. Have a great one!");
        }
    }

