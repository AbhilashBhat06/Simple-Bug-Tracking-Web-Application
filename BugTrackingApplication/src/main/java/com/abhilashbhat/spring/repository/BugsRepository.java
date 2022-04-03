package com.abhilashbhat.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.abhilashbhat.spring.model.Bugs;

@Repository
public interface BugsRepository extends JpaRepository<Bugs, Long>{
	
}
