package com.wha.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wha.model.Admin;

public class AdminDaoBouchon {
	private static List<Admin> admins;
	{		
		admins = new ArrayList<Admin>();
		admins.add(new Admin(111L, "Admin", "Admin", "[email protected]", "121-232-3435", "Ici", new Date(), "0541", "Admin", new Date()));
		admins.add(new Admin(222L, "Admin2", "Admin2", "[email protected]", "122-232-3435", "Ici", new Date(), "0542", "Admin", new Date()));
		admins.add(new Admin(333L, "Admin3", "Admin3", "[email protected]", "123-232-3435", "Ici", new Date(), "0543", "Admin", new Date()));
	}
	
	public List<Admin> list() {
		return admins;
	}

	public Admin get(Long id) {
		for (Admin a : admins) {
			if (a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}

	public Admin create(Admin admin) {
		admin.setId(System.currentTimeMillis());
		admins.add(admin);
		return admin;
	}

	public Long delete(Long id) {
		for (Admin a : admins) {
			if (a.getId().equals(id)) {
				admins.remove(a);
				return id;
			}
		}
		return null;
	}

	public Admin update(Long id, Admin admin) {
		for (Admin a : admins) {
			if (a.getId().equals(id)) {
				admin.setId(a.getId());
				admins.remove(a);
				admins.add(admin);
				return admin;
			}
		}
		return null;
	}
}
