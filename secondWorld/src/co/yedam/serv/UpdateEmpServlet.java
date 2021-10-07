package co.yedam.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.EmpDAO;

@WebServlet("/UpdateEmpServlet")
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateEmpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		EmpDAO dao = new EmpDAO();
		String newId = request.getParameter("newId");
		String newName = request.getParameter("newName");
		String newEmail = request.getParameter("newEmail");
		
		if(dao.updateEmployee(newId, newName, newEmail)) {
			// {"retCode":"success"}
			out.println("{\"retCode\":\"success\"}");
		} else {
			out.println("{\"retCode\":\"fail\"}");
		}
		
	}

}
