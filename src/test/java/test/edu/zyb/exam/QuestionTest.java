package test.edu.zyb.exam;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.zyb.exam.beans.Question;
import edu.zyb.exam.service.QuestionService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class QuestionTest {
	@Autowired
	private QuestionService questionService;
	@Test
	public void findQue(){
		
		Integer page = 1;
		if(page == null)
			page = 1;
		Integer total = questionService.findAllCount(null);
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		List<Question> list = questionService.getList((page-1)*8,8,null);
		System.out.println(list.get(0));
		
		
	}
	@Test
	public void findOneQue(){
		
		Question que = questionService.findOneQue(17);
		System.out.println(que);
		
		
	}
}
