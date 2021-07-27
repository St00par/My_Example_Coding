package Fruit_Task_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Fruit_Task_Persistence.FruitDomain;
import Fruit_Task_Service.FruitService;

@RestController
public class FruitController {
	
	@Autowired
	public FruitService service;

		@GetMapping("/newFruit")
		public FruitDomain addNewFruit() {
			return new FruitDomain("Apple", "Red", 0.99);
		}
		
		@GetMapping("/read")
		public List<FruitDomain> readAll() {
			return this.service.read();
		}
		
		@GetMapping("/getAll")
		public ResponseEntity<List<FruitDomain>> getAll() {
			return new ResponseEntity<List<FruitDomain>>(this.service.readAll(), HttpStatus.OK);
		}
		
		@GetMapping("/findById")
		public ResponseEntity<FruitDomain> findById(@PathVariable("id") Long id) {
			return new ResponseEntity<FruitDomain>(this.service.findById(id), HttpStatus.FOUND);
		}
		
		@PostMapping("/create")
		public ResponseEntity<FruitDomain> create(@RequestBody FruitDomain fruit) {
			return new ResponseEntity<FruitDomain>(this.service.create(fruit), HttpStatus.CREATED);
		}
		
		@PutMapping("/update/{id}")
		public ResponseEntity<FruitDomain> update(@PathVariable("id") Long id, @RequestBody FruitDomain fruit) {
			return new ResponseEntity<FruitDomain>(this.service.update(id, fruit), HttpStatus.ACCEPTED);
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Boolean> update(@PathVariable Long id) {
			return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
		}
		
		

}
