package Fruit_Task_Persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepo extends JpaRepository<FruitDomain, Long> {

}
