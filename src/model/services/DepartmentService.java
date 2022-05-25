package model.services;

import java.util.ArrayList;

import model.entities.Department;
import model.entities.DepartmentCollection;

public class DepartmentService {

	public ArrayList<Department> findAll() {
		return DepartmentCollection.departmentList;
	}
	
	public void registerOrUpdate(Department obj) {
		
		if (obj.getId() == null) {
			registerDepartment(obj);
		} else {
			updateDepartment(obj);
		}
		
		/*
		for (Department d : DepartmentCollection.departmentList) {
			System.out.println(d);
		}
		if (obj.getId() == null) {
			insertDepartment(obj);
		} else {
			updateDepartment(obj);
		}*/
	}

	private void updateDepartment(Department obj) {
		DepartmentCollection.update(obj);
	}

	private void registerDepartment(Department obj) {
		DepartmentCollection.register(new Department(obj));
	}
	
	public void deleteDepartment(Department obj) {
		DepartmentCollection.delete(obj);
	}
}
