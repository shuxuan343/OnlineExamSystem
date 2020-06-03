package test.edu.zyb.exam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.zyb.exam.beans.Question;
import edu.zyb.exam.beans.Relationpq;
import edu.zyb.exam.beans.TeacherUser;
import edu.zyb.exam.beans.TestControl;
import edu.zyb.exam.beans.TestPaper;
import edu.zyb.exam.service.QuestionService;
import edu.zyb.exam.service.TeacherService;
import edu.zyb.exam.service.TestnoteService;
import edu.zyb.exam.service.TestpaperService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestnoteTest {
	@Autowired
	private TestpaperService tesService;
	@Autowired
	private TestnoteService testnoteService;
	@Test
	public void findList(){
		testnoteService.queryTestonteStus(0, 8, 67);
		
	}
	
	
	
}
