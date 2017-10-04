package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.A;
@WebServlet("/pattern")
public class QuestionWriter extends HttpServlet 
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		int count=0;
		String ss="Ans"+count;
		String ss1="ans1"+count;
		String ss2="ans2"+count;
		String ss3="ans2"+count;
		PrintWriter out=res.getWriter();
		Configuration cfg=new Configuration().configure("mapping/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		Query q=s.createQuery("from A");
				List l=q.list();
		Iterator itr=l.iterator();
		while(itr.hasNext())
		{
			A a=(A)itr.next();
			out.print("<h1>Q"+a.getQuestionNo()+"."+a.getQuestionName()+"</h1>");
			out.println("<input type='radio'  name='ans' value='red'>"+a.getOption1()+"<br>");
			out.println("<input type='radio'  name='ans' value='green'>"+a.getOption2()+"<br>");
			out.println("<input type='radio'  name='ans' value='blue'>"+a.getOption3()+"<br>");
			out.println("<br>");
			A a1=(A)itr.next();
			out.print("<h1>Q"+a1.getQuestionNo()+"."+a1.getQuestionName()+"</h1>");
			out.println("<input type='radio'  name='ans1' value='red1'>"+a1.getOption1()+"<br>");
			out.println("<input type='radio'  name='ans1' value='green1'>"+a1.getOption2()+"<br>");
			out.println("<input type='radio'  name='ans1' value='blue1'>"+a1.getOption3()+"<br>");
			out.println("<br>");
			A a2=(A)itr.next();
			out.print("<h1>Q"+a2.getQuestionNo()+"."+a2.getQuestionName()+"</h1>");
			out.println("<input type='radio'  name='ans2' value='red2'>"+a2.getOption1()+"<br>");
			out.println("<input type='radio'  name='ans2' value='green2'>"+a2.getOption2()+"<br>");
			out.println("<input type='radio'  name='ans2' value='blue2'>"+a2.getOption3()+"<br>");
			out.println("<br>");
			
		}
		
		
		out.println("<input type='submit' value='Submit'>");
		out.println("<input type='reset' value='Reset'>");
		
		
		
		
		
	}

}
