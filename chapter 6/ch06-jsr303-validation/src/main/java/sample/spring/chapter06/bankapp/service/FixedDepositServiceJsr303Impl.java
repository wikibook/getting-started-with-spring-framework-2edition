package sample.spring.chapter06.bankapp.service;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sample.spring.chapter06.bankapp.dao.FixedDepositDao;
import sample.spring.chapter06.bankapp.domain.FixedDepositDetails;

@Service(value = "fixedDepositServiceJsr303")
public class FixedDepositServiceJsr303Impl implements FixedDepositService {
	private static Logger logger = Logger
			.getLogger(FixedDepositServiceJsr303Impl.class);

	@Autowired
	private Validator validator;

	@Autowired
	@Qualifier(value = "myFixedDepositDao")
	private FixedDepositDao myFixedDepositDao;

	@Override
	public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
		Set<ConstraintViolation<FixedDepositDetails>> violations = validator
				.validate(fdd);
		Iterator<ConstraintViolation<FixedDepositDetails>> itr = violations
				.iterator();
		if (itr.hasNext()) {
			logger.error("Errors were found while validating FixedDepositDetails instance");
		} else {
			myFixedDepositDao.createFixedDeposit(fdd);
			logger.info("Created fixed deposit");
		}
	}
}
