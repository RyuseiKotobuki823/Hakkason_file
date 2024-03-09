package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.Myconnection;
import DTO.AdditiveDTO;

public class AdditiveDAO {
	
	public static List<AdditiveDTO > allAdditive(){
		String sql = "SELECT * FROM additive_table";
		
		
		List<AdditiveDTO> additiveDTOList = new ArrayList<>();
		
		try(
			Connection con = Myconnection.getMyCon();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sql);)
		{
			while(res.next()) {
				AdditiveDTO additiveDTO = new AdditiveDTO();
				additiveDTO.additiveId			= res.getInt("additive_id");
				additiveDTO.additiveCeateStamp	= res.getDate("additive_ceate_stamp");
				additiveDTO.additiveName		= res.getString("additive_name");
				additiveDTO.additiveDetail		= res.getString("additive_detail");
				
				additiveDTOList.add(additiveDTO);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return additiveDTOList;
		
	}

	
	public static AdditiveDTO getAdditiveDTOByAdditiveName( String additiveName) {
		
		String sql = "SELECT * FROM additive_table WHERE additive_name=\"" + additiveName + "\"";
		AdditiveDTO additiveDTO = new AdditiveDTO();
		
		try (
			Connection con = Myconnection.getMyCon();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sql);)
		{
			if(res.next()) {
				additiveDTO.additiveId 			= res.getInt("additive_id");
				additiveDTO.additiveCeateStamp 	= res.getDate("additive_ceate_stamp");
				additiveDTO.additiveName 		= res.getString("additive_Name");
				additiveDTO.additiveDetail 		= res.getString("additive_detail");
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return additiveDTO;
	}
}

