package com.lyq.action;
import java.util.Map;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ��Action��������Action�ĸ���
 * @author Li Yongqiang
 */
public class BaseAction extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware {
	private static final long serialVersionUID = 1L;
	protected Integer id;
	protected Integer[] ids;
	protected int pageNo = 1;
	protected int pageSize = 3;
	
	public static final String LIST = "list";
	public static final String EDIT = "edit";
	public static final String ADD = "add";
	public static final String SELECT = "select";
	public static final String QUERY = "query";
	public static final String LEFT = "left";
	public static final String RIGHT = "right";
	public static final String INDEX = "index";
	public static final String MAIN = "main";
	public static final String MANAGER = "manager";
	public static final String TOP = "top";
	public static final String REG = "reg";
	public static final String USER_LOGIN = "userLogin";
	public static final String CUSTOMER_LOGIN = "customerLogin";
	public static final String LOGOUT = "logout";
	// ��ȡ�û�id
	// ��ȡ�û�����
	/*public Customer getLoginCustomer(){
		if(session.get("customer") != null){
			return (Customer) session.get("customer");
		}
		return null;
	}
	// ��ȡ����Աid
	// ��ȡ����Ա����
	public User getLoginUser(){
		if(session.get("admin") != null){
			return (User) session.get("admin");
		}
		return null;
	}
	// ��session��ȡ�����ﳵ
	@SuppressWarnings("unchecked")
	protected Set<OrderItem> getCart(){
		Object obj = session.get("cart");
		if(obj == null){
			return new HashSet<OrderItem>();
		}else{
			return (Set<OrderItem>) obj;
		}
	}
	*/
	// ע��Dao
	/*@Autowired
	protected AdministratorDao administratorDao;
	@Autowired
	protected AreaDao _AreaDao;
	@Autowired
	protected CategoryDao _categorDao;
	@Autowired
	protected ProductDao _prodProductDao;
	@Autowired
	protected StoreDao _storeDao;
	*/
	// Map���͵�request
	protected Map<String, Object> request;
	// Map���͵�session
	protected Map<String, Object> session;
	// Map���͵�application
	protected Map<String, Object> application;
	
	
	public void setRequest(Map<String, Object> request) {
		// ��ȡMap���͵�request��ֵ
		this.request = request;
	}
	
	public void setApplication(Map<String, Object> application) {
		// ��ȡMap���͵�application��ֵ
		this.application = application;
	}
	
	public void setSession(Map<String, Object> session) {
		// ��ȡMap���͵�session��ֵ
		this.session = session;
	}
	
	// ���?��
	public String index() throws Exception {
		return INDEX;
	}
	public String manager() throws Exception {
		return MANAGER;
	}
	public String main() throws Exception {
		return MAIN;
	}
	public String add() throws Exception {
		return ADD;
	}
	public String select() throws Exception {
		return SELECT;
	}
	public String execute() throws Exception {
		return SUCCESS;
	}
	public String top() throws Exception {
		return TOP;
	}
	public String left() throws Exception {
		return LEFT;
	}
	public String right() throws Exception {
		return RIGHT;
	}
	public String reg() throws Exception{
		return REG;
	}
	public String query() throws Exception{
		return QUERY;
	}
	// getter��settter����
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
