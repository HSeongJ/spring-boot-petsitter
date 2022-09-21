package com.personal.petsitter.entities.customer;

import com.personal.petsitter.entities.base.BaseRegDateEntity;
import com.personal.petsitter.entities.base.CustomerRole;
import com.personal.petsitter.entities.base.Gender;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Customer")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@DynamicInsert
public class CustomerEntity extends BaseRegDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_idx")
    private Long idx;

    @Column(length = 40, nullable = false)
    private String id;

    @Column(length = 200, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String nickname;

    @Column(length = 10)
    private Gender gender;

    @Column(length = 100)
    private String email;

    @Column(length = 30, nullable = false)
    private String phonenumber;

    @Column(length = 1000, nullable = false)
    private String address;

    @Column(length = 500)
    private String picture;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<CustomerRole> roleSet = new HashSet<>();

    @Column(columnDefinition = "VARCHAR(20) default '활성'")
    private String state;

    public void addCustomerRole(CustomerRole customerRole) {
        roleSet.add(customerRole);
    }
}
