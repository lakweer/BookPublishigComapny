package bookpublishingcompany.dataexchange.testingpurpose;

import bookpublishingcompany.appicationlogic.customermanagement.Author;
import bookpublishingcompany.appicationlogic.publishingprocess.Book;
import bookpublishingcompany.appicationlogic.publishingprocess.UnpublishedBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BookManagementDB {
    private Connection connection;

    public UnpublishedBook addUnpublishedBook(UnpublishedBook book) throws SQLException {
        connection = Database.getConnection();

        //Obtaining a unique ID
        Statement stmt0 = connection.createStatement();
        ResultSet result = stmt0.executeQuery("SELECT UUID() AS UUID");
        String UUID = "";
        if (result.next()) {
            UUID = result.getString("UUID");
        }

        //Set the ID to the book
        book.setId(UUID);
        String finalUUID = book.getId();

        //Insert record of book into Book table
        PreparedStatement stmt1 = connection.prepareStatement(
                "INSERT INTO `9LLVL39k5B`.Book (name, bookId) VALUES (?, UUID_TO_BIN(?));"
        );
        stmt1.setString(1, book.getName());
        stmt1.setString(2, finalUUID);
        stmt1.execute();

        //Insert record of book into UnpublishedBook table
        PreparedStatement stmt2 = connection.prepareStatement(
                "INSERT INTO `9LLVL39k5B`.UnpublishedBook(name, bookState,bookId)  VALUES (?,?, UUID_TO_BIN(?));"
        );

        UnpublishedBook.BookState[] states = UnpublishedBook.BookState.values();
        stmt2.setString(1, book.getName());
        stmt2.setInt(2, Arrays.asList(states).indexOf(book.getState()));
        stmt2.setString(3, finalUUID);
        stmt2.execute();

        //Insert record(s) into Author_book table
        book.getAuthors().forEach(author -> {
            try {
                PreparedStatement stmt3 = connection.prepareStatement(
                        "INSERT INTO `9LLVL39k5B`.Author_book(authorId, bookId) VALUES (UUID_TO_BIN(?), UUID_TO_BIN(?))"
                );
                stmt3.setString(1, author.getId());
                stmt3.setString(2, finalUUID);
                stmt3.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return book;
    }

    public ArrayList<Author> getAuthorsOfBook(Book book) throws SQLException {
        connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(
                "SELECT BIN_TO_UUID(authorId) authorId FROM `9LLVL39k5B`.Author_book WHERE bookId=UUID_TO_BIN(?)"
        );

        stmt.setString(1,book.getId());
        ResultSet resultSet = stmt.executeQuery();
        StringBuilder builder = new StringBuilder();
        ArrayList<String> ids = new ArrayList<>();
        while (resultSet.next()){
            builder.append("UUID_TO_BIN(?),");
            ids.add(resultSet.getString(1));
        }

        PreparedStatement stmt2 = connection.prepareStatement(
                "SELECT BIN_TO_UUID(authorId) authorId, name, mobileNo, email FROM  `9LLVL39k5B`.Author WHERE authorId IN ("+builder.deleteCharAt( builder.length() -1 ).toString() + ")"
        );
        for(int i=1;i<=ids.size();i++){
            stmt2.setString(i,ids.get(i-1));
        }
        ResultSet resultSet1 = stmt2.executeQuery();
        ArrayList<Author> authors = new ArrayList<>();
        while (resultSet.next()){
            authors.add(new Author(
                    resultSet1.getString(1),
                    resultSet1.getString(2),
                    resultSet1.getInt(3),
                    resultSet1.getString(4)

            ));
        }
        return authors;
    }

    public UnpublishedBook getUnPublishedBook(String bookId) throws SQLException {
        connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(
                "SELECT bookId, name, bookState  FROM 9LLVL39k5B.UnpublishedBook WHERE bookId =  uuid_to_bin(?);"
        );
        stmt.setString(1, bookId);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            return new UnpublishedBook(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    UnpublishedBook.BookState.values()[resultSet.getInt(3)]
            );
        }
        return null;
    }

    public ArrayList<UnpublishedBook> getUnPublishedBooks() throws SQLException {
        connection = Database.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT bookId, name, bookState FROM 9LLVL39k5B.UnpublishedBook;");

        ArrayList<UnpublishedBook> books = new ArrayList<>();
        while (resultSet.next()) {
            books.add(new UnpublishedBook(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    UnpublishedBook.BookState.values()[resultSet.getInt(3)]
                    ));
        }
        return books;
    }

}
