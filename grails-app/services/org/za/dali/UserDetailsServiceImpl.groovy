package org.za.dali

import org.springframework.security.core.authority.GrantedAuthorityImpl
import org.za.dali.enums.Role

class UserDetailsServiceImpl {

    @Override
	public List<GrantedAuthorityImpl> getAllAuthorities() {
		ArrayList<GrantedAuthorityImpl> res = new ArrayList<GrantedAuthorityImpl>();
		for (Role role : Role.values()) {
			res.add(role.name);
		}
		return res;
	}

//	@Override
//	public GrantedAuthority getGrantedAuthorityByID(String name) {
//		return new GrantedAuthorityImpl(roleService.loadRoleByName(name).getName());
//		return Roles.ROLE_ADMIN.getRole();
//	}
}
