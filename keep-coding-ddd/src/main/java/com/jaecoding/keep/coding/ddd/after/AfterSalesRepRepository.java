package com.jaecoding.keep.coding.ddd.after;

import com.jaecoding.keep.coding.ddd.after.domain.AfterSalesRep;

/**
 * SalesRepRepository
 *
 * @author pengwenjie3
 * @date 2020/9/25
 * @since 1.8
 */
public interface AfterSalesRepRepository {
    AfterSalesRep findRep(String areaCode);
}
