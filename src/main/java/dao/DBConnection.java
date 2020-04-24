package dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DBConnection {

    private static final String URL = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "MongoDBTutorial";
    private static final String COLLECTION_NAME = "Person";

    public void connectingToDB(Document col) {
        MongoClient mongoClient = new MongoClient();

        try {
            mongoClient = new MongoClient(new MongoClientURI(URL));
            final MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            final MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
            collection.insertOne(col);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            mongoClient.close();
        }
    }

}
