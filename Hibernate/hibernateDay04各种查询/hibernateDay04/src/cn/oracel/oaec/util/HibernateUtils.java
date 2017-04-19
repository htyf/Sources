package cn.oracel.oaec.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static final SessionFactory sf;
	
	static{
		Configuration cfg=new Configuration();
		cfg.configure();
		
		sf=cfg.buildSessionFactory();
	}
	
	public static Session getCurrentSession(){
		return sf.getCurrentSession();
	}
}
