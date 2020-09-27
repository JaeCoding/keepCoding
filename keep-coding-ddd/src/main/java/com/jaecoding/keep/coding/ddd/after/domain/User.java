package com.jaecoding.keep.coding.ddd.after.domain;

import lombok.Builder;
import lombok.Data;

/**
 * User
 *
 * @author pengwenjie3
 * @date 2020/9/25
 * @since 1.8
 */
@Data
@Builder
public class User {
    UserId userId;
    Name name;
    PhoneNumber phone;
    Address address;
    RepId repId;
}
