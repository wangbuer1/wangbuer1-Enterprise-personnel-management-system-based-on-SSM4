package edu.hebeu.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hebeu.entity.Move;
import edu.hebeu.service.MoveService;


public class MoveTest {

	@SuppressWarnings("resource")
	@Test
	public void test(){
		String xmlPath="spring/spring.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		MoveService service = (MoveService) context.getBean("changeService");
		Move move = new Move();
		move.setEmployeeNumber(123);
		move.setAfter(123);
		move.setBefore(123);
		move.setTime(new Date());
		service.insert(move);
	}
	
	@SuppressWarnings("resource")
	@Test
	public void test2(){
		String xmlPath="spring/spring.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		MoveService service = (MoveService) context.getBean("moveService");
		List<Move> list = service.selectList();
		for(Move move : list){
			System.out.println(move.toString());
		}
	}
}
