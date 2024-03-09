package DTO;

import java.util.Date;

public class AdditiveDTO {

	public int additiveId;
	public Date additiveCeateStamp;
	public String additiveName;
	public String additiveDetail;
	
	
	public AdditiveDTO( int additiveId, String additiveName, String additiveDetail) {
		this.additiveId		= additiveId;
		this.additiveName	= additiveName;
		this.additiveDetail	= additiveDetail;
	}
	
	public AdditiveDTO() {
	}
}
