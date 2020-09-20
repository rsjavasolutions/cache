package com.rsjavasolutions.cache.service;

import com.rsjavasolutions.cache.model.CarRequest;
import com.rsjavasolutions.cache.model.CarResponse;
import com.rsjavasolutions.cache.mapper.CarMapper;
import com.rsjavasolutions.cache.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.rsjavasolutions.cache.mapper.CarMapper.mapToEntity;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    @Cacheable(cacheNames = "AllCars")
    public List<CarResponse> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(CarMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    public void saveCar(CarRequest request) {
        carRepository.save(mapToEntity(request));
    }

}
