package com.rsjavasolutions.cache.controller;

import com.rsjavasolutions.cache.model.CarRequest;
import com.rsjavasolutions.cache.model.CarResponse;
import com.rsjavasolutions.cache.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("cars/{uuid}")
    public CarResponse getCarByUuid(@PathVariable String uuid) {
        return carService.getCarByUuid(uuid);
    }

    @GetMapping("cars")
    public List<CarResponse> getCars() {
        return carService.getAllCars();
    }

    @PostMapping("cars")
    public String saveCar(@RequestBody CarRequest request) {
        return carService.saveCar(request);
    }

    @DeleteMapping("cars/{uuid}")
    public void deleteCarByUuid(@PathVariable String uuid) {
        carService.deleteCarByUuid(uuid);
    }

    @PutMapping("cars/{uuid}")
    public CarResponse updateCar(@PathVariable String uuid, @RequestBody CarRequest request) {
       return carService.updateCar(uuid, request);
    }
}
