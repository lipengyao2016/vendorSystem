package com.vendor.userserver;

import com.vendor.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServerApplicationTests {

	@Autowired
	private UserDao UserDao;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testAddUser() {
	/*	Users User = new Users();
		User.setType("merchant");
		User.setUuid("gmFTHz79zBlWyJ0M4h3MLQ");
		User.setName("testUser");
		User.setOwnerUuid("Qb6bKJ2COuIPQwFSwXzV2Q");
		User.setStatus("enabled");
	//	User.setPermission(new Character('a'));
		User.setCreatedAt(new Date());
		User.setModifiedAt(new Date());
		UserDao.save(User);*/
	}
}
