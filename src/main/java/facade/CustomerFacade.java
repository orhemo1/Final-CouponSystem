package facade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import beans.Coupon;
import beans.CouponType;
import dao.db.CouponDaoDb;
import dao.db.CustomerDaoDb;
import exceptions.CouponSystemException;

/**
 * the customer facade is more complicated methods that use the methods from the
 * dao.db layer in a way that separate the access to the database from the
 * client .
 *
 */
public class CustomerFacade implements CouponClientFacade {

	private CouponDaoDb couponDb;
	private CustomerDaoDb customerDb;
	private long customer_id;

	public CustomerFacade() {
		super();
		couponDb = new CouponDaoDb();
		customerDb = new CustomerDaoDb();
	}

	/**
	 * a customer can purchase coupon after the checking that the customer
	 * didn't bought this coupon all-ready and if there coupons left and that
	 * the date isn't expired;
	 * 
	 * the method will decrease the amount of coupon from the company balance
	 * after the customer purchase one
	 * 
	 * @param coupon
	 * @throws CouponSystemException
	 */
	public void purchaseCoupon(Coupon coupon) throws CouponSystemException {

		long couponId = couponDb.getCouponId(coupon.getTitle());
		Coupon companyCoupon = couponDb.getCoupon(couponId);
		System.out.println(companyCoupon);
		Date today = new Date(System.currentTimeMillis());

		if ((!(customerDb.isCouponExistByTitle(coupon.getTitle()))) && (companyCoupon.getAmount() > 0)
				&& ((companyCoupon.getEnd_date()).after(today))) {
			// if everything is OK we can buy this.
			customerDb.addCustomerCoupon(coupon.getId(), customer_id);
			companyCoupon.setAmount((companyCoupon.getAmount()) - 1);
			couponDb.update(companyCoupon);
		} else {
			throw new CouponSystemException("you already bought this coupon");
		}

	}

	/**
	 * this method allow the customer to get all the coupons that he bought.
	 * 
	 * @param customerId
	 * @return
	 * @throws CouponSystemException
	 */
	public Collection<Coupon> getAllPurchesedCoupons() throws CouponSystemException {
		Collection<Coupon> allCoupons;

		allCoupons = (ArrayList<Coupon>) customerDb.getCoupons(customer_id);
		if (allCoupons==null) {
			throw new CouponSystemException("you dont have any coupons");
		}
		return allCoupons;

	}

	public Collection<Coupon> getAllPurchesedCouponsByType(CouponType type) throws CouponSystemException {
		Collection<Coupon> allCouponsByType = new ArrayList<>();

		Collection<Coupon> allCoupons = (ArrayList<Coupon>) customerDb.getCoupons(customer_id);
		
		for (Coupon c : allCoupons) {
			if (c.getType().equals(type)) {
				allCouponsByType.add(c);
			}
		}
		if (allCouponsByType.size()==0) {
			throw new CouponSystemException("you dont have coupons from that type");
		}
		return allCouponsByType;

	}

	/**
	 * user can get all the coupon that he or she bought with lower or equal to
	 * the price he gave .
	 * 
	 * @param price
	 * @return
	 * @throws CouponSystemException
	 */
	public Collection<Coupon> getAllPurchesedCouponsByPrice(double price) throws CouponSystemException {
		ArrayList<Coupon> allCouponsByPrice = new ArrayList<>();

		ArrayList<Coupon> allCoupons = (ArrayList<Coupon>) customerDb.getCoupons(customer_id);
		for (Coupon c : allCoupons) {
			if (c.getPrice() <= price) {
				allCouponsByPrice.add(c);
			}
		}

		if (allCouponsByPrice.isEmpty()) {
			throw new CouponSystemException("you don't have any coupons on or under that price");
		}

		return allCouponsByPrice;

	}

	/**
	 * in this log in method we save the customer (that logged in )id so he or
	 * she can use all the other methods of the facade without retype the id
	 * every time .
	 */
	@Override
	public boolean logIn(String name, String password) throws CouponSystemException {
		try {
			if (customerDb.logIn(name, password)) {
				customer_id = customerDb.restoreId(name);
				return true;
			}
			return false;
		} catch (CouponSystemException e) {
			throw new CouponSystemException("logIn failed . wrong user-name or password ");
		}
	}

	/**
	 * 
	 * 
	 * this is a method for customers to see the coupons so they can perches
	 * theme
	 */
	public Collection<Coupon> getUnperchesedCoupons() throws CouponSystemException {
		Collection<Coupon> allCoupons = new ArrayList<Coupon>();
		try {
			allCoupons = customerDb.getAllCoupons();
			Iterator<Coupon> it = allCoupons.iterator();
			while (it.hasNext()) {
				Coupon c = it.next();
				if (customerDb.isCouponExistByTitle(c.getTitle())) {
					it.remove();
				}
			}
		} catch (CouponSystemException e) {
			throw new CouponSystemException("something went wrong");
		}
		return allCoupons;
	}
}
