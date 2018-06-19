package se.skaro.hexapi.model.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveDeckMessage extends ApiMessage {
	
	@JsonProperty("Champion")
	private String champion;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("User")
	private String user;
	
	@JsonProperty("Deck")
	private List<Card> deck;
	
	@JsonProperty("Sideboard")
	private List<Card> sideboard;

	public String getChampion() {
		return champion;
	}

	public void setChampion(String champion) {
		this.champion = champion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public List<Card> getSideboard() {
		return sideboard;
	}

	public void setSideboard(List<Card> sideboard) {
		this.sideboard = sideboard;
	}
}
