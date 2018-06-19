package se.skaro.hexapi.model.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dataroot")
@XmlAccessorType(XmlAccessType.FIELD)
public class HexCards {
	
	@XmlElement(name="All_x0020_Cards")
	private List<HexCard> cards;

	public List<HexCard> getCards() {
		return cards;
	}
	public void setCards(List<HexCard> cards) {
		this.cards = cards;
	}
}
