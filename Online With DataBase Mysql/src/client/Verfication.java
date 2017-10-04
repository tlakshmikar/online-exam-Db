package client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/client12")
public class Verfication extends HttpServlet 
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String pass=req.getParameter("pass");
		PrintWriter out=res.getWriter();
		if(pass.equals("admin"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("question.jsp");
			rd.forward(req, res);
		}
		else
		{
			out.println("incorrent password");
			RequestDispatcher rd=req.getRequestDispatcher("admin.jsp");
			rd.include(req, res);
		}
	}

}
