package mylab.customer.dao;

import java.util.List;

import mylab.customer.vo.CustomerVO;

public interface CustomerDAO {
	public void insertCustomer(CustomerVO customer);
	public List<CustomerVO> selectAllCustomer();
	public CustomerVO selectCustomer(int id);
}
