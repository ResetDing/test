package net.wanho.dao;

import java.util.List;

import net.wanho.entity.Student;

public interface StudentDao {
	
	public int insert(Student student);
	
	public int update(Student student);
	
	public int delete(String sno);
	
	public List<Student> queryAll();
	
	public Student queryOne(String sno);

}
