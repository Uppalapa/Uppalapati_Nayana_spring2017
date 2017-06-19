package com.jobfair.util;

import java.util.ArrayList;
import java.util.List;

public enum UserRoles {

	EMPLOYER("EMPLOYER"), JOBSEEKER("JOBSEEKER");

	UserRoles(String role) {

		this.role = role;
	}

	private String role;
	
	public static List<String> list() {
		
		List<String> roles = new ArrayList<String>();
	
		for (UserRoles userRoles : UserRoles.values()) {
			
			roles.add(userRoles.name());
		}
		
		return roles;
	}

}
