package com.personal.petsitter.services.customer;

import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.repositories.customer.CustomerRepository;
import com.personal.petsitter.security.CustomerPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceDetailCustomImpl implements UserDetailsService, CustomerServiceDetailCustom {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String id) {
        CustomerEntity entity = customerRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with this id :" + id)
        );
        return CustomerPrincipal.create(entity);
    }

    @Override
    public UserDetails loadUserByIdx(Long idx) {
        CustomerEntity entity = customerRepository.findByIdx(idx).orElseThrow(
                () -> new UsernameNotFoundException("User not found with this idx :" + idx)
        );

        return CustomerPrincipal.create(entity);
    }
}
