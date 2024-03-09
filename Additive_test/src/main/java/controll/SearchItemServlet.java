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

import DAO.ItemDAO;
import DTO.AdditiveDTO;
import DTO.ItemDTO;

/**
 * Servlet implementation class SearchItemServlet
 */
@WebServlet("/search_item-servlet")
public class SearchItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String url = "item_index.jsp";
		
		String searchItemNameFromParameter = null;
		searchItemNameFromParameter = (String)request.getParameter("search-item-name");
		
		ItemDTO itemDTO = ItemDAO.searchItemDTOByItemName(searchItemNameFromParameter);
		
		if (itemDTO != null) {
			request.setAttribute("search_result_itemDTO", itemDTO);
		}
		
		List<AdditiveDTO> additiveDTOList = new ArrayList<>();
		
		List<ItemDTO> itemDTOList = new ArrayList<>();
		itemDTOList = ItemDAO.allItem();
		request.setAttribute("itemDTOAll", itemDTOList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);	
		
	}

}
