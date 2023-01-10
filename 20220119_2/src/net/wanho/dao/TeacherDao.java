package net.wanho.dao;
import java.util.List;

import net.wanho.entity.Teacher;

public interface TeacherDao {
	
	
	public int insert(Teacher teacher); 
	
	
	public int update(Teacher teacher);
	
	
	public int delete(String tno);
	
	public List<Teacher> queryAll();
	
	public Teacher queryOne();


	Teacher queryOne(String tno);
}