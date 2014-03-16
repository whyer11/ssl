package com.framework.Dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * �������ڴ���SessionFactoryʵ����Sessionʵ��
 * @author LH
 */

public class SessionFactoryProvider {
	
	//Hibernate�����ļ���·���ı���
    private static String CONFIG_FILE = "/hibernate.cfg.xml";  
    // ����һ���̱߳��ر���
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	//���� Hibernate���� ,������Hibernate,����SessionFactoryʵ��  
    private  static Configuration configuration = new Configuration();
    //����˽�����͵�SessionFactory
    private static org.hibernate.SessionFactory sf;
	static {
    	try {
			configuration.configure(CONFIG_FILE);		//����Hibernate�����ļ�
			sf = configuration.buildSessionFactory();	//���������ļ�����SessionFactoryʵ��
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    private SessionFactoryProvider() {
    }
    /**
     * ��̬���������ڻ�ȡSessionʵ��
     * @return
     * @throws HibernateException
     */
    
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();	//��ȡ���ֲ߳̾������ĵ�ǰ�̸߳����е�session
		if (session == null || !session.isOpen()) {		//�ж�Sessionʵ���Ƿ����
			if (sf == null) {//�ж�SessionFactoryʵ���Ƿ�Ϊ�գ����Ϊ���ؽ�SessionFactoryʵ��
				rebuildSessionFactory();
			}
			session = (sf != null) ? sf.openSession(): null;//��SessionFactoryʵ���л�ȡSessionʵ��
			threadLocal.set(session);//�����ֲ߳̾������ĵ�ǰ�̸߳����е�ֵ����Ϊsession
		}
        return session;
    }
    /**
     * ��̬�������ؽ�SessionFactoryʵ��
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
	 * ��̬�������ر�Session
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
     * ��ȡSessionFactoryʵ��
     * @return
     */
	public static SessionFactory getSessionFactory() {
		return sf;
	}
	/**
	 * ����Hibernate�������ļ�·����
	 * @param configFile
	 */
	public static void setConfigFile(String configFile) {
		SessionFactoryProvider.CONFIG_FILE = configFile;
		sf = null;
	}
	/**
	 * ��ȡ��������Hibernate�����ö���
	 * @return
	 */
	public static Configuration getConfiguration() {
		return configuration;
	}
	

}