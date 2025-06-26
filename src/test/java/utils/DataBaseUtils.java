package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataBaseUtils extends CommonMethods{
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;
    public static ResultSetMetaData resultSetMetaData;


    public static List<Map<String,String>>fetch(String query){

        List<Map<String,String>> tableData=new ArrayList<>();

        try {
            connection = DriverManager.getConnection(Constants.DB_URL,Constants.USER_NAME, Constants.USER_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSetMetaData = resultSet.getMetaData();



            while (resultSet.next()) {
                Map<String, String> rowMap = new LinkedHashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    String key = resultSetMetaData.getColumnLabel(i);
                    String value = resultSet.getString(i);
                    rowMap.put(key, value);
                }
                tableData.add(rowMap);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableData;
    }

}
/*
public static void main(String[] args) {

        try {

            connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER_NAME, Constants.USER_PASSWORD);
            statement = connection.createStatement();
            String query = "select * from person";
            resultSet = statement.executeQuery(query);
            resultSetMetaData = resultSet.getMetaData();

            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.print(resultSetMetaData.getColumnLabel(i) + " ");
            }
            while (resultSet.next()) {
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println();


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
 */
/*   /-------------/////////

    public static void main(String[] args) {

        try {

            connection = DriverManager.getConnection(Constants.DB_URL,Constants.USER_NAME,Constants.USER_PASSWORD);
            statement = connection.createStatement();
            String query = "Select * from person";
            resultSet = statement.executeQuery(query);
            resultSetMetaData = resultSet.getMetaData();

            List<Map<String, String>> tableData = new ArrayList<>();

            while (resultSet.next()) {
                Map<String, String> rowMap = new LinkedHashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    String key = resultSetMetaData.getColumnLabel(i);
                    String value = resultSet.getString(i);
                    rowMap.put(key, value);
                }
                tableData.add(rowMap);

            }

            System.out.print(tableData);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 */

