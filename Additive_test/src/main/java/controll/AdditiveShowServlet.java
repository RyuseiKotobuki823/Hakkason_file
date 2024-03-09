package controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AdditiveDAO;
import DTO.AdditiveDTO;

/**
 * Servlet implementation class AdditiveShowServlet
 */
@WebServlet("/additive_show-servlet")
public class AdditiveShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditiveShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String url = "additive_show.jsp";
		String additiveNameFromParameter = (String)request.getParameter("additive_name");
		
		AdditiveDTO additiveDTO = new AdditiveDTO();
		
		additiveDTO = AdditiveDAO.getAdditiveDTOByAdditiveName(additiveNameFromParameter);
		request.setAttribute("additiveDTO", additiveDTO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}



}
