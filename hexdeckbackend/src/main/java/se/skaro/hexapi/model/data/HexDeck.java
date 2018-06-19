package se.skaro.hexapi.model.data;

import java.util.List;

public class HexDeck {
	
	private String name;
	private HexDeckCard champion;
	private List<HexDeckCard> main;
	private List<HexDeckCard> reserves;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HexDeckCard getChampion() {
		return champion;
	}
	public void setChampion(HexDeckCard champion) {
		this.champion = champion;
	}
	public List<HexDeckCard> getMain() {
		return main;
	}
	public void setMain(List<HexDeckCard> main) {
		this.main = main;
	}
	public List<HexDeckCard> getReserves() {
		return reserves;
	}
	public void setReserves(List<HexDeckCard> reserves) {
		this.reserves = reserves;
	}

}
