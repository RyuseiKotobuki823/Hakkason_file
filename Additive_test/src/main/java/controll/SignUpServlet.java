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
@WebServlet("/sign_up-servlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		

		String userName 		= req.getParameter("user_name");
		String userFlontId 		= req.getParameter("user_flont_id");
		String userPassword		= req.getParameter("user_password");
		String messege = null;
		String url = null;
		String flashMessege = "flash_messege";
		
		System.out.println(userName);
		System.out.println(userFlontId);
		System.out.println(userPassword);
		
		int yesUpdated = 0;
		
		yesUpdated = UserDAO.signUpUser(userName, userFlontId, userPassword);
		System.out.println(yesUpdated);
		
		if (yesUpdated == 1) {
			url = "additive_top.jsp";
			messege = "新規登録に成功しました";
			req.setAttribute("green_messege", messege);
		}else {
			url = "sign_up.jsp";
			messege = "新規登録に失敗しました";
			req.setAttribute("red_messege", messege);
		}
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, res);
	}
	
	

}
