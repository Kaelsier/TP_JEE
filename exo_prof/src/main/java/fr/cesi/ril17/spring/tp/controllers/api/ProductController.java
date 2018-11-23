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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cesi.ril17.spring.tp.domain.Product;
import fr.cesi.ril17.spring.tp.domain.Seller;
import fr.cesi.ril17.spring.tp.services.ProductService;
import fr.cesi.ril17.spring.tp.services.SellerService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Product>> getProductAll() {
		return new ResponseEntity<List<Product>>(productService.findAll(), HttpStatus.OK);
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity deleteAll() {
		if (productService.deleteAll()) {
			return new ResponseEntity("All products deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity("Failed on delete all", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity deleteById(@PathVariable Long id) {
		if (productService.existById(id)) {
			if (productService.deleteById(id)) {
				return new ResponseEntity("Product deleted", HttpStatus.OK);
			} else {
				return new ResponseEntity("Failed on delete", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity("Product not found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/get/id/{id}")
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
		return new ResponseEntity<Optional<Product>>(productService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/get/name/{name}")
	public ResponseEntity<List<Product>> getClientByName(@PathVariable String name) {
		return new ResponseEntity<List<Product>>(productService.findByName(name), HttpStatus.OK);
	}
	
	@PostMapping("/post/")
	public long createClient(@RequestBody Product product) {
		product = productService.save(product);
		
		return product.getId();
	}

}
