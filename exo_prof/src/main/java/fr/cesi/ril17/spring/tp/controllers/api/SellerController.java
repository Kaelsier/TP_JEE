package fr.cesi.ril17.spring.tp.controllers.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cesi.ril17.spring.tp.domain.Product;
import fr.cesi.ril17.spring.tp.domain.Seller;
import fr.cesi.ril17.spring.tp.services.SellerService;

@RestController
@RequestMapping("/sellers")
public class SellerController {

	private SellerService sellerService;

	@Autowired
	public SellerController(SellerService sellerService) {
		super();
		this.sellerService = sellerService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Seller>> getClientAll() {
		return new ResponseEntity<List<Seller>>(sellerService.findAll(), HttpStatus.OK);
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity deleteAll() {
		if (sellerService.deleteAll()) {
			return new ResponseEntity("All Sellers deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity("Failed on delete all", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity deleteById(@PathVariable Long id) {
		if (sellerService.existById(id)) {
			if (sellerService.deleteById(id)) {
				return new ResponseEntity("Seller deleted", HttpStatus.OK);
			} else {
				return new ResponseEntity("Failed on delete", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity("Seller not found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/get/id/{id}")
	public ResponseEntity<Optional<Seller>> getProductById(@PathVariable Long id) {
		return new ResponseEntity<Optional<Seller>>(sellerService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/get/name/{name}")
	public ResponseEntity<List<Seller>> getClientByName(@PathVariable String name) {
		return new ResponseEntity<List<Seller>>(sellerService.findByName(name), HttpStatus.OK);
	}

	@PostMapping("/post/")
	public long createProduct(@RequestBody Seller seller) {
		seller = sellerService.save(seller);

		return seller.getId();
	}

	@PutMapping("/put/{id}")
	public ResponseEntity modifyClient(@PathVariable Long id, @RequestBody Seller seller) {
		if (sellerService.put(id, seller)) {
			return new ResponseEntity("Seller modify", HttpStatus.OK);
		} else {
			return new ResponseEntity("Failed on modify", HttpStatus.NOT_FOUND);
		}
	}
}
