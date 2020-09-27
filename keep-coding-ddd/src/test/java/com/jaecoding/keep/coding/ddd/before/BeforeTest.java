package com.jaecoding.keep.coding.ddd.before;

import com.jaecoding.keep.coding.ddd.after.AfterRegistrationService;
import com.jaecoding.keep.coding.ddd.after.impl.AfterRegistrationServiceImpl;
import com.jaecoding.keep.coding.ddd.after.domain.Address;
import com.jaecoding.keep.coding.ddd.after.domain.Name;
import com.jaecoding.keep.coding.ddd.after.domain.PhoneNumber;
import com.jaecoding.keep.coding.ddd.before.impl.BeforeBeforeRegistrationServiceImpl;

/**
 * BeforeTest
 *
 * @author pengwenjie3
 * @date 2020/9/25
 * @since 1.8
 */
public class BeforeTest {


    public static void main(String[] args) {
        BeforeRegistrationService beforeRegistrationService = new BeforeBeforeRegistrationServiceImpl();
        // 因为入参是3个String，在编译后完全无法感知分别填入什么
        beforeRegistrationService.register("彭文杰", "0571-12345678", "address");
        // 这样也会通过编译，但是在运行时报错
        beforeRegistrationService.register("0571-12345678", "彭文杰", "address");
        // 其实个人认为此问题并非痛点，可通过下载jar包观察


        // 在编译器便知道如何填选
        AfterRegistrationService afterRegistrationService = new AfterRegistrationServiceImpl();
        afterRegistrationService.register(new Name("彭文杰"), new PhoneNumber("电话"), new Address("地址"));
    }
}
