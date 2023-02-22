package com.contractManager.contractsManager;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
	//Role findByEmail(String email);
}
