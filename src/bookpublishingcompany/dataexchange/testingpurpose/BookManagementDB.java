package bookpublishingcompany.dataexchange.testingpurpose;

import bookpublishingcompany.appicationlogic.publishingprocess.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookManagementDB {
    private Connection connection;

    public Book getBook(String bookId) throws SQLException {
        connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(
                "SELECT  name, price, copiesPrinted, draft, publishedState, copiesPublished FROM 9LLVL39k5B.Book WHERE bookId =  uuid_to_bin(?);"
        );
        stmt.setString(1, bookId);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            return new Book();
        }
        return null;
    }

    public ArrayList<Book> getAllBooks() throws SQLException {
        connection = Database.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT bookId,name, price, copiesPrinted, draft, publishedState, copiesPublished FROM 9LLVL39k5B.Book;");

        ArrayList<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            books.add(new Book());
        }
        return books;
    }

    public boolean addUnpublishedBook(Book book) throws SQLException {
        connection = Database.getConnection();

        Statement stmt0 = connection.createStatement();
        ResultSet result = stmt0.executeQuery("SELECT UUID() AS UUID");
        String UUID="";
        if(result.next()){
            UUID = result.getString("UUID");
        }

        PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO `9LLVL39k5B`.Book(name, price, copiesPrinted, draft, publishedState, copiesPublished,bookId)  VALUES (?,?,?,?,?,?,UUID_TO_BIN(?));"
        );
        stmt.setString(1, book.getName());
        stmt.setFloat(2, book.getPrice());
        stmt.setInt(3, book.getCopiesPrinted());
        stmt.setString(4, book.getDraft());
        stmt.setString(5, book.getState().getString());
        stmt.setInt(6, book.getCopiesPublished());
        stmt.setString(7, UUID);

        String finalUUID = UUID;
        book.getAuthors().forEach(author -> {
            try {
                PreparedStatement stmt2 = connection.prepareStatement(
                        "INSERT INTO `9LLVL39k5B`.Author_book(authorId, bookId) VALUES (?,?)"
                );
                stmt2.setString(1,author.getId());
                stmt2.setString(2, finalUUID);
                stmt2.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        return stmt.execute();
    }
}
