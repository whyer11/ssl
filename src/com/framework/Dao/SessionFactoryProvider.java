package com.framework.Dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * 该类用于创建SessionFactory实例和Session实例
 * @author LH
 */

public class SessionFactoryProvider {
	
	//Hibernate配置文件的路径的变量
    private static String CONFIG_FILE = "/hibernate.cfg.xml";  
    // 创建一个线程本地变量
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	//配置 Hibernate的类 ,根启动Hibernate,创建SessionFactory实例  
    private  static Configuration configuration = new Configuration();
    //声明私有类型的SessionFactory
    private static org.hibernate.SessionFactory sf;
	static {
    	try {
			configuration.configure(CONFIG_FILE);		//加载Hibernate配置文件
			sf = configuration.buildSessionFactory();	//根据配置文件创建SessionFactory实例
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    private SessionFactoryProvider() {
    }
    /**
     * 静态方法，用于获取Session实例
     * @return
     * @throws HibernateException
     */
    
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();	//获取此线程局部变量的当前线程副本中的session
		if (session == null || !session.isOpen()) {		//判断Session实例是否存在
			if (sf == null) {//判断SessionFactory实例是否为空，如果为空重建SessionFactory实例
				rebuildSessionFactory();
			}
			session = (sf != null) ? sf.openSession(): null;//从SessionFactory实例中获取Session实例
			threadLocal.set(session);//将此线程局部变量的当前线程副本中的值设置为session
		}
        return session;
    }
    /**
     * 静态方法，重建SessionFactory实例
     */
    
	public static void rebuildSessionFactory() {
		try {
			configuration.configure(CONFIG_FILE);
			sf = configuration.buildSessionFactory();
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	/**
	 * 静态方法，关闭Session
	 * @throws HibernateException
	 */
	
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }
    }
    /**
     * 获取SessionFactory实例
     * @return
     */
	public static SessionFactory getSessionFactory() {
		return sf;
	}
	/**
	 * 设置Hibernate的配置文件路径名
	 * @param configFile
	 */
	public static void setConfigFile(String configFile) {
		SessionFactoryProvider.CONFIG_FILE = configFile;
		sf = null;
	}
	/**
	 * 获取用于配置Hibernate的配置对象
	 * @return
	 */
	public static Configuration getConfiguration() {
		return configuration;
	}
	

}