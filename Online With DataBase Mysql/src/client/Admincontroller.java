package client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.A;
@WebServlet("/preparation")
public class Admincontroller extends HttpServlet 
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		
		String questionName=req.getParameter("qname");
		String Option1=req.getParameter("op1");
		String Option2=req.getParameter("op2");
		String Option3=req.getParameter("op3");
		PrintWriter out=res.getWriter();
		Configuration cfg=new Configuration().configure("mapping/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		A aa=new A();
		aa.setQuestionName(questionName);
		aa.setOption1(Option1);
		aa.setOption2(Option2);
		aa.setOption3(Option3);
		s.saveOrUpdate(aa);
		tr.commit();
		out.println("<a href='./qview.jsp'>CLICk</a>");
		
	}

}
