package epmaapi.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import epmaapi.conn_class.db_settings;

public class courses_model {

    public String check_api_key_exist(String json_request) {

        String result = null;

        db_settings db = new db_settings();
        Connection conn = db.getCon();

        String SQL = "SELECT ses.select_all_courses()";;
        
        try {

               PreparedStatement pstmt = conn.prepareStatement(SQL);

              ResultSet rs = pstmt.executeQuery();

              while (rs.next()) {

              result = rs.getString("select_all_courses");

              System.out.println("Database returned:");
              System.out.println(result);

               }

          } catch (SQLException e) {

             e.printStackTrace();

            }
       
             finally {

            if (conn != null) {

                try {

                    conn.close();

                } catch (SQLException ex) {

                    ex.printStackTrace();

                }

            }

        }

      System.out.println("Final Result = " + result);
      return result;

    }

}