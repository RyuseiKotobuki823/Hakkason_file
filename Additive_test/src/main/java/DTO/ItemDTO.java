package DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemDTO {
	public int		itemId = -1;
	public Date		itemCreateStamp;
	public String	itemName = "syokki";
	public String	itemGenreName = "syokki";
	public List<String> havingAdditiveNames = new ArrayList<>();
	
	public ItemDTO(int itemId, Date itemCreateStamp, String itemName, String itemGenreName, List<String> havingAdditives) {
		this.itemId 			= itemId;
		this.itemCreateStamp	= itemCreateStamp;
		this.itemName 			= itemName;
		this.itemGenreName 		= itemGenreName;
		this.havingAdditiveNames = havingAdditives;
	}
	
	public ItemDTO(int itemId, Date itemCreateStamp, String itemName, String itemGenreName) {
		this.itemId 			= itemId;
		this.itemCreateStamp	= itemCreateStamp;
		this.itemName 			= itemName;
		this.itemGenreName 		= itemGenreName;
	}

	
	
	
	public ItemDTO() {}

}
