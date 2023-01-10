package SQL;

import java.util.List;

import ex0118.Teacher;

public interface TeacherDao {

	
	public int insert(Teacher teacher);
	
	
	public int delete(String sno);
	
	
	public int update(Teacher teacher);
	
	
	public List<Teacher> queryAll();
	
	public Teacher queryOne(String sno);
}

