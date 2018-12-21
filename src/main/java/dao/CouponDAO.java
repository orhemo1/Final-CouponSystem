package dao;


import java.util.Collection;

import beans.Coupon;
import beans.CouponType;
import exceptions.CouponSystemException;
/**
 * in the Dao layer you get only the headlines of the methods.
 * the rest is written in the Dao.Db layer.
 *
 */
public interface CouponDAO {

	void create(Coupon coupon) throws CouponSystemException;

	void remove (Coupon coupon)throws CouponSystemException;

	void update(Coupon coupon)throws CouponSystemException;

Coupon getCoupon(long id)throws CouponSystemException;

Collection<Coupon> getAllCoupon()throws CouponSystemException;

Collection<Coupon> getCouponByType(CouponType couponType) throws CouponSystemException;
}
