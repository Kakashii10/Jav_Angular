package com.example.Java_Springboot.Controller;

import java.util.List;

import com.example.Java_Springboot.Models.Car;
import com.example.Java_Springboot.Models.Contact;
import com.example.Java_Springboot.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {

//    @Autowired
//    private JwtService jwtService;

    @Autowired
    private CarService carService;

//    @PostMapping("/contact")
//    public ResponseEntity<String> handleContact(@RequestBody Contact contact,
//                                                @RequestHeader("Authorization") String authHeader) {
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        String token = authHeader.substring(7);
//        try {
//            String user = jwtService.validateToken(token);
//            System.out.println("User " + user + " submitted: " + contact.getName());
//            return ResponseEntity.ok("Submitted!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
//        }
//    }

    @GetMapping("/available")
    public ResponseEntity<List<Car>> getAvailableCars() {
        return ResponseEntity.ok(carService.getAllAvailableCars());
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.addCar(car));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return carService.getCarById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
        return ResponseEntity.ok(carService.updateCar(id, updatedCar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

 }
