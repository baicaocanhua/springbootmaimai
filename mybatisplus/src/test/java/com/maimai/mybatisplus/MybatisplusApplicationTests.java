package com.maimai.mybatisplus;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.maimai.mybatisplus.dao.UserMapper;
import com.maimai.mybatisplus.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Wrapper;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class MybatisplusApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(123);
	}


	private UserMapper userMapper;

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}



	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));

		//List<User> userList = userMapper.selectList(null);
		EntityWrapper<User> userEntityWrapper = new EntityWrapper<>();
		userEntityWrapper.eq("name","Tom");
		//List<User> userList = userMapper.selectList(userEntityWrapper);
		List<User> userList = userMapper.maimai();
		Assert.assertEquals(5, userList.size());
		userList.forEach(System.out::println);

		userMapper.maimai();
	}

}
