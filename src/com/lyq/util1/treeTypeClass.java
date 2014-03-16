package com.lyq.util1;
import java.util.HashMap;
import java.util.Map;
import com.lyq.model.all.Category;
public class treeTypeClass {
	int currentId;
	int parentId;
	int childId;
	int level;
	Category cat;
	public int getCurrentId() {
		return currentId;
	}
	public void setCurrentId(int currentId) {
		this.currentId = currentId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getChildId() {
		return childId;
	}
	public void setChildId(int childId) {
		this.childId = childId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Category getCat() {
		return cat;
	}
	public void setCat(Category cat) {
		this.cat = cat;
	}
	
}
