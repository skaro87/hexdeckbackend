package se.skaro.hexapi.model.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Card {
	
	@JsonProperty("Guid")
	private ItemGUID guid;
	
	@JsonProperty("Gems")
	private List<Gem> gems;

	public ItemGUID getGuid() {
		return guid;
	}

	public void setGuid(ItemGUID guid) {
		this.guid = guid;
	}

	public List<Gem> getGems() {
		return gems;
	}

	public void setGems(List<Gem> gems) {
		this.gems = gems;
	}
	
}
