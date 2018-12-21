package connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import exceptions.CouponSystemException;
/**
 * the connectionPool have 10 connections , every method start with taking one connection
 * and finished with returning the connection .
 * its a singleton .
 *
 */
public class ConnectionPool {

//		private String url = "jdbc:derby://localhost:1527/coupon;create=true";
	private String urlemb="jdbc:derby:coupondb;create=true";
	private Collection<Connection> connections;
	final static int con_min_size = 0;
	final static int con_max_size = 10;
	private int counter;
	
	public boolean closing;

	// singleton
	private ConnectionPool() throws CouponSystemException {
		connections = new HashSet<>();
		try {
		Class.forName("org.apache.derby.jdbc.ClientDriver");
			for (int i = 0; i < con_max_size; i++) {
				Connection con = DriverManager.getConnection(urlemb);
				connections.add(con);
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new CouponSystemException("connection pool initalization error", e);
		}
	}

	private static ConnectionPool instance;
/**
 * user cannot create a new connection pool . only use an instance of the only one .
 * @return
 * @throws CouponSystemException
 */
	public static ConnectionPool getInstance() throws CouponSystemException {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	/**
	 * all the methods use connection that thay get from this method . 
	 * @return
	 * @throws CouponSystemException
	 */
	public synchronized Connection getConnection() throws CouponSystemException {
		if (closing == true) {
			throw new CouponSystemException("we are clousing the progrem");
		}
		if (connections.size() == con_min_size) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new CouponSystemException("we have an interruption in getting a connection");
			}
		}
		Iterator<Connection> it = connections.iterator();
		Connection con = (Connection) it.next();
		connections.remove(con);
		return con;

	}
/**
 * every method in the dbdao finished by returning the connection thay took . 
 * @param con
 */
	public synchronized void returnConnection(Connection con) {
		connections.add(con);
		notify();
	}
/**
 * in this method first the system will stop giving connections and wait 
 * for all the  connections to come back and than close them all .
 * @throws CouponSystemException
 */
	public synchronized void clousAllConnection() throws CouponSystemException {
		closing = true;
		while (connections.size() < con_max_size) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new CouponSystemException("we were unterrupted", e);
			}
		}
		while (!(counter == con_max_size)) {
			Iterator<Connection> it = connections.iterator();
			it.next();
			it.remove();
			counter++;
		}

	}

}
