package com.lyq.util.hibernate;

import com.lyq.model1.PaymentWay;
/**
 * ֧����ʽHibernateӳ������
 * @author Li Yongqiang
 */
public class PaymentWayType extends EnumType<PaymentWay> {
	public PaymentWayType() {
		super(PaymentWay.class);
	}
}
