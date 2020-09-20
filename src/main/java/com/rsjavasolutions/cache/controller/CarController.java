package com.rsjavasolutions.cache.controller;

import com.rsjavasolutions.cache.model.CarRequest;
import com.rsjavasolutions.cache.model.CarResponse;
import com.rsjavasolutions.cache.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("cars")
    public List<CarResponse> getAllCars(){
        return carService.getAllCars();
    }

    @PostMapping("cars")
    public void saveCar(@RequestBody CarRequest carRequest){
        carService.saveCar(carRequest);
    }
}
