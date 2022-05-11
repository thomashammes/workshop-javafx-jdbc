package model.entities;

import java.util.ArrayList;

public class DepartmentCollection {

	protected static int counter = 1;
	public static final ArrayList<Department> departmentList = new ArrayList<>();
	
	public static void register(Department obj) {
		departmentList.add(obj);
		counter++;
	}

	public static void update(Department obj) {
		int index = obj.getId() - 1;
		departmentList.set(index, obj);
	}
	
}
