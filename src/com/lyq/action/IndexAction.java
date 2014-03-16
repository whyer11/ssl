package com.lyq.action;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.framework.Dao.CategoryDao;
import com.lyq.model.all.Category;
import com.lyq.model.all.Product;
@Scope("prototype")
@Controller("indexAction")
public class IndexAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		CategoryDao _categoryDao=new CategoryDao();
		_category=_categoryDao.selectById(1);
		return SUCCESS;
	}
	
	
	private Category _category;
	private List<Category> categories;
	private List<Product> product_recommend;
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public List<Product> getProduct_recommend() {
		return product_recommend;
	}
	public void setProduct_recommend(List<Product> product_recommend) {
		this.product_recommend = product_recommend;
	}
	
	
}
