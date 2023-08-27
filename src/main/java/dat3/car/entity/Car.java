package dat3.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
//---
@Entity
public class Car {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;
    @Column(name="car_brand", length = 50)
    String brand;
    @Column(name="car_model", length = 60)
    String Model;
    @Column(name="rental_price_day")
    double pricePrDay;
    @Column(name="max_discount")
    int bestDiscount;

    public Car( String brand, String model, double pricePrDay, int bestDiscount) {
        this.id = id;
        this.brand = brand;
        Model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }
}
