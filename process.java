package com.exceltest.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class process
 */
@WebServlet("/process")
public class process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public process() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Personaldata> getlist=new ArrayList<>();
		String[] chkbox = request.getParameterValues("Selection");
		String[] firstName = request.getParameterValues("firstName");
		String[] lastName = request.getParameterValues("lastName");
		String[] gender = request.getParameterValues("gender");
		String[] age = request.getParameterValues("age");
		String[] city = request.getParameterValues("city");
		String[] country = request.getParameterValues("country");
		
		int i;
		
		for (i=0;i<chkbox.length;i++) {
			
			Personaldata P=new Personaldata();		
			
			int cbox=Integer.valueOf(chkbox[i]);	
			
			P.setRowno(cbox);
			P.setFirstName(firstName[cbox]);
			P.setLastName(lastName[cbox]);
			P.setGender(gender[cbox]);
			P.setAge(age[cbox]);
			P.setCity(city[cbox]);
			P.setCountry(country[cbox]);
			getlist.add(P);
			
		}
		

		Boolean result=Exceldatautil.writeExceldata(getlist);
		getlist.clear();
		
		
		
		if(result == true) {
			Excel C=new Excel();
			C.doGet(request, response);
		}
		
    }	
	

}
