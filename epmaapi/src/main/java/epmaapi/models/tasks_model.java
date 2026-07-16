package epmaapi.models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import epmaapi.conn_class.db_settings;

public class tasks_model {

    public String getAllTasks(int user_id) {

        String result = null;

        db_settings db = new db_settings();
        Connection conn = db.getCon();

        String SQL = "SELECT ses.select_all_tasks(?)";

        try {

            PreparedStatement pstmt = conn.prepareStatement(SQL);

            pstmt.setInt(1, user_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                result = rs.getString("select_all_tasks");
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


public String addTask(String taskName,
                      String description,
                      String dueDate,
                      String priority,
                      String status,
                       int userId) {

    String result = null;

    db_settings db = new db_settings();
    Connection conn = db.getCon();

    String SQL = "SELECT ses.add_task(?,?,?,?,?,?)";

    try {

        PreparedStatement pstmt = conn.prepareStatement(SQL);

        pstmt.setString(1, taskName);
        pstmt.setString(2, description);
        pstmt.setDate(3, java.sql.Date.valueOf(dueDate));
        pstmt.setString(4, priority);
        pstmt.setString(5, status);
        pstmt.setInt(6, userId);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            result = rs.getString("add_task");
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


public String deleteTask (int taskId) {

    String result = null;

    db_settings db = new db_settings();
    Connection conn = db.getCon();

    String SQL = "SELECT ses.delete_task(?)";

    try {

        PreparedStatement pstmt = conn.prepareStatement(SQL);

        pstmt.setInt(1, taskId);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            result = rs.getString("delete_task");
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
        }} return result;

    } 


    public String updateTask (int taskId,
                         String taskName,
                         String description,
                         String dueDate,
                         String priority,
                         String status) {

                         String result = null;

    db_settings db = new db_settings();
    Connection conn = db.getCon();

    String SQL = "SELECT ses.update_task(?,?,?,?,?,?)";

    try {

        PreparedStatement pstmt = conn.prepareStatement(SQL);

        pstmt.setInt(1, taskId);
        pstmt.setString(2, taskName);
        pstmt.setString(3, description);
        pstmt.setDate(4, java.sql.Date.valueOf(dueDate));
        pstmt.setString(5, priority);
        pstmt.setString(6, status);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            result = rs.getString("update_task");
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
}}