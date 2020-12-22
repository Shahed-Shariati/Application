package sample;

import java.sql.*;

public class DataBase {
    final private String url = "jdbc:sqlserver://localhost:1433;databaseName=shahed";
    final private String userName = "admin1";
    final private String passWord = "123qweR";
    private String query;
    private static Statement statement;
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    public DataBase() throws SQLException
    {
        try {
            connection = DriverManager.getConnection(url, userName, passWord);

            System.out.println("connect");
        }catch (SQLException e){
            System.out.println(e);
        }
     // ResultSet resultSet = statement.executeQuery(query);
    }
    public void setQuery(String query)
    {
        this.query = query;
    }





    public void InsertintoDataBase(OperatorSerGet info) throws SQLException
    {
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, info.getOperatorName());
            preparedStatement.setString(2, info.getOperatorUserName());
            preparedStatement.setString(3, info.getOperatorPass());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            System.out.println("insert not");
        }
    }
}
