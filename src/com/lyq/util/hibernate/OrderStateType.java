package com.lyq.util.hibernate;

import com.lyq.model1.OrderState;
/**
 * ¶©µ¥×´Ì¬HibernateÓ³ÉäÀàĞÍ
 * @author Li Yongqiang
 */
public class OrderStateType extends EnumType<OrderState> {
	public OrderStateType() {
		super(OrderState.class);
	}
}
