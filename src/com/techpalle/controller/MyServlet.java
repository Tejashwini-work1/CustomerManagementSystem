package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;


@WebServlet("/")
public class MyServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
       
    
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
	  
	  
		String path=request.getServletPath();
		
		switch(path)
		{
		
		case "/logCustomer":
			validateCustomer(request,response);
			break;
		case "/regCustomer":
			insertCustomer(request,response);
			break;
			
		case "/reg":
			getRegistationPage(request,response);
			break;
			
		case "/log":
			getLoginPage(response,request);
			break;
			
			default:
			getStartUpPage(request,response);
			break;
		}
	}

	
private void validateCustomer(HttpServletRequest request, HttpServletResponse response)
{
	String email=request.getParameter("tbEmaillog");
	String password=request.getParameter("tbPasslog");
	

	//call the method present in dao
	boolean res=DataAccess.validateCustomer(email, password);
	
	//condition and Redirect users to destination page (success)
	
	if(res)
	{
	try
	  {
		  RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
		  
		  //Store the successPage class data inside RD
		  
		  SuccessPage sp=new SuccessPage();
		  request.setAttribute("SuccessDetails", sp);
	      rd.forward(request, response);
		} 
	       catch (IOException e)
	       {
			
			e.printStackTrace();
		}
	   
	   catch(ServletException e1 )
	   {
		   e1.printStackTrace();
	   }
	}
	
else
	{
		getLoginPage(response,request);
	}
	
}
private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
{
	//Read the data from jsp page
	String n= request.getParameter("tbName");
	String e=request.getParameter("tbEmail");
	long m= Long.parseLong(request.getParameter("tbMobile"));
	String p=request.getParameter("tbPass");
	String s=request.getParameter("ddlStates");
	
	
	//Store that data in customer objects
	Customer c =new Customer(n,e,m,p,s);
	
	//call insetCustomer method parent in passing above object
	
	DataAccess.insertCustomer(c);
	
	try
	  {
		  RequestDispatcher rd=request.getRequestDispatcher("customer_login.jsp");
	       rd.forward(request, response);
	   }
	   catch(ServletException e1)
	   {
		   e1.printStackTrace();
	   }
	   catch (IOException e1)
	   {
		   e1.printStackTrace();
	   }
	
}


private void getRegistationPage(HttpServletRequest request, HttpServletResponse response)
{
	try
	  {
		  RequestDispatcher rd=request.getRequestDispatcher("customer_registration.jsp");
	       rd.forward(request, response);
	   }
	   catch(ServletException e1)
	   {
		   e1.printStackTrace();
	   }
	   catch (IOException e1)
	   {
		   e1.printStackTrace();
	   }
	
}






private void getLoginPage(HttpServletResponse response, HttpServletRequest request) 
{
	 try
	  {
		  RequestDispatcher rd=request.getRequestDispatcher("customer_login.jsp");
	       rd.forward(request, response);
	   }
	   catch(ServletException e)
	   {
		   e.printStackTrace();
	   }
	   catch (IOException e)
	   {
		   e.printStackTrace();
	   }
	
	
}


private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
	  try
	  {
		  RequestDispatcher rd=request.getRequestDispatcher("customer_management.jsp");
	       rd.forward(request, response);
	   }
	   catch(ServletException e)
	   {
		   e.printStackTrace();
	   }
	   catch (IOException e)
	   {
		   e.printStackTrace();
	   }
   }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request,response);
	}

}
