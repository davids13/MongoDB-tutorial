package service;

import dao.DBConnection;
import org.bson.Document;

public class Data {

    private final DBConnection dbConnection;

    public Data(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public Document createData(final String name, final String street, final String city,
                               final String state, final int zip, final String bookName, final int isbn) {
        final Document documentBook = new Document();
        documentBook.append("title", bookName);
        documentBook.append("isbn", isbn);

        final Document document = new Document();
        document.append("_id", Math.ceil(Math.random() * 10));
        document.append("name", name);
        document.append("address", new Document()
                .append("street", street)
                .append("city", city)
                .append("state", state)
                .append("zip", zip));
        document.append("books", documentBook);

        return document;
    }

    // Save it into your database
    public void saveData(final String name, final String street, final String city,
                         final String state, final int zip, final String bookName, final int isbn) {
        dbConnection.connectingToDB(createData(name, street, city, state, zip,bookName, isbn));
    }

}