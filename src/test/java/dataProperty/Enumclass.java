package dataProperty;

public enum Enumclass {
	AddPlace("/maps/api/place/add/json"),
	deletePlace("/maps/api/place/delete/json"),
	getPlace("/maps/api/place/get/json"),
	putPlace("maps/api/place/update/json");
	private String endpoint;
	Enumclass(String endpoint)
	{
		this.endpoint=endpoint;
	}
	public String getendpoint()
	{  
		return endpoint;
	}

}
