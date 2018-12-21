package dao;


import java.util.Collection;

import beans.Coupon;
import beans.Customer;
import exceptions.CouponSystemException;
/**
 * in the Dao layer you get only the headlines of the methods.
 * the rest is written in the Dao.Db layer.
 *
 */
public interface CustomerDAO {

	void creat(Customer customer) throws CouponSystemException;
	
	void remove (Customer customer)throws CouponSystemException;

	void update(Customer customer)throws CouponSystemException;
	
	Customer getCustomer(long id) throws CouponSystemException;
	
	Collection<Customer> getAllCustomers()throws CouponSystemException;

	boolean logIn(String companyName,String password) throws CouponSystemException;

	Collection<Coupon> getCoupons(long customerId) throws CouponSystemException;
}
