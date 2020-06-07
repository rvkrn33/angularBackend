package org.sambasoft.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Menu {

	@Id
	@GeneratedValue
	long menuId;
	
	String menuName;

	boolean insert;
	
	Menu(){}
	
	public Menu(String menuName, boolean insert, boolean update, boolean delete, boolean search) {
		super();
		this.menuName = menuName;
		this.insert = insert;
		this.update = update;
		this.delete = delete;
		this.search = search;
	}

	boolean update;
	boolean delete;
	boolean search;
	
	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public boolean isInsert() {
		return insert;
	}

	public void setInsert(boolean insert) {
		this.insert = insert;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public boolean isSearch() {
		return search;
	}

	public void setSearch(boolean search) {
		this.search = search;
	}
	
		
}
