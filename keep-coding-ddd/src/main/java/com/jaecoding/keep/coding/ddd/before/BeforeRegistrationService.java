package com.jaecoding.keep.coding.ddd.before;

import com.jaecoding.keep.coding.ddd.before.domain.User;

/**
 * RegistrationService
 *
 * @author pengwenjie3
 * @date 2020/9/25
 * @since 1.8
 */
public interface BeforeRegistrationService {

    User register(String name, String phone, String address);
}
