package Fruit_Task_Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import Fruit_Task_Persistence.FruitDomain;
import Fruit_Task_Persistence.FruitRepo;

@Service
public class FruitService {
	
	public FruitRepo repo;
	
	public FruitService(FruitRepo repo) {
		super();
		this.repo=repo;
	}
	
	public List<FruitDomain> readAll() {
		return this.repo.findAll();
	}
	
	public List<FruitDomain> read() {
		List<FruitDomain> listOfFruit = Arrays.asList(new FruitDomain(1L, "Apple", "Red", 0.99),
				new FruitDomain(2L, "Pear", "Green", 1.29),
				new FruitDomain(3L, "Cherry", "Red", 2.99));	
		return listOfFruit;
	}

	public FruitDomain findById(Long id) {
		return this.repo.findById(id).orElseThrow();
	}
	
	public FruitDomain create(FruitDomain fruit) {
		return this.repo.saveAndFlush(fruit);
	}
	
	public FruitDomain update(Long id, FruitDomain fruit) {
		FruitDomain exists = this.repo.getById(id);
		exists.setType(fruit.getType());
		exists.setColour(fruit.getColour());
		exists.setCost(fruit.getCost());
		FruitDomain updated = this.repo.save(exists);
		return updated;
	}
	
	public Boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
}
