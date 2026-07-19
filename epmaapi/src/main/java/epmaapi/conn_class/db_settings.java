package epmaapi.conn_class;

import java.sql.Connection;
import java.sql.DriverManager;

public class db_settings {

    public Connection getCon() {

        Connection con = null;
            try {

    Class.forName("org.postgresql.Driver");

    String url = System.getenv("SPRING_DATASOURCE_URL");
    String username = System.getenv("SPRING_DATASOURCE_USERNAME");
    String password = System.getenv("SPRING_DATASOURCE_PASSWORD");

    System.out.println("URL = " + url);
    System.out.println("Username = " + username);
    System.out.println("Password is null = " + (password == null));

    con = DriverManager.getConnection(url, username, password);

    System.out.println("Database Connected Successfully!");

} catch (Exception ex) {

    System.out.println("DATABASE CONNECTION FAILED");
    ex.printStackTrace();

}

        return con;

    }
}