package com.rsjavasolutions.cache.service;

import com.rsjavasolutions.cache.exception.CarNotFoundException;
import com.rsjavasolutions.cache.mapper.CarMapper;
import com.rsjavasolutions.cache.model.CarEntity;
import com.rsjavasolutions.cache.model.CarRequest;
import com.rsjavasolutions.cache.model.CarResponse;
import com.rsjavasolutions.cache.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.rsjavasolutions.cache.mapper.CarMapper.mapToEntity;
import static com.rsjavasolutions.cache.mapper.CarMapper.mapToResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    @Transactional
    @Cacheable(cacheNames = "AllCars")
    public List<CarResponse> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(CarMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public CarResponse getCarByUuid(String uuid) {
        CarEntity carEntity = carRepository.findByUuid(uuid).orElseThrow(() -> new CarNotFoundException(uuid));
        return mapToResponse(carEntity);
    }

    @Transactional
    @CacheEvict(cacheNames = "AllCars", allEntries = true)
    public String saveCar(CarRequest request) {
        log.debug("Save car request with params: {}", request);

        return carRepository.save(mapToEntity(request)).getUuid();
    }

    @Transactional
    @CacheEvict(cacheNames = "AllCars", allEntries = true)
    public void deleteCarByUuid(String uuid) {
        carRepository.deleteByUuid(uuid);
    }
}
