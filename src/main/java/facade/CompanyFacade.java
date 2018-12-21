package facade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import beans.Company;
import beans.Coupon;
import beans.CouponType;
import dao.db.CompanyDaoDb;
import dao.db.CouponDaoDb;
import dao.db.CustomerDaoDb;
import exceptions.CouponSystemException;

/**
 * here all the methods from the dao.db will be used in order to create an easy
 * access to the system for the companies who use the system . this is the layer
 * for the business logic .
 * 
 */
public class CompanyFacade implements CouponClientFacade {

	private CouponDaoDb couponDb;
	private CompanyDaoDb companyDb;
	private CustomerDaoDb customerDb;
	private long company_id;

	public CompanyFacade() {
		super();
		couponDb = new CouponDaoDb();
		companyDb = new CompanyDaoDb();
		customerDb = new CustomerDaoDb();
	}

	/**
	 * we are checking that the coupon title is unique before we let the company
	 * create the coupon.
	 * 
	 * @param coupon
	 * @throws CouponSystemException
	 */
	public void createCoupon(Coupon coupon) throws CouponSystemException {

		if(coupon==null){
			throw new CouponSystemException("one or more of the details are missing");
		}
		boolean unique = true;
		List<Coupon> allTheCoupons = new ArrayList<>();
		allTheCoupons.addAll(couponDb.getAllCoupon());

		for (Coupon c : allTheCoupons) {
			if (c.getTitle().equals(coupon.getTitle())) {
				unique = false;
				break;
			}
			

		}
		if (unique) {
			couponDb.create(coupon);
			long couponId = coupon.getId();
			companyDb.addCompanyCoupon(couponId, company_id);
			System.out.println("coupon created secssesfully");
			System.out.println("your couponId is " + couponId);
		} else {
			throw new CouponSystemException("there is a coupon with the same title ");
		}

	}

	/**
	 * When a coupon is being removed its removed from the customers purchased
	 * coupons and from the table of the company coupons
	 * 
	 * @param coupon
	 * @throws CouponSystemException
	 */
	public void removeCoupon(Coupon coupon) throws CouponSystemException {
		Coupon coup = coupon;
		try {
			long id = coupon.getId();
			couponDb.remove(coup);
			companyDb.removeCompanyCoupons(id);
			customerDb.removeCustomerCoupons(id);
			System.out.println("coupon removed");

		} catch (CouponSystemException e) {
			throw new CouponSystemException("something went wrong.");
		}
	}

	/**
	 * a company can only update the expiration date and the price of the
	 * coupon.
	 * 
	 * @param coupon
	 * @throws CouponSystemException
	 */
	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		try {
			long id = coupon.getId();
			Coupon coupon2 = couponDb.getCoupon(id);
			coupon2.setEnd_date(coupon.getEnd_date());
			coupon2.setPrice(coupon.getPrice());
			couponDb.update(coupon2);
			System.out.println("the end_date and price updated");
		} catch (CouponSystemException e) {
			throw new CouponSystemException("something went wrong. oen or more of the details you gave are wrong");
		}
	}

	public Coupon getCoupon(long id) throws CouponSystemException {

		Coupon coupon = couponDb.getCoupon(id);
		if (coupon == null) {
			throw new CouponSystemException("wrong id ");
		}
		return coupon;

	}

	public Company getCompany(long id) throws CouponSystemException {
		Company company;
		try {
			company = companyDb.getCompany(id);
		} catch (CouponSystemException e) {
			throw new CouponSystemException("wrong id");
		}
		return company;
	}

	public Collection<Coupon> getAllCoupons() throws CouponSystemException {
		List<Coupon> allCoupons;
			allCoupons = (List<Coupon>) companyDb.getCoupons(company_id);
		if(allCoupons.isEmpty()){
			throw new CouponSystemException("you dont have any coupons");
		}
		return allCoupons;
	}

	public Collection<Coupon> getCouponByType(CouponType type) throws CouponSystemException {
		CouponType wantedType = type;
		Collection<Coupon> allCoupons;
		Collection<Coupon> allCouponsByType = new ArrayList<>();
			allCoupons = (List<Coupon>) couponDb.getAllCoupon();
			for (Coupon c : allCoupons) {
				if (c.getType() == wantedType) {
					allCouponsByType.add(c);
				}
			}
			if(allCouponsByType.isEmpty()){
			throw new CouponSystemException("no coupons from that type");
			}
		return allCouponsByType;
	}

	public Collection<Coupon> getCouponByPrice(double price) throws CouponSystemException {
		List<Coupon> allCoupons;
		List<Coupon> CouponByPrice = new ArrayList<>();
		
			allCoupons = (List<Coupon>) couponDb.getAllCoupon();
			for (Coupon c : allCoupons) {
				if (c.getPrice() <= price) {
					CouponByPrice.add(c);
				}
			}

		if(CouponByPrice.isEmpty()){
			throw new CouponSystemException("no one of the coupons are under that price ");
		}
		return CouponByPrice;
	}

	public Collection<Coupon> getCouponByEndDate(Date date) throws CouponSystemException {
		List<Coupon> allCoupons;
		List<Coupon> CouponByEndDate = new ArrayList<>();
		
			allCoupons = (List<Coupon>) couponDb.getAllCoupon();
			for (Coupon c : allCoupons) {
				if (c.getEnd_date().compareTo(date) <= 0) {
					CouponByEndDate.add(c);
				}
			}
		if(CouponByEndDate.isEmpty()){
			throw new CouponSystemException("no coupons found");
		}
		return CouponByEndDate;
	}

	@Override
	public boolean logIn(String name, String password) throws CouponSystemException {
		boolean logInWorked;
		try {
			if (companyDb.logIn(name, password)) {
				this.company_id = companyDb.restorCompanyId(name, password);

				logInWorked = true;
			} else {
				logInWorked = false;
			}
		} catch (CouponSystemException e) {
			throw new CouponSystemException("logIn failed in facade layer");
		}
		return logInWorked;
	}

}