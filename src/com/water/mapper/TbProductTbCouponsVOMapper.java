package com.water.mapper;

import java.util.List;

import com.water.pojo.TbProductTbCouponsVO;

public interface TbProductTbCouponsVOMapper {

	/**
	 * 得到所有的商品或者得到对应的优惠券
	 * @param tbProductTbCouponsVO
	 * @return
	 */
	List<TbProductTbCouponsVO> getProductAndCoupons(TbProductTbCouponsVO tbProductTbCouponsVO);

	/**
	 * 更新商品与优惠券
	 * @param listPCVOs
	 * @return
	 */
	int addProductAndCoupons(List<TbProductTbCouponsVO> list);

	/**
	 * 逻辑删除优惠券与商品关系
	 * @param tbProductTbCouponsVO
	 */
	int deleteProductAndCoupons(TbProductTbCouponsVO tbProductTbCouponsVO);
	
	/**
	 * 优惠价格及商品
	 * @param vo
	 * @return
	 */
	List<TbProductTbCouponsVO> getAllProductAndCoupons(TbProductTbCouponsVO vo);


}
