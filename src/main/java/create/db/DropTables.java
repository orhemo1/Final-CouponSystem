package create.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.CouponSystemException;
/**
 * 
 *this is for the software engineer use.
 *
 */
public class DropTables {
	public static void main(String[] args) throws CouponSystemException {
		
		String url = "jdbc:derby://localhost:1527/coupon;create=true";

		String sql1 = "DROP TABLE Company";
		String sql2 = "DROP TABLE Customer";
		String sql3 = "DROP TABLE Coupon";
		String sql4 = "DROP TABLE CustomerCoupon";
		String sql5 = "DROP TABLE CompanyCoupon";
		
		
		// get connection;
		try (Connection con = DriverManager.getConnection(url);) {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Statement stmt = con.createStatement();
			// creating tables;


			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql4);
			stmt.executeUpdate(sql5);
		

		} catch (SQLException | ClassNotFoundException e) {
			throw new CouponSystemException("this is not allright", e);
		}
		System.out.println("everythig was deleted");
	}

}
