package com.example.storage.repository;

import com.example.storage.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage, Long> {

    Storage findByCommodityCode(String commodityCode);

}