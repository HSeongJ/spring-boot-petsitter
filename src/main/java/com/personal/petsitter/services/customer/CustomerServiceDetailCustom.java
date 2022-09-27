package com.personal.petsitter.services.customer;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CustomerServiceDetailCustom {

    UserDetails loadUserByUsername(String id) throws UsernameNotFoundException;

    UserDetails loadUserByIdx(Long idx);
}
