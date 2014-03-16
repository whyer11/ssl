package com.lyq.action.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import com.framework.Dao.CategoryDao;
import com.framework.Dao.DAOQuery;
import com.framework.Dao.ProductDao;
import com.lyq.action.BaseAction;
import com.lyq.model.all.Category;
import com.lyq.model.all.Product;

public class productCategoryAction extends BaseAction {
	private Integer categoryId;
	private Integer parentId;
	private String name;
	private Integer createTime;
	private Boolean deleted;
	ProductDao _product=new ProductDao();
	List<Product>  products;
	private  CategoryDao _categoryDao=new CategoryDao();
	List<Category> categories;
	List<Category> categories1;
	public List<Category> getCategories1() {
		return categories1;
	}

	public void setCategories1(List<Category> categories1) {
		this.categories1 = categories1;
	}

	Category cat=new Category();
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public Boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	//查询所有的一级分类
	public String  getAllCategory(){
		CategoryDao  _categoryDao=new CategoryDao();
		DAOQuery _DaoQuery=new DAOQuery();
		DAOQuery  daoquery=new DAOQuery();
		_DaoQuery.set_whereClause("parentId=0");
		this.categories=_categoryDao.select(_DaoQuery);
		System.out.println(this.categories.get(0).getCategoryId());
		daoquery.set_whereClause("parentId="+this.categories.get(0).getCategoryId());
		
		this.categories1=_categoryDao.select(daoquery);
		return "category_list";
	}
	
	public String  getAllCategorydisplay(){
		CategoryDao  _categoryDao=new CategoryDao();
		DAOQuery _DaoQuery=new DAOQuery();
		DAOQuery  daoquery=new DAOQuery();
		_DaoQuery.set_whereClause("parentId=0");
		this.categories=_categoryDao.select(_DaoQuery);
		System.out.println(this.categories.get(0).getCategoryId());
		daoquery.set_whereClause("parentId="+this.categories.get(0).getCategoryId());
		this.categories1=_categoryDao.select(daoquery);
		return "getAllCategorydisplay";
	}
	
	
	//查询指定一级分类下的二级分类
	public String  getCatByFirst(){
		CategoryDao  _categoryDao=new CategoryDao();
		DAOQuery _DaoQuery=new DAOQuery();
		_DaoQuery.set_whereClause("parentId="+this.categoryId);
		this.categories=_categoryDao.select(_DaoQuery);
		return SUCCESS;
	}
	//查询三级分类
	
	public String getThirdCat(){
		CategoryDao  _categoryDao=new CategoryDao();
		DAOQuery _DaoQuery=new DAOQuery();
		_DaoQuery.set_whereClause("parentId="+this.categoryId);
		this.categories=_categoryDao.select(_DaoQuery);
		return "category_list1";
	}
	
	
	
	//查询所有的二级分类
		public String getAllCategory1(){ 
		  /*  CategoryDao  _categoryDao=new CategoryDao();
			DAOQuery _DaoQuery=new DAOQuery();
			_DaoQuery.set_whereClause("parentId=0");
			List<Category> categoriesTmp= _categoryDao.select(_DaoQuery);
			Iterator<Category> iter=categoriesTmp.iterator();
			this.getAllSubcategoryies(iter);
			return this.categories;
			//return "category_list";
			*/
			CategoryDao  _categoryDao=new CategoryDao();
			List<Category> categoriesTmp= _categoryDao.selectAll();
			List<Category> categoriesTmp2 = new ArrayList<Category>();
			for(int i=0;i<categoriesTmp.size();i++){
				if(categoriesTmp.get(i).getParentId() == 0){
					categoriesTmp2.add(categoriesTmp.get(i));
				
				}
			
			}
			Iterator<Category> iter=categoriesTmp2.iterator();
			this.getAllSubcategoryies(iter);
			return "category_list1";
			
		}
		public ProductDao get_product() {
			return _product;
		}

		public void set_product(ProductDao _product) {
			this._product = _product;
		}

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}

		public CategoryDao get_categoryDao() {
			return _categoryDao;
		}

		public void set_categoryDao(CategoryDao _categoryDao) {
			this._categoryDao = _categoryDao;
		}

		public List<Category> getCategories() {
			return categories;
		}

		public void setCategories(List<Category> categories) {
			this.categories = categories;
		}

		public Category getCat() {
			return cat;
		}

		public void setCat(Category cat) {
			this.cat = cat;
		}

		private void getAllSubcategoryies(Iterator<Category> iter) {
			List<Category> categoriesTmp;
			this.categories = new ArrayList<Category>();
			while(iter.hasNext()){
				cat= iter.next();
				int i=cat.getCategoryId();
				CategoryDao  _categoryDao=new CategoryDao();
				DAOQuery _DaoQuery=new DAOQuery();
				_DaoQuery.set_whereClause("parentId="+i);
				categoriesTmp=_categoryDao.select(_DaoQuery);
				this.categories.addAll(categoriesTmp);
			}
			
		}
	
	
	
	
}
