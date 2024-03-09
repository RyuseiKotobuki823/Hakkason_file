package controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ItemDAO;
import DTO.ItemDTO;

/**
 * Servlet implementation class ItemShowServlet
 */
@WebServlet("/item_show-servlet")
public class ItemShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String url = "item_show.jsp";
		String itemIdFromParameterStr = request.getParameter("item_id");
		int  itemIdFromParameter = Integer.parseInt(itemIdFromParameterStr);
		
		System.out.println("[DEBUG]:" + itemIdFromParameter);
		
		ItemDTO itemDTO = ItemDAO.searchItemDTOByItemId(itemIdFromParameter);
		request.setAttribute("itemDTO", itemDTO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
