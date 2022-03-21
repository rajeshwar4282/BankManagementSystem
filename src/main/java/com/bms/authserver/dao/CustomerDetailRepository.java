package com.bms.authserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.authserver.models.CustomerDetail;

public interface CustomerDetailRepository extends JpaRepository<CustomerDetail, Long>{

}
