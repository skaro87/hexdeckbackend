package se.skaro.hexapi.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Gem {
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Guid")
	private ItemGUID guid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemGUID getGuid() {
		return guid;
	}

	public void setGuid(ItemGUID guid) {
		this.guid = guid;
	}
}
