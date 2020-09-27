package com.jaecoding.keep.coding.ddd.after;


import com.jaecoding.keep.coding.ddd.after.domain.Address;
import com.jaecoding.keep.coding.ddd.after.domain.Name;
import com.jaecoding.keep.coding.ddd.after.domain.PhoneNumber;
import com.jaecoding.keep.coding.ddd.after.domain.User;

import javax.validation.constraints.NotNull;

/**
 * RegistrationService
 *
 * @author pengwenjie3
 * @date 2020/9/25
 * @since 1.8
 */
public interface AfterRegistrationService {

    User register(@NotNull Name name,
                  @NotNull PhoneNumber phone,
                  @NotNull Address address);
}
