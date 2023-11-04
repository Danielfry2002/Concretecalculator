package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import concrete.Concrete;



/**
 * Servlet implementation class ConcreteServlet
 */
@WebServlet(
		description = "A controller for my Concrete Calculator", 
		urlPatterns = { 
				"/ConcreteServlet", 
				"/getConcrete"
		})
public class ConcreteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConcreteServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
		//get the input data from the request object
				double width = Double.parseDouble(request.getParameter("width"));
				double length = Double.parseDouble(request.getParameter("length"));
				double thickness = Double.parseDouble(request.getParameter("Thickness"));
				int bagSize = Integer.parseInt(request.getParameter("bagSize"));
		        
				
		        //create a concrete object with the input data - now one of our outputs is ready
		        Concrete concrete = new Concrete(width, length, thickness, bagSize);
		        //using the concrete object, call the get concrete method
		        String html = concrete.getConcrete();
		      
		      
		        //store the output values somewhere that the view can get at - the request object will do nicely here
		        request.setAttribute("concrete", concrete);
		        request.setAttribute("html", html);
		        System.out.println(concrete.getConcrete());
		
		        //pass control to the jsp view component
		        String url = "/concrete.jsp";
		        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		       dispatcher.forward(request, response);
	}

}
