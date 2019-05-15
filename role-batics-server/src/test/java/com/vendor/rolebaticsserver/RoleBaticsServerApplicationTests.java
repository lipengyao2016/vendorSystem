package com.vendor.rolebaticsserver;

import com.vendor.mapper.RolesMapper;
import com.vendor.model.Roles;
import com.vendor.utils.DBEntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleBaticsServerApplicationTests {

	@Autowired
	private RolesMapper rolesMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public  void testCreate()
	{
		Roles t1 = new Roles();
		t1.setName("liyuan");
		DBEntityUtils.preCreate(t1);
         int ret = rolesMapper.insert(t1);
         System.out.println(ret);
	}

}
