//package com.bms.authserver.service;
//
//import java.util.Date;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.bms.authserver.dao.CustomerAddressRepository;
//import com.bms.authserver.dao.CustomerCredentialsRepository;
//import com.bms.authserver.dao.CustomerDetailRepository;
//import com.bms.authserver.dao.PasswordAuditRepository;
//import com.bms.authserver.dao.AccountDetailRepository;
//import com.bms.authserver.dao.AccountMasterRepository;
//import com.bms.authserver.models.CustomerAddress;
//import com.bms.authserver.models.CustomerCredentials;
//import com.bms.authserver.models.CustomerDetail;
//import com.bms.authserver.models.PasswordAudit;
//import com.bms.authserver.models.AccountDetail;
//import com.bms.authserver.models.AccountMaster;
//
//
//
//@Component
//public class TestService {
//
//	private final PasswordEncoder passwordEncoder;
//	private final CustomerCredentialsRepository repository;
//	private final CustomerDetailRepository customerDetail;
//	private final CustomerAddressRepository customerAddress;
//	private final AccountDetailRepository accountDetail;
//	private final AccountMasterRepository accountMaster;
//	private final PasswordAuditRepository passwordAudit;
//
//
//	public TestService(PasswordEncoder passwordEncoder, CustomerCredentialsRepository repository, CustomerDetailRepository customerDetail,
//			CustomerAddressRepository customerAddress, AccountDetailRepository accountDetail ,AccountMasterRepository accountMaster,PasswordAuditRepository passwordAudit) {
//
//		super();
//		this.passwordEncoder = passwordEncoder;
//		this.repository = repository;
//		this.customerDetail=customerDetail;
//		this.customerAddress=customerAddress;
//		this.accountDetail=accountDetail;
//		this.accountMaster=accountMaster;
//		this.passwordAudit=passwordAudit;
//	}
//
//
//	@PostConstruct
//	public void postConstruct() {
//
//		CustomerCredentials credentials = new CustomerCredentials("xyz", passwordEncoder.encode("pass"));
//		CustomerDetail cusdetail=new CustomerDetail();
//
//		cusdetail.setFirstName("x");
//		cusdetail.setLastName("Y");
//		cusdetail.setId(credentials);
//
////
////		CustomerAddress cusAddress=new CustomerAddress();
////		cusAddress.setAddress("qeer");
////		cusAddress.setCity("erd");
////		cusAddress.setcId(cusdetail);
////
////
////
////		AccountDetail accDetail=new AccountDetail();
////		accDetail.setAccountNumber("12763788199");
////		accDetail.setcId(cusdetail);
////
////
////		AccountMaster accMaster=new AccountMaster();
////		accMaster.setAccountType("saving");
////
////
////		PasswordAudit passAudit=new PasswordAudit();
////		passAudit.setOldPassword("odmjwe");
////		passAudit.setcId(credentials);
//
//
//		repository.save(credentials);
//		customerDetail.save(cusdetail);
////		customerAddress.save(cusAddress);
////		accountDetail.save(accDetail);
////		accountMaster.save(accMaster);
////		passwordAudit.save(passAudit);
//	}
//
//
//
//}
