package org.example.repo;

import org.example.domain.Room;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class RoomDAO implements RoomDAOInterface {
    private static final String URL = "jdbc:mysql://localhost:3306/lampJDBC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "dimka228";
    private static Connection connection;


    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Room> findAll() {
        List<Room> rooms = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM lampJDBC";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                Room room = new Room();

//                room.setId(resultSet.getLong("id"));
                room.setCountry(resultSet.getString("country"));
                room.setName(resultSet.getString("name"));
                room.setOnOff(resultSet.getBoolean("on_off"));
                rooms.add(room);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rooms;
    }

    @Override
    public void save(Room room) {
        String query = "INSERT INTO lampJDBC (country, name, on_off) values (?, ?, ?)";
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setString(1, room.getCountry());
            preparedStatement.setString(2, room.getName());
            preparedStatement.setBoolean(3, room.isOnOff());

            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, Room updatedRoom) {
        String query = "UPDATE lampJDBC SET country=?, name=?, on_off=? WHERE id=?";
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setString(1, updatedRoom.getCountry());
            preparedStatement.setString(2, updatedRoom.getName());
            preparedStatement.setBoolean(3, updatedRoom.isOnOff());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Room findById(Long id) {
        Room room;
        String query = "SELECT * FROM lampJDBC WHERE id=?";
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.setLong(1, id);

            room = new Room();
            resultSet.next();

            room.setName(resultSet.getString("name"));
            room.setCountry(resultSet.getString("country"));
            room.setOnOff(resultSet.getBoolean("on_off"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } return room;
    }

    public void delete(Long id){
        String query = "DELETE FROM lampJDBC WHERE id=?";
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
