package sample.spring.chapter06.bankapp.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import sample.spring.chapter06.bankapp.domain.CustomerRequestDetails;

@Repository(value = "customerRequestDao")
public class CustomerRequestDaoImpl implements CustomerRequestDao {
	private static Logger logger = Logger
			.getLogger(CustomerRequestDaoImpl.class);

	public CustomerRequestDaoImpl() {
		logger.info("Created CustomerRequestDaoImpl instance");
	}

	@Override
	public void submitRequest(CustomerRequestDetails userRequestDetails) {
		// --save UserRequestDetails
	}
}
