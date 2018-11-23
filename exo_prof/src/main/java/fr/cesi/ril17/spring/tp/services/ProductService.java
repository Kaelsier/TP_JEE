package fr.cesi.ril17.spring.tp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cesi.ril17.spring.tp.domain.Product;
import fr.cesi.ril17.spring.tp.domain.Seller;
import fr.cesi.ril17.spring.tp.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepo;

	@Autowired
	public ProductService(ProductRepository productRepo) {
		super();
		this.productRepo = productRepo;
	}

	public List<Product> findAll() {
		List<Product> products = productRepo.findAll();
		return (products.isEmpty()) ? null : products;
	}

	public List<Product> findByName(String name) {
		List<Product> products = productRepo.findByName(name);
		return (products.isEmpty()) ? null : products;
	}

	public Optional<Product> findById(Long id) {
		try {
			Optional<Product> product = productRepo.findById(id);
			return product;
		} catch (Exception e) {
			return null;
		}
	}

	public Boolean deleteAll() {
		try {
			productRepo.deleteAll();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean deleteById(Long id) {
		try {
			productRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean deleteBySeller_id(Long id) {
		try {
			productRepo.deleteBySeller_id(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean existById(Long id) {
		return productRepo.existsById(id);
	}
	
	public boolean existsBySeller_id(Long id) {
		return productRepo.existsBySeller_id(id);
	}

	public Product save(Product product) {
		productRepo.save(product);

		return product;
	}
}
