package net.wanho.dao;

import java.sql.DriverManager;

import org.junit.Test;

import junit.framework.Assert;
import net.wanho.dao.impl.TeacherDaoImpl;
import net.wanho.entity.Teacher;

public class TeacherDaoTest {
	
	TeacherDao teacherDao = new TeacherDaoImpl();
	@Test
	public void testInsert() {
		Teacher teacher = new Teacher();
		teacher.setTno("s012");
		teacher.setTname("ÕÔÔÆ");
		teacher.setDname("ÖÐÎÄ");
		teacher.setSal(2500);
		teacher.setAge(25);
		teacher.setTsex("ÄÐ");
		int rows = teacherDao.insert(teacher);
		Assert.assertEquals(1, rows);
		
	}
	@Test
	public void testUpdate() {
		System.out.println("testUpdate()");
	}

}

