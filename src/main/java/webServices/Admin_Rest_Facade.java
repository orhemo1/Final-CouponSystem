package webServices;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import beans.Company;
import beans.Customer;
import exceptions.CouponSystemException;
import facade.AdminFacade;

@RestController
public class Admin_Rest_Facade {

	/**
	 * all the rest methods are using the facade from the session storage from
	 * this method.
	 * 
	 * @param request
	 * @return
	 */
	private AdminFacade getFacade(HttpServletRequest request) {
		return (AdminFacade) request.getSession().getAttribute("facade");
	}

	/**
	 * this rest method get (post method) company bean from the front-end and
	 * send it to the data base.
	 */
	@RequestMapping(value = "/coupon/CreateCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> CreateCompany(@RequestBody Company comapny, HttpServletRequest request)
			throws CouponSystemException {
		try {
			AdminFacade adminFacade = this.getFacade(request);
			adminFacade.createCompany(comapny);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).contentType(MediaType.TEXT_PLAIN)
					.body(e.getMessage());

		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body("Company Created!");

	}

	/**
	 * this rest method get (delete method) company bean from the front-end and
	 * remove it from the data base.
	 */
	@RequestMapping(value = "/coupon/removeCompany", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> removeCompany(@RequestBody Company company, HttpServletRequest request)
			throws CouponSystemException {
		try {
			AdminFacade adminFacade = this.getFacade(request);
			adminFacade.removeCompany(company);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).contentType(MediaType.TEXT_PLAIN)
					.body(e.getMessage());

		}
		return null;

	}

	/**
	 * 
	 * this rest method get(with put method) company bean from the front-end and
	 * update only the email an the password in the data base.
	 */
	@RequestMapping(value = "/coupon/updateCompany", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> updateCompany(@RequestBody Company company, HttpServletRequest request)
			throws CouponSystemException {
		try {
			AdminFacade adminFacade = this.getFacade(request);
			adminFacade.updateCompany(company);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).contentType(MediaType.TEXT_PLAIN)
					.body(e.getMessage());

		}
		return null;
	}

	/**
	 * the admin user give the company id and gets the company details
	 */
	@RequestMapping(value = "/coupon/getCompany/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getCompany(@PathVariable("id") long id, HttpServletRequest request)
			throws CouponSystemException {
		try {
			AdminFacade adminFacade = this.getFacade(request);
			Company company = adminFacade.getCompany(id);
			return ResponseEntity.status(HttpStatus.OK).body(company);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
	}

	/**
	 * this method return all the companies that exist in the system and the
	 * companies details to the admin user.
	 */
	@RequestMapping(value = "/coupon/getAllCompanies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getAllCompanies(HttpServletRequest request) throws CouponSystemException {

		try {
			AdminFacade adminFacade = this.getFacade(request);
			List<Company> allCompanies = (List<Company>) adminFacade.getAllCompanies();
			return ResponseEntity.status(HttpStatus.OK).body(allCompanies);

		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
	}

	/**
	 * 
	 * this method get (using post) customer bean from the admin user and save
	 * it in the data base .
	 */
	@RequestMapping(value = "/coupon/createCustomer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> creatCustomer(@RequestBody Customer customer, HttpServletRequest request)
			throws CouponSystemException {
		try {
			AdminFacade adminFacade = this.getFacade(request);
			adminFacade.creatCustomer(customer);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		return null;
	}

	/**
	 * 
	 * this method get (using post) customer bean from the admin user and remove
	 * it from the data base .
	 */
	@RequestMapping(value = "/coupon/removeCustomer", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> removeCustomer(@RequestBody Customer customer, HttpServletRequest request)
			throws CouponSystemException {
		try {
			AdminFacade adminFacade = this.getFacade(request);
			adminFacade.removeCustomer(customer);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).contentType(MediaType.TEXT_PLAIN)
					.body(e.getMessage());
		}
		return null;
	}

	/**
	 * 
	 * this method get (using post) customer bean from the admin user update
	 * only the customer password in the date base
	 */
	@RequestMapping(value = "/coupon/updateCustomer", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> updateCustomer(@RequestBody Customer customer, HttpServletRequest request)
			throws CouponSystemException {
		try {
			AdminFacade adminFacade = this.getFacade(request);
			adminFacade.updateCustomer(customer);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).contentType(MediaType.TEXT_PLAIN)
					.body(e.getMessage());
		}
		return null;

	}

	/**
	 * the admin user give the customer id and gets the customer details
	 */
	@RequestMapping(value = "/coupon/getCustomer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getCustomer(@PathVariable("id") long id, HttpServletRequest request)
			throws CouponSystemException {
		try {
			AdminFacade adminFacade = this.getFacade(request);
			Customer customer = adminFacade.getCustomer(id);
			return ResponseEntity.status(HttpStatus.OK).body(customer);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
	}

	/**
	 * this method return all the customers that exist in the system and the
	 * customers details to the admin user.
	 */
	@RequestMapping(value = "/coupon/getAllCustomers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getAllCustomers(HttpServletRequest request) throws CouponSystemException {
		try {
			AdminFacade adminFacade = this.getFacade(request);
			Collection<Customer> allCustomers = adminFacade.getAllCustomers();
			return ResponseEntity.status(HttpStatus.OK).body(allCustomers);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
	}

	/**
	 * to make shore that no one is using the facade directly with the url
	 * (without login first) we put the facade on the session in the log in and
	 * remove it in the log out (the filter will stop users without facade on
	 * there session).
	 *
	 */
	@RequestMapping(value = "/admin/logOut", method = RequestMethod.DELETE)
	public @ResponseBody void logOut(HttpServletRequest request) {
		request.getSession().removeAttribute("facade");

	}
}
