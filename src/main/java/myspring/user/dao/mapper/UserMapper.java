package myspring.user.dao.mapper;
import java.util.List;

import myspring.user.vo.UserVO;

public interface UserMapper {
	//@Select("select * from users where userid=#{id}")
	//UserVO selectUserById(@Param("id") String id);
	UserVO selectUserById(String id);
	List<UserVO> selectUserList();
	void insertUser(UserVO userVO);
	void updateUser(UserVO userVO);
	void deleteUser(String id);
}

