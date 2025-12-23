import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    service.addBook(title, author);
                    break;
                case 2:
                    service.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter book ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("Enter new author: ");
                    String newAuthor = sc.nextLine();
                    service.updateBook(updateId, newTitle, newAuthor);
                    break;
                case 4:
                    System.out.print("Enter book ID to delete: ");
                    int deleteId = sc.nextInt();
                    service.deleteBook(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
