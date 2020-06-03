package test.edu.zyb.exam;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.zyb.exam.beans.BJ;
import edu.zyb.exam.beans.Question;
import edu.zyb.exam.beans.Student;
import edu.zyb.exam.service.StudentService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class StudentTest {
	@Autowired
	private StudentService studentSer;
	@Test
	public void findStu(){
		
		Integer page = 1;
		if(page == null)
			page = 1;
		Integer total = studentSer.findAllCount();
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		List<Student> list = studentSer.getList((page-1)*8,8);
		if(list!=null)
			System.out.println(list.get(0).getBj().getBjname());
		else
			System.out.println("is null");
		
		
	}
	@Test
	public void addStu(){
		Student student = new Student();
		BJ bj = new BJ();
		bj.setBjid(1);
		student.setBj(bj);
		student.setEmail("111");
		student.setName("xiao");
		student.setPassword("12233");
		student.setPhone("111111");
		student.setSid(1752606);
		System.out.println(studentSer.addStu(student));
	}
	@Test
	public void updateStu(){
		Student student = new Student();
		BJ bj = new BJ();
		bj.setBjid(1);
		student.setBj(bj);
		student.setEmail("222");
		student.setName("xiao");
		student.setPassword("12233");
		student.setPhone("111111");
		student.setSid(1752606);
		System.out.println(studentSer.updateOneStu(student));
	}
		
	@Test
	public void delStu(){
		System.out.println(studentSer.delStu(1752606));
	}
	
	
	@Test
	public void login (){
		Student student = studentSer.login("1752601", "1752601");
		System.out.println(student);
	}
	
}
