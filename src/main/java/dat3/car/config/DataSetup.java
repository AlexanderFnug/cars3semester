package dat3.car.config;


import dat3.car.entity.Car;
import dat3.car.repository.CarRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class DataSetup implements ApplicationRunner{

    private final CarRepository carRepository;

    public DataSetup(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> brands = Arrays.asList("Toyota", "Honda", "Ford", "Chevrolet", "Nissan");
        List<String> models = Arrays.asList("Corolla", "Civic", "Focus", "Cruze", "Sentra");

        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            String brand = brands.get(random.nextInt(brands.size()));
            String model = models.get(random.nextInt(models.size()));
            int price = 200 + random.nextInt(800); // Generates a random price between 200 and 999
            Integer bestDiscount = Arrays.asList(2, 5, 10, 15, 20, 25, 30, 35, 40, 45).get(random.nextInt(10));

            Car car = new Car(brand, model, price, bestDiscount);
            carRepository.save(car);
        }

        System.out.println("Test cars created successfully!");
    }
}

