package fr.cesi.ril17.spring.tp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.cesi.ril17.spring.tp.domain.Product;
import fr.cesi.ril17.spring.tp.domain.Seller;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Long> {
	List<Seller> findAll();

	List<Seller> findByName(String name);

	Optional<Seller> findById(Long id);

	Seller save(Seller seller);
}
