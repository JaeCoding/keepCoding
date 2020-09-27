package com.jaecoding.keep.coding.ddd.before;

import com.jaecoding.keep.coding.ddd.before.domain.User;

/**
 * UserRepository
 *
 * @author pengwenjie3
 * @date 2020/9/25
 * @since 1.8
 */
public interface BeforeUserRepository {
    User save(User user);
}
