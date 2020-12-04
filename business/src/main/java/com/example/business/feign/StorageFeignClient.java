package com.example.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "storage-service")
public interface StorageFeignClient {
    @GetMapping(value = "/deduct")
    String decrease(@RequestParam String commodityCode, @RequestParam Integer count);

}
