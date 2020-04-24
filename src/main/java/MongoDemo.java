import dao.DBConnection;
import org.apache.log4j.Logger;
import service.Data;

public class MongoDemo {

    static Logger logger = Logger.getLogger(MongoDemo.class.getName());

    public static void main(String[] args) {

        final DBConnection dbConnection = new DBConnection();
        final Data data = new Data(dbConnection);

        logger.isTraceEnabled();

        data.saveData("Joseph King VI", "Red Light Street", "Rio de Janeiro",
                "SP", 1234, "12 Rules", 998);
    }
}
