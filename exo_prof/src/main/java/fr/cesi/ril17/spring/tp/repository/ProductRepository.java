package fr.cesi.ril17.spring.tp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.cesi.ril17.spring.tp.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();

	List<Product> findByName(String name);

	Optional<Product> findById(Long id);

	boolean existsBySeller_id(Long id);

	void deleteBySeller_id(Long id);
}
