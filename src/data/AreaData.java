package data;

public class AreaData {
	private int areaID;
	private String areaName;
	
	public AreaData() {
		
	}

	public AreaData(int areaID, String areaName) {
		super();
		this.areaID = areaID;
		this.areaName = areaName;
	}

	public int getAreaID() {
		return areaID;
	}

	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	
}
