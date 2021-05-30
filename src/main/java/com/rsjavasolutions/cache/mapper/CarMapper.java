package com.rsjavasolutions.cache.mapper;

import com.rsjavasolutions.cache.model.CarEntity;
import com.rsjavasolutions.cache.model.CarRequest;
import com.rsjavasolutions.cache.model.CarResponse;

public class CarMapper {

    public static CarEntity mapToEntity(CarRequest request) {
        return new CarEntity(
                request.getBrand(),
                request.getModel());
    }

    public static CarResponse mapToResponse(CarEntity carEntity) {
        return new CarResponse(
                carEntity.getUuid(),
                carEntity.getId(),
                carEntity.getBrand(),
                carEntity.getModel());
    }
}
