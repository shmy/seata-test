package com.example.business.service;

import com.example.business.feign.OrderFeignClient;
import com.example.business.feign.StorageFeignClient;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusinessService {
    @Autowired
    private OrderFeignClient orderFeignClient;

    @Autowired
    private StorageFeignClient storageFeignClient;

    /**
     * 减库存，下订单
     *
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    @GlobalTransactional(timeoutMills = 300000, name = "my_test_tx_group")
    public void purchase(String userId, String commodityCode, int orderCount) {
        storageFeignClient.decrease(commodityCode, orderCount);
        orderFeignClient.create(userId, commodityCode, orderCount);
    }
}
