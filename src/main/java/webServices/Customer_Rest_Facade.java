package webServices;

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
import beans.Coupon;
import beans.CouponType;
import exceptions.CouponSystemException;
import facade.CustomerFacade;

@RestController
public class Customer_Rest_Facade {

	/**
	 * all the rest methods are using the facade from the session storage from
	 * this method.
	 * 
	 * @param request
	 * @return
	 */
	private CustomerFacade getFacade(HttpServletRequest request) {
		return (CustomerFacade) request.getSession().getAttribute("facade");
	}

	/**
	 * this method get coupon and save his details in the join table in the data
	 * base with the coupon id as key .
	 * 
	 * @param coupon
	 * @return
	 * @throws CouponSystemException
	 */
	@RequestMapping(value = "/coupon/customer/purchaseCoupon", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> purchaseCoupon(@RequestBody Coupon coupon, HttpServletRequest request)
			throws CouponSystemException {
		try {
			CustomerFacade customerFacade = this.getFacade(request);
			customerFacade.purchaseCoupon(coupon);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return null;
	}

	/**
	 * this method give the customer the details of all the coupons that he
	 * purchased (from the join table with his id )
	 * 
	 * @return
	 * @throws CouponSystemException
	 */
	@RequestMapping(value = "/coupon/customer/getAllPurchesedCoupons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getAllPurchesedCoupons(HttpServletRequest request)
			throws CouponSystemException {
		try {
			CustomerFacade customerFacade = this.getFacade(request);
			List<Coupon> allPurchesedCoupons = (List<Coupon>) customerFacade.getAllPurchesedCoupons();
			return ResponseEntity.status(HttpStatus.OK).body(allPurchesedCoupons);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	/**
	 * this method give the customer the details of all the coupons that he
	 * purchased (from the join table with his id ) from the type that he want
	 * (from the coupon-type enum in the beans package )
	 * 
	 * @return
	 * @throws CouponSystemException
	 */
	@RequestMapping(value = "/coupon/customer/getAllPurchesedCouponsByType/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getAllPurchesedCouponsByType(@PathVariable("type") CouponType type,
			HttpServletRequest request) throws CouponSystemException {
		try {
			CustomerFacade customerFacade = this.getFacade(request);
			List<Coupon> allPurchesedCouponsByType = (List<Coupon>) customerFacade.getAllPurchesedCouponsByType(type);
			return ResponseEntity.status(HttpStatus.OK).body(allPurchesedCouponsByType);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	/**
	 * the user give price and get all the coupons that he parched in that price
	 * and lower .
	 * 
	 * @param price
	 * @return
	 * @throws CouponSystemException
	 */
	@RequestMapping(value = "/coupon/customer/getAllPurchesedCouponsByPrice/{price}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getAllPurchesedCouponsByPrice(@PathVariable double price,
			HttpServletRequest request) throws CouponSystemException {
		try {
			CustomerFacade customerFacade = this.getFacade(request);
			List<Coupon> allPurchesedCouponsByPrice = (List<Coupon>) customerFacade
					.getAllPurchesedCouponsByPrice(price);
			return ResponseEntity.status(HttpStatus.OK).body(allPurchesedCouponsByPrice);
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	/**
	 * this method give all the customer coupons.
	 * 
	 * @return
	 * @throws CouponSystemException
	 */
	@RequestMapping(value = "/coupon/customer/getAllCoupons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getAllCoupons(HttpServletRequest request) throws CouponSystemException {
		try {
			CustomerFacade customerFacade = this.getFacade(request);
			List<Coupon> allUnPurchesedCoupons = (List<Coupon>) customerFacade.getUnperchesedCoupons();
			return ResponseEntity.status(HttpStatus.OK).body(allUnPurchesedCoupons);
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
	@RequestMapping(value = "/coupon/customer/logOut", method = RequestMethod.DELETE)
	public @ResponseBody void logOut(HttpServletRequest request) {
		request.getSession().removeAttribute("facade");
	}
}
