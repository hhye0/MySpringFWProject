package mylab.customer.dao.mapper;

import java.util.List;

import mylab.customer.vo.CustomerVO;

public interface CustomerMapper {
	public void insertCustomer(CustomerVO customer);
	public List<CustomerVO> selectAllCustomer();
	public CustomerVO selectCustomer(int id);
}
