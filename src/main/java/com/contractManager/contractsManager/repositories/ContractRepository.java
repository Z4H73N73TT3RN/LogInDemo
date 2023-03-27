package com.contractManager.contractsManager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long>{
	
	//Contract findByName(String name);
	Optional<Contract> findById(Long id);
}
