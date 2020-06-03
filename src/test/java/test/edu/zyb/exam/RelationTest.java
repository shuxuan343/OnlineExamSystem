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
import edu.zyb.exam.service.TestpaperService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class RelationTest {
	@Autowired
	private TestpaperService tesService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private QuestionService questionService;
	@Test
	public void save(){
		/*TeacherUser teacherUser = teacherService.findOneTea(1752503);
		
		TestPaper paper = new TestPaper(null, "test", new Date(), 20, teacherUser, null);
		tesService.saveOrUpdate(paper);
		
		List<Relationpq> relationpqs = new ArrayList<Relationpq>();
		*/
		TeacherUser teacherUser = teacherService.findOneTea(1752503);
		
		TestPaper paper = new TestPaper(15, "test", new Date(), 20, teacherUser, null);
		
		Relationpq e = new Relationpq();

		e.setTestPaper(paper);
		e.setQuestion(questionService.findOneQue(17));
		tesService.saveRel(e);
		//relationpqs.add(e);
		
		//paper.setRelationpqs(relationpqs);
		System.out.println(paper);
		
		
	}
	
	@Test
	public void save2(){
		TeacherUser teacherUser = teacherService.findOneTea(1752503);
		List<Relationpq> relationpqs = new ArrayList<Relationpq>();
		Relationpq e = new Relationpq();
		
		relationpqs.add(e);
		TestPaper paper = new TestPaper(null, "test", new Date(), 20, teacherUser, relationpqs);
		
		e.setTestPaper(paper);
		e.setQuestion(questionService.findOneQue(17));
		//tesService.saveRel(e);
		paper.setRelationpqs(relationpqs);
		tesService.saveOrUpdate(paper);
		System.out.println(paper);
		
		
	}
	
	@Test
	public void find(){
		List<Question> list = tesService.getQueListByQty(24,1);
		System.out.println(list.size());
		
	}
	@Test
	public void find2(){
		List<TestControl> list = tesService.getListTsc(0,10,"aft");
		System.out.println(list.size());
		
	}
	@Test
	public void saveTsc() throws ParseException{
		String tdate = "2020-05-20 00:00";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = format.parse(tdate);
		TestControl control = new TestControl();
		control.setTdate(date);
		control.setTestPaper(tesService.findOneTpp(55));
		tesService.addTsc(control);
		
	}
}
