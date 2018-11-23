package fr.cesi.ril17.spring.tp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cesi.ril17.spring.tp.domain.Product;
import fr.cesi.ril17.spring.tp.domain.Seller;
import fr.cesi.ril17.spring.tp.repository.ProductRepository;
import fr.cesi.ril17.spring.tp.repository.SellerRepository;

@Service
public class SellerService {

	private SellerRepository sellerRepo;
	private ProductRepository productRepo;

	@Autowired
	public SellerService(SellerRepository sellerRepo, ProductRepository productRepo) {
		super();
		this.sellerRepo = sellerRepo;
		this.productRepo = productRepo;
	}

	public List<Seller> findAll() {
		List<Seller> sellers = sellerRepo.findAll();
		return (sellers.isEmpty()) ? null : sellers;
	}

	public List<Seller> findByName(String name) {
		List<Seller> sellers = sellerRepo.findByName(name);
		return (sellers.isEmpty()) ? null : sellers;
	}

	public Optional<Seller> findById(Long id) {
		try {
			Optional<Seller> Seller = sellerRepo.findById(id);
			return Seller;
		} catch (Exception e) {
			return null;
		}
	}

	public Boolean deleteAll() {
		try {
			sellerRepo.deleteAll();
			productRepo.deleteAll();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean deleteById(Long id) {
		try {
			sellerRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean existById(Long id) {
		return sellerRepo.existsById(id);
	}

	public Seller save(Seller seller) {
		sellerRepo.save(seller);

		return seller;
	}

}
