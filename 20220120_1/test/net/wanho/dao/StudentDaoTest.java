package net.wanho.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import net.wanho.dao.impl.StudentDaoImpl;
import net.wanho.entity.Student;

public class StudentDaoTest {
	
	private final StudentDao studentDao = new StudentDaoImpl();
	

	@Test
	public void testInsert() {
		Student student = new Student();
		student.setSname("李三");
		student.setSno("s014");
		student.setDname("物理");
		student.setSage(23);
		student.setSsex("男");
		studentDao.insert(student);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		studentDao.delete("s012");
	}

	@Test
	public void testQueryAll() {
		List<Student> list = studentDao.queryAll();
		list.forEach(s -> System.out.println(s));
	}

	@Test
	public void testQueryOne() {
		Student s = studentDao.queryOne("s002");
		System.out.println(s);
	}

}
