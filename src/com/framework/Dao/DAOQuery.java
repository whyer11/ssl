package com.framework.Dao;

import java.util.HashMap;
import java.util.Map;
import com.lyq.util1.StringUtil;
public class DAOQuery {
	
	private String _whereClause=null;
	private String _orderByString=null;
	private int _pageIndex;
	public int get_pageIndex() {
		return _pageIndex;
	}
	public void set_pageIndex(int _pageIndex) {
		this._pageIndex = _pageIndex;
	}
	public int get_pageSize() {
		return _pageSize;
	}
	public void set_pageSize(int _pageSize) {
		this._pageSize = _pageSize;
	}
	public Map<String, Object> get_parameters() {
		return _parameters;
	}
	public void set_parameters(Map<String, Object> _parameters) {
		this._parameters = _parameters;
	}
	private int _pageSize;

	public String get_orderByString() {
		return _orderByString;
	}
	public void set_orderByString(String _orderByString) {
		this._orderByString = _orderByString;
	}
	public String get_whereClause() {
		return _whereClause;
	}
	public void set_whereClause(String _whereClause) {
		this._whereClause = _whereClause;
	}
	public DAOQuery(String p_whereClause){
		_whereClause = p_whereClause;
	}
	public DAOQuery(){
		this(null);
	}
	public String getQueryString(){
		
		StringBuilder statementBuilder=new StringBuilder("");
		String whereClause = get_whereClause();
//		System.out.println("abcwhereClause:"+whereClause);
		if(StringUtil.notNullOrEmpty(whereClause)){
			statementBuilder.append(" where ").append(whereClause);
		}
		
		
		String orderBy = get_orderByString();
//		System.out.println("orderby:"+orderBy);
		if(StringUtil.notNullOrEmpty(orderBy)){
			statementBuilder.append(" order by ").append(orderBy); 
		}
		return statementBuilder.toString();
		
		
	}
	private  Map<String, Object>  _parameters=new HashMap<String, Object>();
	public  Map<String,Object> getParameters(){
		return  _parameters;
	}
	
	public Object getParameters(String p_key){
		if(_parameters!=null){
			return _parameters.get(p_key);
		}
		return null;
	}
	
	public void setParameter(String p_key, Object p_value)
	{
		if (_parameters != null)
		{
			_parameters.put(p_key, p_value);
		}
	}
	
	private boolean _cachable = false;
	public boolean isCachable()
	{
		return _cachable;
	}
	public void setCachable(boolean p_cachable)
	{
		_cachable = p_cachable;
	}
	
	private String _cacheRegion = null;
	public String getCacheRegion()
	{
		return _cacheRegion;
	}
	public void setCacheRegion(String p_region)
	{
		setCachable(true);
		_cacheRegion = p_region;
	}
	
}
