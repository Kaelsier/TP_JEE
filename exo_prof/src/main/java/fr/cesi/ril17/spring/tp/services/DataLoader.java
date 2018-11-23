package fr.cesi.ril17.spring.tp.services;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cesi.ril17.spring.tp.domain.Product;
import fr.cesi.ril17.spring.tp.domain.Seller;
import fr.cesi.ril17.spring.tp.repository.ProductRepository;
import fr.cesi.ril17.spring.tp.repository.SellerRepository;

@Service
public class DataLoader {

	private SellerRepository sellerRepo;
	private ProductRepository productRepo;

	@Autowired
	public DataLoader(SellerRepository sellerRepo, ProductRepository productRepo) {
		super();
		this.sellerRepo = sellerRepo;
		this.productRepo = productRepo;
	}

	@PostConstruct
	private void loadData() {
		// create seller
		Seller seller1 = new Seller(null, "MARTIN", "23 Rue paul bonamy", "31500", "Toulouse", null);
		sellerRepo.save(seller1);
		Product product1 = new Product(null, "Honor10", "Téléphone sous android 8.1", "a", 300.00, new Date(), seller1);
		Product product2 = new Product(null, "Honor8", "Téléphone sous android 8.1", "b", 20.00, new Date(), seller1);
		productRepo.save(product1);
		productRepo.save(product2);
	}

}
