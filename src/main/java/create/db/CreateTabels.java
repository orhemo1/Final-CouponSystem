package create.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.CouponSystemException;
/**
 * 
 * this was used in the beginning to create the tables in the data base.
 *
 */
public class CreateTabels {
	public static void main(String[] args) throws CouponSystemException {
		
		String url = "jdbc:derby:coupondb;create=true";

		
		String sqlA = "CREATE TABLE Company(Company_id BIGINT NOT NULL GENERATED ALWAYS"
				+ " AS IDENTITY (START WITH 1, INCREMENT BY 1) ,name"
				+ " VARCHAR(40),password VARCHAR(40),email VARCHAR(40),CONSTRAINT"
				+ " primary_key1 PRIMARY KEY (Company_id))";
		
		String sqlB = "CREATE TABLE Customer(Customer_id BIGINT NOT NULL GENERATED ALWAYS"
				+ " AS IDENTITY (START WITH 1, INCREMENT BY 1),name"
				+ " VARCHAR(40),password VARCHAR(40),CONSTRAINT primary_key2 PRIMARY KEY " + "(Customer_id))";
		
		String sqlC = "CREATE TABLE Coupon(Coupon_id BIGINT NOT NULL GENERATED ALWAYS"
				+ " AS IDENTITY (START WITH 1, INCREMENT BY 1), title VARCHAR(40), start_date DATE,"
				+ " end_date DATE, amount INTEGER, couponType VARCHAR(40), massage VARCHAR(225),"
				+ "price FLOAT, image VARCHAR(225), CONSTRAINT primary_key3 PRIMARY KEY (Coupon_id))";
		
		String sqlD = "CREATE TABLE CustomerCoupon(Customer_id BIGINT, Coupon_id"
				+ " BIGINT, PRIMARY KEY(Customer_id, Coupon_id))";
		
		String sqlE = "CREATE TABLE CompanyCoupon(Company_id BIGINT, Coupon_id"
				+ " BIGINT, PRIMARY KEY(Company_id, Coupon_id))";
		// get connection;
		try (Connection con = DriverManager.getConnection(url);) {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Statement stmt = con.createStatement();
			// creating tables;



			stmt.executeUpdate(sqlA);
			stmt.executeUpdate(sqlB);
			stmt.executeUpdate(sqlC);
			stmt.executeUpdate(sqlD);
			stmt.executeUpdate(sqlE);

		} catch (SQLException | ClassNotFoundException e) {
			throw new CouponSystemException("this is not allright", e);
		}
		System.out.println("tables are ready to use");
	}

}
