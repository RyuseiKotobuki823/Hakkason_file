package controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/log_in-servlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");

		
		String userFlontId 	= req.getParameter("user_id");
		String password		= req.getParameter("password");
		String messege = null;
		String url = null;
		String flashMessege = "flash_messege";
		
		
		int userExisting = 0;
		userExisting = UserDAO.logInUser(userFlontId, password);
		
		if (userExisting == 1) {
			url = "additive_top.jsp";
			messege = "ログインに成功しました";
			req.setAttribute("green_messege", messege);
			req.setAttribute("yes_log_in", 1);
			 
		}else {
			url = "log_in.jsp";
			messege = "ログインに失敗しました";
			req.setAttribute("red_messege", messege);
			req.setAttribute("yes_log_in", 0);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, res);	
		
	}

}
