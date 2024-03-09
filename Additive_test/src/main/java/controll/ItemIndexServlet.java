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
import DTO.ItemDTO;

/**
 * Servlet implementation class ItemIndexServlet
 */
@WebServlet("/item-index-servlet")
public class ItemIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String url = "item_index.jsp";
		
		//リクエストスコープに、ItemDTOALLを渡す
		List<ItemDTO> itemDTOList = new ArrayList<>();
		
		
		itemDTOList = ItemDAO.allItem();
		req.setAttribute("itemDTOAll", itemDTOList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, res);
	}

}
