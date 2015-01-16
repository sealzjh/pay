package com.dada.pay.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDao {
	
	@Autowired
	private SessionFactory _sessionFactory;

	protected Session session() {
		return _sessionFactory.getCurrentSession();
	}

}
