package HotelBookingSystem;
import java.sql.*;

public class BookingDAO {
	 public void bookRoom(int roomId, String customer, String checkin, String checkout) throws Exception {
	        Connection con = DBConnection.getConnection();

	        String updateRoom = "UPDATE rooms SET status='Booked' WHERE id=?";
	        PreparedStatement p1 = con.prepareStatement(updateRoom);
	        p1.setInt(1, roomId);
	        p1.executeUpdate();

	        String sql = "INSERT INTO bookings(room_id, customer_name, checkin, checkout) VALUES(?, ?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, roomId);
	        ps.setString(2, customer);
	        ps.setString(3, checkin);
	        ps.setString(4, checkout);
	        ps.executeUpdate();

	        System.out.println("Booking successful!");
	    }

	    public void cancelBooking(int bookingId) throws Exception {
	        Connection con = DBConnection.getConnection();

	        String getRoom = "SELECT room_id FROM bookings WHERE id=?";
	        PreparedStatement p = con.prepareStatement(getRoom);
	        p.setInt(1, bookingId);
	        ResultSet rs = p.executeQuery();
	        rs.next();
	        int roomId = rs.getInt("room_id");

	        String del = "DELETE FROM bookings WHERE id=?";
	        PreparedStatement p2 = con.prepareStatement(del);
	        p2.setInt(1, bookingId);
	        p2.executeUpdate();

	        String updateRoom = "UPDATE rooms SET status='Available' WHERE id=?";
	        PreparedStatement p3 = con.prepareStatement(updateRoom);
	        p3.setInt(1, roomId);
	        p3.executeUpdate();

	        System.out.println("Booking cancelled!");
	    }

}
