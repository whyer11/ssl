package com.lyq.action.area;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import com.framework.Dao.AreaDao;
import com.framework.Dao.DAOQuery;
import com.framework.Dao.StoreDao;
import com.framework.Dao.areaStoreDao;
import com.lyq.model.all.Area;
import com.lyq.model.all.AreaStore;
import com.lyq.model.all.AreaStoreId;
import com.lyq.model.all.Customer;
import com.lyq.model.all.Product;
import com.lyq.model.all.Store;
import com.lyq.model.all.storeFrontPage;
import com.sun.net.httpserver.Authenticator.Success;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class storeAction {
	
	private String storesearch;
	public String getStoresearch() {
		return storesearch;
	}

	public void setStoresearch(String storesearch) {
		this.storesearch = storesearch;
	}

	private String baobeisearch;
	
	public String getBaobeisearch() {
		return baobeisearch;
	}

	public void setBaobeisearch(String baobeisearch) {
		this.baobeisearch = baobeisearch;
	}

	private Integer storedetailId;

    public Integer getStoredetailId() {
		return storedetailId;
	}

	public void setStoredetailId(Integer storedetailId) {
		this.storedetailId = storedetailId;
	}

	private Integer storeId1;
	public Integer getStoreId1() {
		return storeId1;
	}

	public void setStoreId1(Integer storeId1) {
		this.storeId1 = storeId1;
	}

	List<AreaStore>  shangquan;
	public List<AreaStore> getShangquan() {
		return shangquan;
	}

	public void setShangquan(List<AreaStore> shangquan) {
		this.shangquan = shangquan;
	}

	private Integer currentCategory;

	public Integer getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(Integer currentCategory) {
		this.currentCategory = currentCategory;
	}

	private Integer currentPage;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	private Integer currentArea;

	public Integer getCurrentArea() {
		return currentArea;
	}

	public void setCurrentArea(Integer currentArea) {
		this.currentArea = currentArea;
	}

	private Integer categoryId;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	List<Area> listAreas;

	public List<Area> getListAreas() {
		return listAreas;
	}

	public void setListAreas(List<Area> listAreas) {
		this.listAreas = listAreas;
	}

	Set<AreaStore> setstore;

	public Set<AreaStore> getSetstore() {
		return setstore;
	}

	public void setSetstore(Set<AreaStore> setstore) {
		this.setstore = setstore;
	}

	List<AreaStore> listareastore;
	List<AreaStore> listareastore1;

	public List<AreaStore> getListareastore1() {
		return listareastore1;
	}

	public void setListareastore1(List<AreaStore> listareastore1) {
		this.listareastore1 = listareastore1;
	}

	public List<AreaStore> getListareastore() {
		return listareastore;
	}

	public void setListareastore(List<AreaStore> listareastore) {
		this.listareastore = listareastore;
	}

	static private Integer touareaId;

	public Integer getTouareaId() {
		return touareaId;
	}

	public void setTouareaId(Integer touareaId) {
		this.touareaId = touareaId;
	}

	private String[] ImageLinkArray;

	public String[] getImageLinkArray() {
		return ImageLinkArray;
	}

	public void setImageLinkArray(String[] imageLinkArray) {
		ImageLinkArray = imageLinkArray;
	}

	private AreaStoreId id;

	public AreaStoreId getId() {
		return id;
	}

	public void setId(AreaStoreId id) {
		this.id = id;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Integer getReachTime() {
		return reachTime;
	}

	public void setReachTime(Integer reachTime) {
		this.reachTime = reachTime;
	}

	public List<AreaStore> getListstore() {
		return liststore;
	}

	public void setListstore(List<AreaStore> liststore) {
		this.liststore = liststore;
	}

	private List<Product> productlist;
	
	
	public List<Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}

	private List<Store> storelist;
	
	public List<Store> getStorelist() {
		return storelist;
	}

	public void setStorelist(List<Store> storelist) {
		this.storelist = storelist;
	}

	private Store store;
	private Integer reachTime;

	List<AreaStore> liststore;

	List<storeFrontPage> liststorefrontpage;

	public List<storeFrontPage> getListstorefrontpage() {
		return liststorefrontpage;
	}

	public void setListstorefrontpage(List<storeFrontPage> liststorefrontpage) {
		this.liststorefrontpage = liststorefrontpage;
	}

	private storeFrontPage storefrontpage;

	public storeFrontPage getStorefrontpage() {
		return storefrontpage;
	}

	public void setStorefrontpage(storeFrontPage storefrontpage) {
		this.storefrontpage = storefrontpage;
	}

	private AreaDao areadao;
	private Area area;

	public AreaDao getAreadao() {
		return areadao;
	}

	public void setAreadao(AreaDao areadao) {
		this.areadao = areadao;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	private Integer shouyeareaId;

	public Integer getShouyeareaId() {
		return shouyeareaId;
	}

	public void setShouyeareaId(Integer shouyeareaId) {
		this.shouyeareaId = shouyeareaId;
	}

	private Integer storeId;
	private Customer customer;
	private String logo;
	private String name;
	private String tel;
	private String mobile;
	private String address;
	private Boolean state;
	private Integer startTime;
	private Integer endTime;
	private Timestamp crateTime;
	private Float shipPrice;
	private Float shipFee;
	private Float serviceScore;
	private Float speedScore;
	private Float environmentScore;
	private Integer maxpeople;
	private Boolean audit;
	private String email;
	private Set products = new HashSet(0);
	private Set comments = new HashSet(0);
	private Set tuans = new HashSet(0);
	private Set areaStores = new HashSet(0);
	private Set orders = new HashSet(0);
	private Set smses = new HashSet(0);
	private Set adverts = new HashSet(0);

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public Timestamp getCrateTime() {
		return crateTime;
	}

	public void setCrateTime(Timestamp crateTime) {
		this.crateTime = crateTime;
	}

	public Float getShipPrice() {
		return shipPrice;
	}

	public void setShipPrice(Float shipPrice) {
		this.shipPrice = shipPrice;
	}

	public Float getShipFee() {
		return shipFee;
	}

	public void setShipFee(Float shipFee) {
		this.shipFee = shipFee;
	}

	public Float getServiceScore() {
		return serviceScore;
	}

	public void setServiceScore(Float serviceScore) {
		this.serviceScore = serviceScore;
	}

	public Float getSpeedScore() {
		return speedScore;
	}

	public void setSpeedScore(Float speedScore) {
		this.speedScore = speedScore;
	}

	public Float getEnvironmentScore() {
		return environmentScore;
	}

	public void setEnvironmentScore(Float environmentScore) {
		this.environmentScore = environmentScore;
	}

	public Integer getMaxpeople() {
		return maxpeople;
	}

	public void setMaxpeople(Integer maxpeople) {
		this.maxpeople = maxpeople;
	}

	public Boolean getAudit() {
		return audit;
	}

	public void setAudit(Boolean audit) {
		this.audit = audit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getProducts() {
		return products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

	public Set getComments() {
		return comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getTuans() {
		return tuans;
	}

	public void setTuans(Set tuans) {
		this.tuans = tuans;
	}

	public Set getAreaStores() {
		return areaStores;
	}

	public void setAreaStores(Set areaStores) {
		this.areaStores = areaStores;
	}

	public Set getOrders() {
		return orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Set getSmses() {
		return smses;
	}

	public void setSmses(Set smses) {
		this.smses = smses;
	}

	public Set getAdverts() {
		return adverts;
	}

	public void setAdverts(Set adverts) {
		this.adverts = adverts;
	}

	public String getStoreCoverArea(){
		areaStoreDao  areastoredao=new areaStoreDao();
		DAOQuery daoquery=new DAOQuery();
		daoquery.set_whereClause("storeId="+this.storeId1);
		shangquan=areastoredao.select(daoquery);
		return "StoreCoverArea";
	}
	
	public String  storeDetail() {
		StoreDao storedao=new StoreDao();
		store=storedao.selectById(this.storedetailId);
        store.setImageLinkArray(store.getLogo().split(","));
        Iterator<Product> iter=store.getProducts().iterator();
        while(iter.hasNext()){
        Product  product=iter.next();
        product.setImageLinkArray(product.getPictures().split(","));
        }
		return "storeDetail";
	}
	
	public String fastStore() {
		areaStoreDao areaStore = new areaStoreDao();
		AreaDao areadao = new AreaDao();
		DAOQuery daoQuery = new DAOQuery();
		daoQuery.set_whereClause("parentId=" + this.shouyeareaId);
		listAreas = areadao.select(daoQuery);
		String areaIdString = listAreas.get(0).getAreaId().toString();
		for (int i = 1; i < listAreas.size(); i++) {
			areaIdString += ",";
			areaIdString += listAreas.get(i).getAreaId().toString();
		}
		System.out.println(areaIdString);
		String areaIdString1 = "areaId in (" + areaIdString + ")";
		System.out.println(areaIdString1);
		DAOQuery daoQuery2 = new DAOQuery();
		daoQuery2.set_pageIndex(0);
		daoQuery2.set_pageSize(15);
		System.out.println("abcccccccc");
		daoQuery2.set_orderByString(" reachTime  ");
		daoQuery2.set_whereClause(areaIdString1);
		listareastore = areaStore.select(daoQuery2);
		// Iterator<AreaStore> iter = listareastore.iterator();
		System.out.println("abcd:" + listareastore.size());
		setstore = filtershouye(listareastore);

		Iterator<AreaStore> iter1 = setstore.iterator();
		while (iter1.hasNext()) {
			System.out.print(iter1.next().getStore().getName());
		}

		for (AreaStore areaStore2 : setstore) {
			areaStore2.getStore().setImageLinkArray(
					areaStore2.getStore().getLogo().split(","));
		}
		return "shouyeStoreList";
	}

	// 获得一个大地区下的小地区 ，，小地区下所有的店铺选出来之后排除storeId相同的元素；
	public String getStoreByAreaId() {

		areaStoreDao areaStore = new areaStoreDao();
		AreaDao areadao = new AreaDao();

		DAOQuery daoQuery = new DAOQuery();
		daoQuery.set_whereClause("parentId=" + this.touareaId);
		listAreas = areadao.select(daoQuery);
		String areaIdString = listAreas.get(0).getAreaId().toString();
		for (int i = 1; i < listAreas.size(); i++) {
			areaIdString += ",";
			areaIdString += listAreas.get(i).getAreaId().toString();
		}
		System.out.println(areaIdString);
		String areaIdString1 = "areaId in (" + areaIdString + ")";
		System.out.println(areaIdString1);
		DAOQuery daoQuery2 = new DAOQuery();
		daoQuery2.set_pageIndex(0);
		daoQuery2.set_pageSize(3);
		daoQuery2.set_whereClause(areaIdString1);
		listareastore = areaStore.select(daoQuery2);
		// Iterator<AreaStore> iter = listareastore.iterator();
		setstore = filter(listareastore);
		Iterator<AreaStore> iter1 = setstore.iterator();
		while (iter1.hasNext()) {
			System.out.print(iter1.next().getStore().getName());
		}

		for (AreaStore areaStore2 : setstore) {
			areaStore2.getStore().setImageLinkArray(
					areaStore2.getStore().getLogo().split(","));
		}

		return "store_list_leibiao";
	}

	// 列表页根据地区和分类筛选店铺
	public String getStoreByAreaAndCat() {
		areaStoreDao areastoredao = new areaStoreDao();
		DAOQuery daoQuery = new DAOQuery();
		daoQuery.set_orderByString("reachTime");
		if (this.currentCategory != 0 && this.currentArea != 0) {
			daoQuery.set_whereClause("areaId=" + this.currentArea
					+ "and store.categoryId=" + this.currentCategory);
			daoQuery.set_pageIndex(this.currentPage);
			daoQuery.set_pageSize(3);
			listareastore1 = areastoredao.select(daoQuery);
			for (AreaStore areaStore : listareastore1) {
				areaStore.getStore().setImageLinkArray(
						areaStore.getStore().getLogo().split(","));
			}

		} else if (this.currentCategory == 0 && this.currentArea != 0) {

			daoQuery.set_whereClause("areaId=" + this.currentArea);
			daoQuery.set_pageIndex(this.currentPage);
			daoQuery.set_pageSize(3);
			listareastore1 = areastoredao.select(daoQuery);
			for (AreaStore areaStore : listareastore1) {
				areaStore.getStore().setImageLinkArray(
						areaStore.getStore().getLogo().split(","));
			}

		} else if (this.currentCategory != 0 && this.currentArea == 0) {
			this.currentArea = this.touareaId;
			daoQuery.set_whereClause("areaId=" + this.currentArea
					+ "and store.categoryId=" + this.currentCategory);
			daoQuery.set_pageIndex(this.currentPage);
			daoQuery.set_pageSize(3);
			listareastore1 = areastoredao.select(daoQuery);
			for (AreaStore areaStore : listareastore1) {
				areaStore.getStore().setImageLinkArray(
						areaStore.getStore().getLogo().split(","));
			}
		} else {

			AreaDao areadao = new AreaDao();
			DAOQuery daoquery = new DAOQuery();
			daoquery.set_whereClause("parentId=" + this.touareaId);
			listAreas = areadao.select(daoquery);
			String areaIdString = listAreas.get(0).getAreaId().toString();
			for (int i = 1; i < listAreas.size(); i++) {
				areaIdString += ",";
				areaIdString += listAreas.get(i).getAreaId().toString();
			}
			System.out.println(areaIdString);
			String areaIdString1 = "areaId in (" + areaIdString + ")";
			System.out.println(areaIdString1);
			DAOQuery daoQuery2 = new DAOQuery();
			daoQuery2.set_pageIndex(this.currentPage);
			daoQuery2.set_pageSize(3);
			daoQuery2.set_whereClause(areaIdString1);
			listareastore1 = areastoredao.select(daoQuery2);
			for (AreaStore areaStore : listareastore1) {
				areaStore.getStore().setImageLinkArray(
						areaStore.getStore().getLogo().split(","));
			}

		}

		return "success";
	}

	private Set<AreaStore> filter(List<AreaStore> listareastore) {

		List<Integer> list = new ArrayList<Integer>();
		Integer k = 0;
		HashSet<AreaStore> setareaStores = new HashSet<AreaStore>(100);
		Iterator<AreaStore> iter = listareastore.iterator();
		while (iter.hasNext()) {
			AreaStore pAreaStore = iter.next();
			k = pAreaStore.getStore().getStoreId();

			System.out.println();
			if (!list.contains(k)) {
				setareaStores.add(pAreaStore);
				list.add(k);
			}

		}
		return setareaStores;
	}

	public String searchStore(){
		if(storesearch.length() != 0){
			StoreDao storedao=new StoreDao();
			DAOQuery daoquery=new DAOQuery();
			daoquery.set_whereClause(" audit=true and name like '%"
					+ storesearch + "%'");
		
			storelist = storedao.select(daoquery);
			for (Store store : storelist) {
				
				store.setImageLinkArray(store.getLogo().split(","));
			}
		}
		else if(baobeisearch.length() !=0){
			
		}
		else{
			
		}
		return "searchStore";
	}
	
	private Set<AreaStore> filtershouye(List<AreaStore> listareastore) {

		List<Integer> list = new ArrayList<Integer>();
		Integer k = 0;
		HashSet<AreaStore> setareaStores = new HashSet<AreaStore>(100);
		Iterator<AreaStore> iter = listareastore.iterator();
		while (iter.hasNext() && list.size()<=4) {
			AreaStore pAreaStore = iter.next();
			k = pAreaStore.getStore().getStoreId();

			System.out.println();
			if (!list.contains(k) ) {
				setareaStores.add(pAreaStore);
				list.add(k);
			}

		}
		return setareaStores;
	}

}
