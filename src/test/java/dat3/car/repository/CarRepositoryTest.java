package dat3.car.repository;

import dat3.car.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    boolean isInitialized = false;


    @BeforeEach
    void setUp() {
        if (!isInitialized) {
            carRepository.deleteAll();
            carRepository.save(new Car("Toyota", "Corolla", 500, 10));
            carRepository.save(new Car("Honda", "Civic", 600, 20));
            carRepository.save(new Car("Ford", "Focus", 450, 15));
            carRepository.save(new Car("Chevrolet", "Cruze", 550, 25));
            carRepository.save(new Car("Nissan", "Sentra", 400, 5));
            isInitialized = true;
    }
    }

    @Test
    public void deleteAll(){
        carRepository.deleteAll();
        assertEquals(0, carRepository.count());
    }
    @Test
    public void testSize(){
        Long count = carRepository.count();
        assertEquals(5, carRepository.count());
    }
    @Test
    public void findCarsByBrand(){
        List<Car> carsOfBrand = carRepository.findCarsByBrand("Honda");
        Car testBil = new Car("Honda", "Civic", 600, 20);
        assertEquals(testBil.getBrand(), carsOfBrand.get(0).getBrand());

    }


}