import java.sql.*;

public class LibraryService {
    private Connection conn;

    public LibraryService() {
        conn = DatabaseConnection.getConnection();
        if (conn != null) {
            System.out.println("Database connected successfully!");
        }
    }

    // Add a book
    public void addBook(String title, String author) {
        try {
            String sql = "INSERT INTO books (title, author, isAvailable) VALUES (?, ?, true)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View all books
    public void viewBooks() {
        try {
            String sql = "SELECT * FROM books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("ID | Title | Author | Available");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        rs.getBoolean("isAvailable"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update a book
    public void updateBook(int id, String title, String author) {
        try {
            String sql = "UPDATE books SET title=?, author=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setInt(3, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Book updated successfully!");
            else System.out.println("Book ID not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a book
    public void deleteBook(int id) {
        try {
            String sql = "DELETE FROM books WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Book deleted successfully!");
            else System.out.println("Book ID not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
