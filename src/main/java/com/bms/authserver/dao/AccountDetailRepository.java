package com.bms.authserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.authserver.models.AccountDetail;

@Repository
public interface AccountDetailRepository extends JpaRepository<AccountDetail,Long> {

}
