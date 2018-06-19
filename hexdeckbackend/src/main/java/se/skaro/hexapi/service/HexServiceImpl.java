package se.skaro.hexapi.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import se.skaro.hexapi.model.xml.HexCard;
import se.skaro.hexapi.model.xml.HexCards;
import se.skaro.hexapi.model.data.HexDeck;
import se.skaro.hexapi.model.data.HexDeckCard;
import se.skaro.hexapi.model.json.ApiMessage;
import se.skaro.hexapi.model.json.Card;
import se.skaro.hexapi.model.json.SaveDeckMessage;

@Component
public class HexServiceImpl implements HexService {

	private Map<String, HexCard> cardMap = new HashMap<>();
	private Map<String, HexDeck> deckMap = new HashMap<>();
	
	@PostConstruct
	public void postConstruct() {
		loadCards();
	}

	public void loadCards() {
		File file = new File("cards.xml");
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(HexCards.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			HexCards cards = (HexCards) jaxbUnmarshaller.unmarshal(file);

			cards.getCards().forEach(c -> {
				cardMap.put(c.getGuid(), c);
			});

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Handle different messages. The message comes as either a generic message
	 * (don't do anything) or as a specified subclass
	 * 
	 * @param message
	 *            The message sent by the local HEX: Shards of Fate API
	 */
	@Override
	public void handleHEXApiMessage(ApiMessage message) {
		if (message instanceof SaveDeckMessage) {
			SaveDeckMessage saveDeckMessage = (SaveDeckMessage) message;
			handleSaveDeckMessage(saveDeckMessage, saveDeckMessage.getUser());
		}
	}

	/**
	 * 
	 * @param message
	 *            The SaveDeckMessage sent by a user saving their deck in HEX:
	 *            Shards of Fate
	 */
	public void handleSaveDeckMessage(SaveDeckMessage message, String username) {
		HexDeck deck = new HexDeck();
		deck.setName(message.getName());
		deck.setMain(generateCardListFromJSONMessage(message.getDeck()));
		deck.setReserves(generateCardListFromJSONMessage(message.getSideboard()));
		deck.setChampion(generateChampionFromName(message.getChampion()));
		getDeckMap().put(username.toLowerCase(), deck);
	}

	private HexDeckCard generateChampionFromName(String champion) {
		HexDeckCard ret = new HexDeckCard();
		ret.setName(champion);
		return ret;
	}

	public List<HexDeckCard> generateCardListFromJSONMessage(List<Card> jsonCards) {
		Map<String, HexDeckCard> temp = new HashMap<>();
		for (Card jsonCard : jsonCards) {
			//Card already in map
			if (temp.containsKey(jsonCard.getGuid().getGuid())) {
				temp.get(jsonCard.getGuid().getGuid())
						.setQuantity(temp.get(jsonCard.getGuid().getGuid()).getQuantity() + 1);
			}
			//Card not in map
			else {
				HexDeckCard card = new HexDeckCard();
				card.setQuantity(1);
				card.setImageUrl("https://battleshopper.com/images/product/large/"+jsonCard.getGuid().getGuid()+".png");
				if (getCardMap().containsKey(jsonCard.getGuid().getGuid())) {
					card.setName(getCardMap().get(jsonCard.getGuid().getGuid()).getName());
				}
				else {
					card.setName("[GUID not found]");
				}
				
				temp.put(jsonCard.getGuid().getGuid(), card);
			}
		}

		return temp.values().stream().collect(Collectors.toList());
	}

	@Override
	public HexDeck getDeckFromUser(String user) {
		return getDeckMap().get(user);
	}

	public Map<String, HexCard> getCardMap() {
		return cardMap;
	}

	public void setCardMap(Map<String, HexCard> cardMap) {
		this.cardMap = cardMap;
	}

	public Map<String, HexDeck> getDeckMap() {
		return deckMap;
	}

	public void setDeckMap(Map<String, HexDeck> deckMap) {
		this.deckMap = deckMap;
	}
}
