package com.rsjavasolutions.cache.repository;

import com.rsjavasolutions.cache.model.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<CarEntity, Long> {

    List<CarEntity> findAll();
}
