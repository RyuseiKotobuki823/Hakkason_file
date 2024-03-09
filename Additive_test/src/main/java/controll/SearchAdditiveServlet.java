package controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AdditiveDAO;
import DTO.AdditiveDTO;

/**
 * Servlet implementation class SearchAdditiveServlet
 */
@WebServlet("/search_additive-servlet")
public class SearchAdditiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAdditiveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String url = "additive_index.jsp";
		
		String searchAdditiveNameFromParameter = null;
		searchAdditiveNameFromParameter = (String)request.getParameter("search_additive_name");
		
		AdditiveDTO additiveDTO = AdditiveDAO.getAdditiveDTOByAdditiveName(searchAdditiveNameFromParameter);
		
		if (additiveDTO != null) {
			request.setAttribute("search_result_additiveDTO", additiveDTO);
		}
		
		List<AdditiveDTO> additiveDTOList = new ArrayList<>();
		additiveDTOList = AdditiveDAO.allAdditive();
		request.setAttribute("AdditiveDTOAllList", additiveDTOList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);	

		
		
	}
}
