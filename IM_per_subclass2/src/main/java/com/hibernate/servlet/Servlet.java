package com.hibernate.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

//import com.hibernate.entity.NewPerson;
import com.hibernate.entity.Person;
import com.hibernate.util.Hibernate_util;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		addf(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		addf(request,response);
	}
	
	protected void addf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		Transaction tx=null;
		try {
			Session session = Hibernate_util.getSessionFactory().openSession();
//			Person person = new Person();
//			person.setPerson_name("Person1");
//			Person person1 = new Person();
//			person1.setPerson_name("Person2");
			
			Person person2 = new Person();
			person2.setPerson_name("Person3"); // for TableGenerator
			//**********************************************
			
//		   NewPerson newperson = new NewPerson();
//			newperson.setPerson_name("New1");
//			newperson.setAge(21);
//			newperson.setEmail("x1@gmail.com");
//			newperson.setPhone(234455);
			//---------------------------------------------
//			NewPerson newperson1 = new NewPerson();
//			newperson1.setPerson_name("New2");
//			newperson1.setAge(24);
//			newperson1.setEmail("x12@gmail.com");
//			newperson1.setPhone(565444);
			
			tx=session.beginTransaction();
//			session.save(person);
//			session.save(person1);
//			session.save(newperson);
//			session.save(newperson1);
			session.save(person2);
			tx.commit();
			out.println("Data added in database");
	}
		catch(Exception e)
		{
			e.printStackTrace();
			if(tx!=null)
			{
				tx.rollback();
			}
		}
}
}
