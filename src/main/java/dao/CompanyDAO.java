
package dao;

import java.util.Collection;

import beans.Company;
import beans.Coupon;
import exceptions.CouponSystemException;
/**
 * in the Dao layer you get only the headlines of the methods.
 * the rest is written in the Dao.Db layer.
 *
 */
public interface CompanyDAO {

	void create(Company company) throws CouponSystemException;

	void remove(Company company) throws CouponSystemException;

	void update(Company company) throws CouponSystemException;

	Company getCompany(long id) throws CouponSystemException;

	Collection<Company> getAllCompanies() throws CouponSystemException;

	Collection<Coupon> getCoupons(long companyId) throws CouponSystemException;

	boolean logIn(String compName, String password) throws CouponSystemException;

}