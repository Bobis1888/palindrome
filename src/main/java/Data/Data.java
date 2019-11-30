package Data;

import core.Gamer;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

public class Data {
    private Connection connection;
    Data(){
        Prop prop = new Prop();
        initConnect(prop);
    }
    private void initConnect(Prop prop){
        try {
            Class.forName(prop.getJdbc()).getDeclaredConstructor().newInstance();
            System.out.println("Driver is loading...");
            connection = DriverManager.getConnection(prop.getUrl(),prop.getName(),prop.getPass());
            System.out.println("Connection...");
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public void closeConnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void addGamer(Gamer gamer){
        String sql = "INSERT INTO Gamer.LeaderBoards (name,points) Values (?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,gamer.getName());
            preparedStatement.setInt(2,gamer.getPoints());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void updateGamer(Gamer gamer){
        String sql = "update Gamer.LeaderBoards set points = ? where name = ? ;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,gamer.getPoints());
            preparedStatement.setString(2,gamer.getName());
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private ArrayList<Gamer> getListOfGamers(){
        ArrayList<Gamer> gamers = new ArrayList<>();
        Gamer gamer;
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("select * from Gamer.LeaderBoards;");
            result = statement.getResultSet();
            while (result.next()){
                gamer = new Gamer();
                gamer.setId(result.getInt(1));
                gamer.setName(result.getString(2));
                gamer.setPoints(result.getInt(3));
                gamers.add(gamer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                assert statement != null;
                statement.close();
                assert result != null;
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return gamers;
    }
    public static void main(String[] args) {
        Data data = new Data();

        System.out.println(data.getListOfGamers());
    }
}
