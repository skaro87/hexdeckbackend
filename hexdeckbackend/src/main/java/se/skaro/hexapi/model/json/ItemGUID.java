package se.skaro.hexapi.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemGUID {
	
	@JsonProperty("m_Guid")
	private String guid;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}
	
}
