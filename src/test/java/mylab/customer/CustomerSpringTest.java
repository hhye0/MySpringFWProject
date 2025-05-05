package mylab.customer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.customer.dao.mapper.CustomerMapper;
import mylab.customer.service.CustomerService;
import mylab.customer.vo.CustomerVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-mybatis.xml")
public class CustomerSpringTest {

	protected static final Logger logger = LogManager.getLogger();

	@Autowired
	DataSource dataSource;

	@Autowired
	SqlSessionFactory sqlSessionFactory;

	@Autowired
	SqlSession sqlSession;

	@Autowired
	CustomerMapper customerMapper;

	@Autowired
	CustomerService customerService;

	@Test
	void serviceTest() {
		CustomerVO customer = new CustomerVO();
		customer.setEmail("test@spring.com");
		customer.setName("Spring User");
		customer.setAge(28);
		customer.setEntry_date();

		customerService.insertCustomer(customer);
		List<CustomerVO> list = customerService.getAllCustomerList();
		list.forEach(logger::debug);
	}

	@Test
	@Disabled
	void mapperTest() {
		CustomerVO customer = customerMapper.selectCustomer(1);
		logger.debug(customer);
	}

	@Test
	@Disabled
	void sqlSessionMapperTest() {
		CustomerVO customer = sqlSession.selectOne("customerNS.selectCustomerById", 1);
		logger.debug(customer);
	}

	@Test
	@Disabled
	void sqlSessionListTest() {
		List<CustomerVO> list = sqlSession.selectList("customerNS.selectAllCustomer");
		list.forEach(logger::debug);
	}

	@Test
    void dbConnectionTest() {
        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            logger.debug("DB URL: " + metaData.getURL());
            logger.debug("DB User: " + metaData.getUserName());
            logger.debug("DB Product: " + metaData.getDatabaseProductName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
