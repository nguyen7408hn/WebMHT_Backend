package com.mht.my_web.repository;

import com.mht.my_web.entity.Customer1H;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer1HRepository extends JpaRepository<Customer1H,Long> {

}
