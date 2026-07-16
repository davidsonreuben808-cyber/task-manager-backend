package epmaapi.conn_class;

import java.sql.Connection;
import java.sql.DriverManager;

public class db_settings {

    public Connection getCon() {

        Connection con = null;

        try {

            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/gelis_db",
                    "postgres",
                    "1998");

            System.out.println("Database Connected Successfully!");

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

        return con;

    }
}