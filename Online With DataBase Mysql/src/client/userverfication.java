package client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/userverfication")
public class userverfication extends HttpServlet 
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String pass=req.getParameter("pass11");
		PrintWriter out=res.getWriter();
		if(pass.equals("admin"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("qview.jsp");
			rd.forward(req, res);
		}
		else
		{
			out.println("incorrent password");
			RequestDispatcher rd=req.getRequestDispatcher("user.jsp");
			rd.include(req, res);
		}
	}

}
