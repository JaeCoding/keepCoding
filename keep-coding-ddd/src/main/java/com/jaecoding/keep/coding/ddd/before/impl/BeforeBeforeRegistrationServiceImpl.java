package com.jaecoding.keep.coding.ddd.before.impl;

import com.jaecoding.keep.coding.ddd.before.BeforeRegistrationService;
import com.jaecoding.keep.coding.ddd.before.BeforeSalesRepRepository;
import com.jaecoding.keep.coding.ddd.before.BeforeUserRepository;
import com.jaecoding.keep.coding.ddd.before.domain.SalesRep;
import com.jaecoding.keep.coding.ddd.before.domain.User;

import javax.validation.ValidationException;
import java.util.Arrays;

/**
 * RegistrationServiceImpl
 *
 * @author pengwenjie3
 * @date 2020/9/25
 * @since 1.8
 */
public class BeforeBeforeRegistrationServiceImpl implements BeforeRegistrationService {

    private BeforeSalesRepRepository salesRepRepo;
    private BeforeUserRepository userRepo;

    public User register(String name, String phone, String address) throws ValidationException {
        /**
         * 校验逻辑
         *  mytodo 问题一：如果在很多地方都有这样分散的 类似的校验，在发生演变时容易遗漏和错改
         *  解决思路：应该将重复部分抽离到一处，
         *  BeanValidation注解：若只是加在参数上，需要各处添加。需要加在Bean上
         *  ValidationUtils类：若负责一切则未被Single Responsibility,需要准备多个业务Utils。业务与校验异常混杂
         */
        if (name == null || name.length() == 0) {
            throw new ValidationException("name");
        }
        if (phone == null || !isValidPhoneNumber(phone)) {
            throw new ValidationException("phone");
        }
        /**
         * 散落的胶水层代码
         * 此处省略address的校验逻辑
         * mytodo 问题二：同上，散落在各处的获取逻辑 ; set get胶水代码，与业务无关
         * 处理方式：统一抽离
         * 取电话号里的区号，然后通过区号找到区域内的SalesRep
         */
        String areaCode = null;
        String[] areas = new String[]{"0571", "021", "010"};
        for (int i = 0; i < phone.length(); i++) {
            String prefix = phone.substring(0, i);
            if (Arrays.asList(areas).contains(prefix)) {
                areaCode = prefix;
                break;
            }
        }
        SalesRep rep = salesRepRepo.findRep(areaCode);
        // 最后创建用户，落盘，然后返回
        User user = new User();
        user.setPhone(phone);
        user.setAddress(address);
        user.setName(name);
        if (rep != null) {
            user.setRepId(rep.getRepId());
        }
        return userRepo.save(user);
    }

    private boolean isValidPhoneNumber(String phone) {
        String pattern = "^0[1-9]{2,3}-?\\d{8}$";
        return phone.matches(pattern);
    }
}
