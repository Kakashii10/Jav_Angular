package com.example.Java_Springboot.Service;

import java.util.List;
import java.util.Optional;

import com.example.Java_Springboot.Models.Car;
import com.example.Java_Springboot.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	public List<Car> getAllAvailableCars() {
		return carRepository.findByAvailableTrue();
	}

	public Car addCar(Car car) {
		car.setAvailable(true);
		return carRepository.save(car);
	}

	public Optional<Car> getCarById(Long id) {
		return carRepository.findById(id);
	}

	public Car updateCar(Long id, Car updatedCar) {
		Car car = carRepository.findById(id).orElseThrow();
		car.setBrand(updatedCar.getBrand());
		car.setModel(updatedCar.getModel());
		car.setType(updatedCar.getType());
		car.setPricePerDay(updatedCar.getPricePerDay());
		return carRepository.save(car);
	}

	public void deleteCar(Long id) {
		carRepository.deleteById(id);
	}
}