package com.example.storage.service;

import com.example.storage.entity.Storage;
import com.example.storage.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StorageService {
    @Autowired
    private StorageRepository storageRepository;
    @Transactional(rollbackFor = Exception.class)
    public void deduct(String commodityCode, int count) {
        Storage storage = storageRepository.findByCommodityCode(commodityCode);
        storage.setCount(storage.getCount() - count);

        storageRepository.save(storage);
    }
}
