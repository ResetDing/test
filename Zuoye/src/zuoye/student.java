package zuoye;

public class student {
	
	int stuNum;
	String name;
	private int Java;
	private int DataBase;
	
	public student(int stuNum,String name){
		this.stuNum=stuNum;
		this.name=name;
		//    System.out.println("������"+stuNum+" ѧ�ţ�"+name);
	}
	
	public int getJava(){
		return Java;
	}
	
	public void setJava(int Java) {
		if(Java<0||Java>100) {
			this.Java=0;
		}else if(Java<70) {
			System.out.println("��������д����");
			this.Java=60;
		}else {
			this.Java=Java;
		}
	}
	
	public int getDataBase(){
		return DataBase;
	}
	
	public void setDataBase(int DataBase) {
		if(DataBase<0||DataBase>100) {
			this.DataBase=0;
		}else if(DataBase<60) {
			System.out.println("���ݿ�ɼ��������벹����");
		}else {
			this.DataBase=DataBase;
		}
	}
}
