package epmaapi.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import epmaapi.conn_class.db_settings;

public class users_model {

    public String registerUser(String fullName,
                               String email,
                               String password) {

        String result = null;

        db_settings db = new db_settings();
        Connection conn = db.getCon();

        String SQL = "SELECT ses.register_user(?,?,?)";

        try {

            PreparedStatement pstmt = conn.prepareStatement(SQL);

            pstmt.setString(1, fullName);
            pstmt.setString(2, email);
            pstmt.setString(3, password);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                result = rs.getString("register_user");
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            if (conn != null) {

                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }

        }

        return result;
    }

    public String loginUser(String email, String password) {

    String result = null;

    db_settings db = new db_settings();
    Connection conn = db.getCon();

    String SQL = "SELECT ses.login_user(?,?)";

    try {

        PreparedStatement pstmt = conn.prepareStatement(SQL);

        pstmt.setString(1, email);
        pstmt.setString(2, password);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            result = rs.getString("login_user");
        }

    } catch (SQLException e) {

        e.printStackTrace();

    } finally {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    return result;
}
}
