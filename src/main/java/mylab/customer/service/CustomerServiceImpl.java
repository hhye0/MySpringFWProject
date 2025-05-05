package mylab.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mylab.customer.dao.CustomerDAO;
import mylab.customer.vo.CustomerVO;

@Repository
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public CustomerVO getCustomerInfo(int id) {
		return customerDAO.selectCustomer(id);
	}

	@Override
	public List<CustomerVO> getAllCustomerList() {
		return customerDAO.selectAllCustomer();
	}

	@Override
	public void insertCustomer(CustomerVO customer) {
		customerDAO.insertCustomer(customer);
		
	}
	
	
}
