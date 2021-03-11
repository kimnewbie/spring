package com.company.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
 
import com.company.dto.UsersVO; 
import com.company.mapper.UsersMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

	@Setter(onMethod_ = { @Autowired })
	private UsersMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		log.warn("Load User By UserName : " + userName);
		UsersVO vo = new UsersVO();
		
		try {
		vo = mapper.read_security(userName);
		} catch(Exception e) {
			e.printStackTrace();
		}
		log.warn("queried by member mapper: " + vo);

		return vo == null ? null : new CustomUser(vo);
	} 

}
