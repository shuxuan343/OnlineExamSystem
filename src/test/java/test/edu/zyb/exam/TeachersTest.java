package test.edu.zyb.exam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.zyb.exam.beans.TeacherUser;
import edu.zyb.exam.service.TeacherService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TeachersTest {
	@Autowired
	private TeacherService teacherService;
	@Test
	public void save(){
		TeacherUser user = new TeacherUser();
		user.setTid(1752502);
		user.setEmail("1111");
		user.setPassword("123445");
		teacherService.addTea(user);
		
	}
	
}
