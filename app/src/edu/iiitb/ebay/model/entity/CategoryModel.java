package edu.iiitb.ebay.model.entity;

import java.util.ArrayList;

/***
 * Used to store info about Category
 * 
 * @author Debargha Ganguly
 * 
 */
public class CategoryModel {

	private String categoryID;
	private boolean selected;
	private String categoryName;
	private String parentCategoryId;
	private ArrayList<CategoryModel> categories = new ArrayList<CategoryModel>();
	
	public ArrayList<CategoryModel> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<CategoryModel> categories) {
		this.categories = categories;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

}
