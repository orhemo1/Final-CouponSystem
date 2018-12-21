package facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import beans.Company;
import beans.Coupon;
import beans.Customer;
import dao.db.CompanyDaoDb;
import dao.db.CouponDaoDb;
import dao.db.CustomerDaoDb;
import exceptions.CouponSystemException;
/**
 * 
 * this if the admin facade.
 * with this facade the admin can create users (companies,customers)
 * 
 *
 */
public class AdminFacade implements CouponClientFacade {
	private CompanyDaoDb companyDb;
	private CustomerDaoDb customerDb;
	private CouponDaoDb couponDb;

	public AdminFacade() {
		super();
		companyDb = new CompanyDaoDb();
		customerDb = new CustomerDaoDb();
		couponDb = new CouponDaoDb();
	}
/**
 * only the admin can create a company user . only if the name chosen for the company
 * is unique
 * @param company
 * @throws CouponSystemException 
 */
	public void createCompany(Company company) throws CouponSystemException {
		
			// checking there is not another company with the same name ;
			ArrayList<Company> allCompany = (ArrayList<Company>) companyDb.getAllCompanies();
			boolean unique = true;
			for (Company c : allCompany) {
				if (c.getName().contains(company.getName())) {
					unique = false;
				}
			}
			if (unique) {
				companyDb.create(company);
				System.out.println("create company secssed");
			} else {
				throw new CouponSystemException("this  company allready exist");
			}
	}
/**
 * When this method is used the company and all her coupons 
 * and all the coupons that clients bought from her will be erased . 
 * 
 * @param company
 * @throws CouponSystemException
 */
	public void removeCompany(Company company) throws CouponSystemException {
		try {
			ArrayList<Coupon> allCoup = (ArrayList<Coupon>) companyDb.getCoupons(company.getId());

			for (Coupon coup : allCoup) {
				long id = coup.getId();
				couponDb.remove(coup);
				companyDb.removeCompanyCoupons(id);
				customerDb.removeCustomerCoupons(id);
			}
			companyDb.remove(company);

		} catch (CouponSystemException e) {
			throw new CouponSystemException("something went wrong");
		}
	}
/**
 *  can update only the email and the password .
 * @param company
 * @throws CouponSystemException
 */
	public void updateCompany(Company company) throws CouponSystemException {
		Company comp;
		try {
			comp = companyDb.getCompany(company.getId());
			comp.setEmail(company.getEmail());
			comp.setPassword(company.getPassword());
			companyDb.update(comp);
			System.out.println("company has been updated");
		} catch (CouponSystemException e) {
			throw new CouponSystemException("updateCompany failed . chack the details you gave");
		}

	}

	public Company getCompany(long id) throws CouponSystemException {
	
			Company comp = companyDb.getCompany(id);
		if(comp==null){
			throw new CouponSystemException("no company have "+id+" "+" as id");

		}
		return comp;
	}
/**
 * user can get all the existing companies from this method.
 * @return
 * @throws CouponSystemException
 */
	public Collection<Company> getAllCompanies() throws CouponSystemException {
		try {
			List <Company> allCompanies =  (List<Company>) companyDb.getAllCompanies();
			return allCompanies;
		} catch (CouponSystemException e) {
			throw new CouponSystemException("something went wrong.");

		}
	}
/**
 * only admin can create a customer (if the customer name is unique) .
 * @param customer
 * @throws CouponSystemException
 */
	public void creatCustomer(Customer customer) throws CouponSystemException {
		String name = customer.getName();
		
			Collection<Customer> allCustomer =  customerDb.getAllCustomers();
			boolean unique = true;
			for (Customer cust : allCustomer) {
				if (cust.getName().equals(name)) {
					unique = false;
				}
			}
			if (unique) {
				customerDb.creat(customer);
			} else {
				throw new CouponSystemException("this company allready exist,change the company-name");
			}
		
	}
/**
 * in this method the system removing a customer and all his coupons .
 * @param customer
 * @throws CouponSystemException
 */
	public void removeCustomer(Customer customer) throws CouponSystemException {

		try {
			List<Coupon> customerCoupon = (ArrayList<Coupon>) customerDb.getCoupons(customer.getId());

			if (!(customerCoupon == null)) {
				for (Coupon coupon : customerCoupon) {
					couponDb.remove(coupon);
					customerDb.removeCustomerCoupons(coupon.getId());
				}
			}
			customerDb.remove(customer);

		} catch (CouponSystemException e) {
			throw new CouponSystemException("something went wrong. ");

		}
	}
/**
 * this method can only update the customer password .
 * @param customer
 * @throws CouponSystemException
 */
	public void updateCustomer(Customer customer) throws CouponSystemException {
		Customer cust = customerDb.getCustomer(customer.getId());
		cust.setPassword(customer.getPassword());
		try {
			customerDb.update(cust);
			System.out.println("customer updated");
		} catch (CouponSystemException e) {
			throw new CouponSystemException("updateCustomer failed .chack the details you gave");
		}
	}
/**
 * this method return customer after getting the customer id.
 * @param id
 * @return
 * @throws CouponSystemException
 */
	public Customer getCustomer(long id) throws CouponSystemException {
		Customer customer;
		
			customer = customerDb.getCustomer(id);
		if(customer==null){
			throw new CouponSystemException("no customer have "+id+" as id");
		}
		return customer;

	}
/**
 * this method give the user all the customers in the system .
 * @return
 * @throws CouponSystemException
 */
	public Collection<Customer> getAllCustomers() throws CouponSystemException {
		try {
			Collection <Customer> allCustomers =  customerDb.getAllCustomers();
			return allCustomers;
		} catch (CouponSystemException e) {
			throw new CouponSystemException("something went wrong.");

		}

	}

	@Override
	public boolean logIn(String name, String password) throws CouponSystemException {
		if (name.contains("admin") && password.contains("1234")) {
			return true;
		}
		return false;
	}
}
