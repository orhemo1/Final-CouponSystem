package dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import beans.Company;
import beans.Coupon;
import beans.CouponType;
import connectionPool.ConnectionPool;
import dao.CompanyDAO;
import exceptions.CouponSystemException;

/**
 * there is no business logic in this layer. only CRUD (create,read,update and
 * delete) methods and simple methods that will be in use in the facade layer
 * according to the customer needs.
 * 
 *
 */
public class CompanyDaoDb implements CompanyDAO {
	Collection<Company> companies;
	long memberId;

	public CompanyDaoDb() {
	}

	/**
	 * the company will get the id from the tabel and not from the user so its will
	 * be unique
	 */

	@Override
	public void create(Company company) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection con1 = cp.getConnection();
		String sql1 = "INSERT INTO Company(name, password, email) VALUES(?, ?, ?)";

		try (PreparedStatement pstmt = con1.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS);) {

			pstmt.setString(1, company.getName());
			pstmt.setString(2, company.getPassword());
			pstmt.setString(3, company.getEmail());
			pstmt.executeUpdate();

			ResultSet res = pstmt.getGeneratedKeys();
			res.next();

			company.setId(res.getLong(1));
			System.out.println("your company id is:" + company.getId());
		} catch (SQLException e) {
			throw new CouponSystemException("one or more of the detaile you gave are from the wrong type");
		} finally {
			cp.returnConnection(con1);
		}

	}

	@Override
	public void remove(Company company) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection con1 = cp.getConnection();
		long companyId = company.getId();
		String sql2 = "DELETE FROM Company WHERE Company_id=" + companyId;
		try {
			con1.prepareStatement(sql2).executeUpdate();
			System.out.println("company deleted");

		} catch (SQLException e) {
			throw new CouponSystemException("remove comapny failed", e);
		} finally {
			cp.returnConnection(con1);

		}
	}

	/**
	 * user cannot update the id
	 */
	@Override
	public void update(Company company) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection con1 = cp.getConnection();
		long companyId = company.getId();
		String sql = "UPDATE Company SET name=?,password=?,email=? WHERE Company_id=" + companyId;
		try {
			PreparedStatement psmt = con1.prepareStatement(sql);
			psmt.setString(1, company.getName());
			psmt.setString(2, company.getPassword());
			psmt.setString(3, company.getEmail());
			psmt.executeUpdate();
			System.out.println("company updeted");
		} catch (SQLException e) {
			throw new CouponSystemException("some of the details you gave are wrong");
		} finally {
			cp.returnConnection(con1);
		}

	}

	@Override
	public Company getCompany(long id) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection con = cp.getConnection();
		long compId = id;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Company WHERE Company_id=" + compId);
			if (rs.next()) {
				Company company = new Company(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
				return company;
			} else {
				throw new CouponSystemException("no company have  "+id+"as id");
			}

		} catch (SQLException e) {
			throw new CouponSystemException("something went wrong");
		} finally {
			cp.returnConnection(con);
		}

	}

	/**
	 * in this method the user can get all the existing companies in the system
	 */
	@Override
	public Collection<Company> getAllCompanies() throws CouponSystemException {
		Collection<Company> allCompanies = new ArrayList<>();
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection con1 = cp.getConnection();
		try {
			Statement stmt = con1.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Company");
			while (rs.next()) {
				allCompanies.add(new Company(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}

		} catch (SQLException e) {
			throw new CouponSystemException("somethig went wrong");
		} finally {
			cp.returnConnection(con1);
		}
		return allCompanies;
	}

	/**
	 * this method will give the user HashSet with all the company coupons .
	 */
	@Override
	public Collection<Coupon> getCoupons(long companyId) throws CouponSystemException {

		List<Coupon> couponsList = new ArrayList<>();
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection con1 = cp.getConnection();
		String sql = "select * from companycoupon inner join coupon on coupon.coupon_id=companycoupon.coupon_id "
				+ "where company_id=" + companyId;
		try {
			Statement st = con1.createStatement();
			ResultSet res = st.executeQuery(sql);
			while (res.next()) {
				couponsList.add(new Coupon(res.getLong(2), res.getString(4), res.getDate(5), res.getDate(6),
						res.getInt(7), CouponType.valueOf(res.getString(8)), res.getString(9), res.getDouble(10),
						res.getString(11)));
			}
			return couponsList;

		} catch (SQLException e) {
			throw new CouponSystemException("somethig went wrong , chack the company-id");
		} finally {
			cp.returnConnection(con1);

		}
	}

	/**
	 * the logIn method will return true if we get a result it mean the query is
	 * true to get company from the database
	 */
	@Override
	public boolean logIn(String companyName, String password) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection con1 = cp.getConnection();
		String details = "SELECT * FROM Company WHERE name='" + companyName + "' AND password='" + password + "'";
		try {
			Statement st = con1.createStatement();
			ResultSet res = st.executeQuery(details);
			if (res.next()) {
				return true;
			}

			return false;

		} catch (SQLException e) {
			throw new CouponSystemException("logIn faild, user-name or password are wrong");
		} finally {
			cp.returnConnection(con1);
		}

	}

	/**
	 * this is additional methods to handle the join tabels
	 * 
	 * @param companyId
	 * @param couponId
	 * @throws CouponSystemException
	 */

	public void companyCouponAppdate(long companyId, long couponId) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection con1 = cp.getConnection();
		String sql = "INSERT INTO CompanyCoupon (Company_id,Coupon_id) VALUES(?, ?)";
		try (PreparedStatement psmt = con1.prepareStatement(sql);) {
			psmt.setLong(1, companyId);
			psmt.setLong(2, couponId);
			psmt.executeUpdate();
			System.out.println("company coupon Appdated");
		} catch (SQLException e) {
			throw new CouponSystemException("something went wrong.company-id or company id are wrong");
		} finally {
			cp.returnConnection(con1);
		}
	}

	public void removeCompanyCoupons(long couponId) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection con1 = cp.getConnection();
		String sql = "DELETE FROM CompanyCoupon WHERE Coupon_id=" + couponId;
		try {
			con1.createStatement().executeUpdate(sql);
			System.out.println("company coupons deleted from the join table");
		} catch (SQLException e) {
			throw new CouponSystemException("something went wrong");
		} finally {
			cp.returnConnection(con1);
		}
	}

	public void addCompanyCoupon(long couponId, long companyId) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection con1 = cp.getConnection();
		String sql = "INSERT INTO CompanyCoupon (Company_id,Coupon_id) VALUES (" + companyId + ", " + couponId + ")";
		try {
			con1.prepareStatement(sql).executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemException("something went wrong");
		} finally {
			cp.returnConnection(con1);
		}
	}

	/**
	 * this method can help users to restore id
	 * 
	 * @param compName
	 * @param compPassword
	 * @return
	 * @throws CouponSystemException
	 */
	public long restorCompanyId(String compName, String compPassword) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection con1 = cp.getConnection();
		String sql = "select company_id from company where password='" + compPassword + "'and name='" + compName + "'";
		try {
			Statement stmt = con1.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			long id = 0;
			if (rs.next()) {
				id = rs.getLong(1);
			}
			return id;
		} catch (SQLException e) {
			throw new CouponSystemException("something went wrong");
		} finally {
			cp.returnConnection(con1);
		}

	}

}
