package HotelBookingSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RoomDAO {
	public void addRoom(String roomNo, String type, double price) throws Exception {
        String sql = "INSERT INTO rooms(room_no, type, price, status) VALUES(?, ?, ?, 'Available')";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, roomNo);
        ps.setString(2, type);
        ps.setDouble(3, price);
        ps.executeUpdate();
        System.out.println("Room added!");
    }

    public List<String> viewRooms() throws Exception {
        List<String> list = new ArrayList<>();
        String sql = "SELECT * FROM rooms";
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            list.add("ID: " + rs.getInt("id") +
                     ", Room: " + rs.getString("room_no") +
                     ", Type: " + rs.getString("type") +
                     ", Price: " + rs.getDouble("price") +
                     ", Status: " + rs.getString("status"));
        }
        return list;
    }
	

}
