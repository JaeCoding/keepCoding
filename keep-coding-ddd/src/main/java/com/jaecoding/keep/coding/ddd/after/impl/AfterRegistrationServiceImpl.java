package com.jaecoding.keep.coding.ddd.after.impl;


import com.jaecoding.keep.coding.ddd.after.AfterRegistrationService;
import com.jaecoding.keep.coding.ddd.after.AfterSalesRepRepository;
import com.jaecoding.keep.coding.ddd.after.AfterUserRepository;
import com.jaecoding.keep.coding.ddd.after.domain.*;
import com.jaecoding.keep.coding.ddd.before.domain.SalesRep;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;

/**
 * RegistrationServiceImpl
 *
 * @author pengwenjie3
 * @date 2020/9/25
 * @since 1.8
 */
public class AfterRegistrationServiceImpl implements AfterRegistrationService {

    private AfterSalesRepRepository salesRepRepo;
    private AfterUserRepository userRepo;

    public User register(@NotNull Name name,
                         @NotNull PhoneNumber phone,
                         @NotNull Address address) throws ValidationException {

        AfterSalesRep rep = salesRepRepo.findRep(phone.getAreaCode());

        // 最后创建用户，落盘，然后返回，这部分代码实际上也能用Builder解决
        User user = User.builder()
                .phone(phone)
                .address(address)
                .name(name)
                .repId(rep.getRepId())
                .build();
        return userRepo.save(user);
    }

}
