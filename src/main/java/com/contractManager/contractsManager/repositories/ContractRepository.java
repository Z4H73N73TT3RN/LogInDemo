package com.contractManager.contractsManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long>{
	
	Contract findByName(String name);

}
