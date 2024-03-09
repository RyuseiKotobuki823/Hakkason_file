package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.ItemDTO;

public class ItemDAO {
	//デバックOK
	/*--------------------------------------------------------------------------*/
	public static ItemDTO searchItemDTOByItemName(String itemName) {
		int itemId = 0;
		ItemDTO itemDTO = null;
		String sql = "SELECT * FROM item_table WHERE item_name = \""+ itemName + "\"";
		
		
		//be_haved_additive_id以外のカラムでレコードを取得
		try(
			Connection con = myConnection();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sql);)
		{
			if(res.next()) {
				itemDTO = new ItemDTO(
											itemId = res.getInt("item_id"),
											res.getDate("item_ceate_stamp"),
											res.getString("item_name"),
											res.getString("item_genre_name"));
			}
			
		}catch(SQLException e) {
			System.out.println("※error...");
			System.out.println(e);
		}
		

		itemDTO.havingAdditiveNames = getHavingAdditivesByItemId(itemId);
				
		return itemDTO;
		
		//be_haved_additive_idを取得
	}
	
	public static ItemDTO searchItemDTOByItemId(int itemId) {
		ItemDTO itemDTO = null;
		String sql = "SELECT * FROM item_table WHERE item_id = \""+ itemId + "\"";
		
		
		//be_haved_additive_id以外のカラムでレコードを取得
		try(
			Connection con = myConnection();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sql);)
		{
			if(res.next()) {
				itemDTO = new ItemDTO(
											itemId = res.getInt("item_id"),
											res.getDate("item_ceate_stamp"),
											res.getString("item_name"),
											res.getString("item_genre_name"));
			}
			
		}catch(SQLException e) {
			System.out.println("※error...");
			System.out.println(e);
		}
		

		itemDTO.havingAdditiveNames = getHavingAdditivesByItemId(itemId);
				
		return itemDTO;
		
		//be_haved_additive_idを取得
	}
	
	public static List<String> getHavingAdditivesByItemId(int itemId){
		//→　i_a_pare_status_tableから、（引数で受け取った）item_name持つのbe_haved_additive_id をListで取得
		String sqlGetAdditiveIsHavedId = 
				"SELECT at.additive_name "
				+ "FROM i_a_pare_status ia "
				+ "RIGHT OUTER JOIN additive_table at "
				+ "ON ia.be_haved_additive_id = at.additive_id "
				+ "WHERE having_id = " + itemId;
		
		List<String> havedAdditiveNameList = new ArrayList<>();
		
		try(
				Connection con = myConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sqlGetAdditiveIsHavedId);)
		{
			while(res.next()) {
					havedAdditiveNameList.add(res.getString("additive_name"));
			}		
		}catch(SQLException e) {
				System.out.println("※error...");
				System.out.println(e);
		}
		

		return havedAdditiveNameList;
				
	}

	private static Connection myConnection() throws SQLException{
		final String url 			= "jdbc:mysql://localhost:3306/additive_db";
										
		final String dbUserName		= "reiji";
		final String password 		= "pass";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, dbUserName, password);
	}
	/*-----------------------------------------------z-------------------------------------*/
	
	//引数で受け取ったジャンルの　商品レコードを全取得し　List<ItemDTO>で返却
	/*
	public static ArrayList<ItemDTO> tabAll(String genreName){
	
		//
		ItemDTO itemDTO = new ItemDTO();
		ArrayList<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();
		List<ItemDTO> itemD = new ArrayList<>();;
		int itemId = 0;
		int i = 0;
		
		System.out.println("[IN-DAO]--------------------");
		String sql = "SELECT * FROM item_table WHERE item_genre_name = \"" + genreName + "\"";
		
		
		try(
			Connection con = myConnection();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sql);)
		{
			System.out.println("[IN-LOOP]---");
			while(res.next()) {
				itemId = res.getInt("item_id");
				itemDTO.itemId				= res.getInt("item_id");
				itemDTO.itemCreateStamp		= res.getDate("item_ceate_stamp");
				itemDTO.itemName			= res.getString("item_name");
				itemDTO.itemGenreName		= res.getString("item_genre_name");
				itemDTO.havingAdditiveNames = getHavingAdditivesByItemId(itemId);
				
				itemDTOList.add(itemDTO);
//				System.out.print("unit(Listへ格納されたもの)");	display(itemDTOList.get(i));

				System.out.println("(格納後)" + (i++) + "周");	//display(itemDTO);
				
				for (ItemDTO iDTO : itemDTOList) {
					display(iDTO);
				}
				

			
			}
			System.out.println("[END-LOOP]---");
		}catch(SQLException e) {
			System.out.println("※error");
			System.out.println(e);
		}
		
		
		System.out.println("final ItemDTOList-------");
		for (ItemDTO iDTO : itemDTOList) {
			display(iDTO);
		}
		System.out.println("final ItemDTOList-------");
		System.out.println("[END-DAO]--------------------");
		return (itemDTOList);
	}
	*/
	
	public static List<ItemDTO> allItem() {
		String sql = "SELECT * FROM item_table";
		List<ItemDTO> itemDTOList = new ArrayList<>();
		
		
		try(
			Connection con = myConnection();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sql);)
		{
			while(res.next()) {
				ItemDTO itemDTO = new ItemDTO();
				itemDTO.itemId 				= res.getInt("item_id");
				itemDTO.itemCreateStamp		= res.getDate("item_ceate_stamp");
				itemDTO.itemName			= res.getString("item_name");
				itemDTO.itemGenreName		= res.getString("item_genre_name");
				itemDTO.havingAdditiveNames = getHavingAdditivesByItemId(res.getInt("item_id")); 
				
				itemDTOList.add(itemDTO);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		return itemDTOList;
		
	}
	
	
	public void display(ItemDTO itemDTO) {
		System.out.println(itemDTO.itemId);
		System.out.println(itemDTO.itemCreateStamp);
		System.out.println(itemDTO.itemName);
		System.out.println(itemDTO.itemGenreName);
		
		for (String display : itemDTO.havingAdditiveNames) {
			System.out.print(display + ",");
		}
		System.out.print("\n");
	}
	

	
	
	
		
	

}
