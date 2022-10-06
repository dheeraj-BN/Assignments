package ValtechWeb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valtech.dao.Employee;
import com.valtech.dao.EmployeeDAO;

@WebServlet(urlPatterns = { "/empCtlr" })
public class EmployeeControllerServlet extends HttpServlet {

	private EmployeeDAO dao;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		dao = new EmployeeDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		// login and forward to jsp
		try {
			String empId = req.getParameter("empId");
			String submit = req.getParameter("submit");
			
			
			if (empId == null) {
				loadEmpsAndGotoEmpsPage(req, resp);
				return;
			}
			int id = Integer.parseInt(req.getParameter("empId"));
			if("delete".equals(submit)) {
				dao.deleteEmployee(id);
				loadEmpsAndGotoEmpsPage(req, resp);
				return;
			}
			
			if("update".equals(submit)) {
				Employee e = dao.getEmployee(id);
				req.setAttribute("e", e);
				req.getRequestDispatcher("update.jsp").forward(req,resp);
				return;
			}
			
			Employee e = dao.getEmployee(id);
			req.setAttribute("e", e);
			req.getRequestDispatcher("emp.jsp").forward(req, resp);

		} catch (Exception ex) {
			// TODO: handle exception
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String submit = req.getParameter("submit");
		System.out.println(submit);
		try {
			if("newEmp".equals(submit)) {
				req.getRequestDispatcher("createEmp.jsp").forward(req, resp);
				return;
			}
			
			
			if ("save".equals(submit)) {
				Employee e= new Employee();
				e.setId(dao.getNextValidId());
				e.setName(req.getParameter("name"));
				e.setAge(Integer.parseInt(req.getParameter("age")));
				e.setGender(Integer.parseInt(req.getParameter("gender")));
				e.setSalary(Integer.parseInt(req.getParameter("salary")));
				dao.saveEmployee(e);
				

			}
			
			if("updateEmp".equals(submit)) {
				//dao=new EmployeeDAO();
				Employee e= new Employee();
				int id = Integer.parseInt(req.getParameter("id"));
				e.setId(id);
				e.setName(req.getParameter("name"));
				e.setAge(Integer.parseInt(req.getParameter("age")));
				e.setGender(Integer.parseInt(req.getParameter("gender")));
				e.setSalary(Float.parseFloat(req.getParameter("salary")));
				dao.updateEmployee(e);
				
			}
			
			loadEmpsAndGotoEmpsPage(req, resp);
			 	

		} catch (Exception ex) {
			// TODO: handle exception
			throw new RuntimeException(ex);
		}
	}

	private void loadEmpsAndGotoEmpsPage(HttpServletRequest req, HttpServletResponse resp)
			throws Exception, ServletException, IOException {
		List<Employee> emps = dao.getEmployees();
		req.setAttribute("emps", emps);
		req.getRequestDispatcher("emps.jsp").forward(req, resp);
	}

}
