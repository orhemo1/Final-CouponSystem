package webServices;

import java.sql.Date;
import java.util.Collection;
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
import beans.Coupon;
import beans.CouponType;
import exceptions.CouponSystemException;
import facade.CompanyFacade;

@RestController
public class Company_Rest_Facade {

	/**
	 * all the rest methods are using the facade from the session storage from
	 * this method.
	 * 
	 * @param request
	 * @return
	 */
	private CompanyFacade getFacade(HttpServletRequest request) {
		return (CompanyFacade) request.getSession().getAttribute("facade");

	}

	/**
	 * this method get coupon bean from the user and save it in the database .
	 * 
	 * @param coupon
	 * @return
	 * @throws CouponSystemException
	 */
	@RequestMapping(value = "/coupon/company/createCoupon", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> createCoupon(@RequestBody Coupon coupon, HttpServletRequest request)
			throws CouponSystemException {
		try {
			CompanyFacade companyFacade = this.getFacade(request);
			companyFacade.createCoupon(coupon);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		return null;
	}

	/**
	 * this method get coupon bean from the user and remove it from the database
	 * .
	 * 
	 * @param coupon
	 * @return
	 * @throws CouponSystemException
	 */
	@RequestMapping(value = "/coupon/company/removeCoupon", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> removeCoupon(@RequestBody Coupon coupon, HttpServletRequest request)
			throws CouponSystemException {
		try {
			CompanyFacade companyFacade = this.getFacade(request);
			companyFacade.removeCoupon(coupon);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).contentType(MediaType.TEXT_PLAIN)
					.body(e.getMessage());
		}
		return null;
	}

	/**
	 * this method get coupon bean from the user and update only the end date
	 * and the price .
	 * 
	 * @param coupon
	 * @return
	 * @throws CouponSystemException
	 */
	@RequestMapping(value = "/coupon/company/updateCoupon", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> updateCoupon(@RequestBody Coupon coupon, HttpServletRequest request)
			throws CouponSystemException {
		try {
			CompanyFacade companyFacade = this.getFacade(request);
			companyFacade.updateCoupon(coupon);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).contentType(MediaType.TEXT_PLAIN)
					.body(e.getMessage());
		}
		return null;
	}

	/**
	 * this method give the coupon details to the company.
	 * 
	 * @param id
	 * @return
	 * @throws CouponSystemException
	 */
	@RequestMapping(value = "/coupon/company/getCoupon/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getCoupon(@PathVariable("id") long id, HttpServletRequest request)
			throws CouponSystemException {
		try {
			CompanyFacade companyFacade = this.getFacade(request);
			Coupon coupon = companyFacade.getCoupon(id);
			return ResponseEntity.status(HttpStatus.OK).body(coupon);

		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/**
	 * this method give the details of all the company coupons to the company
	 * user .
	 * 
	 * @return
	 * @throws CouponSystemException
	 */
	@RequestMapping(value = "/coupon/company/getAllCoupons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getAllCoupons(HttpServletRequest request) throws CouponSystemException {
		try {
			CompanyFacade companyFacade = this.getFacade(request);
			Collection<Coupon> allCoupons = companyFacade.getAllCoupons();
			return ResponseEntity.status(HttpStatus.OK).body(allCoupons);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/**
	 * this method give the details of company coupons of specific type to the
	 * company user .
	 * 
	 * @param type
	 * @return
	 * @throws CouponSystemException
	 */
	@RequestMapping(value = "/coupon/company/getCouponByType/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getCouponByType(@PathVariable("type") CouponType type,
			HttpServletRequest request) throws CouponSystemException {
		try {
			CompanyFacade companyFacade = this.getFacade(request);
			Collection<Coupon> allCouponsByType = companyFacade.getCouponByType(type);
			return ResponseEntity.status(HttpStatus.OK).body(allCouponsByType);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}

	}

	/**
	 * this method give the details of the company coupons from the price the
	 * user choose and lower .
	 * 
	 * @param price
	 * @return
	 * @throws CouponSystemException
	 */
	@RequestMapping(value = "/coupon/company/getCouponByPrice/{price}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getCouponByPrice(@PathVariable("price") double price,
			HttpServletRequest request) throws CouponSystemException {
		try {
			CompanyFacade companyFacade = this.getFacade(request);
			Collection<Coupon> allCouponsByPrice = companyFacade.getCouponByPrice(price);
			return ResponseEntity.status(HttpStatus.OK).body(allCouponsByPrice);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}

	}

	/**
	 * this method give the details of the company coupons from specific
	 * end-date and before .
	 * 
	 * @param date
	 * @return
	 * @throws CouponSystemException
	 */
	@RequestMapping(value = "/coupon/company/getCouponByEndDate/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getCouponByEndDate(@PathVariable("date") Date date,
			HttpServletRequest request) throws CouponSystemException {

		try {
			CompanyFacade companyFacade = this.getFacade(request);
			Collection<Coupon> allCouponsByEndDate = companyFacade.getCouponByEndDate(date);
			return ResponseEntity.status(HttpStatus.OK).body(allCouponsByEndDate);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/**
	 * to make shore that no one is using the facade directly with the url
	 * (without login first) we put the facade on the session in the log in and
	 * remove it in the log out (the filter will stop users without facade on
	 * there session).
	 *
	 */
	@RequestMapping(value = "/coupon/company/logOut", method = RequestMethod.DELETE)
	public @ResponseBody void logOut(HttpServletRequest request) {
		request.getSession().removeAttribute("facade");
	}

}
