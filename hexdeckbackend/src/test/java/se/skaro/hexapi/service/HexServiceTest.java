package se.skaro.hexapi.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import se.skaro.hexapi.model.data.HexDeck;
import se.skaro.hexapi.model.data.HexDeckCard;
import se.skaro.hexapi.model.json.Card;
import se.skaro.hexapi.model.json.Gem;
import se.skaro.hexapi.model.json.ItemGUID;
import se.skaro.hexapi.model.json.SaveDeckMessage;

public class HexServiceTest {

	private HexServiceImpl hexService = new HexServiceImpl();
	
	@Before
	public void init() {
		hexService = new HexServiceImpl();
		hexService.loadCards();
	}
	
	@Test
	public void cardsLoadedTest() {
		assertNotNull(hexService.getCardMap().get("8eebaeb5-5ff9-48c2-ae2f-2edf2f7cad59"));
		assertEquals("Abominate", hexService.getCardMap().get("8eebaeb5-5ff9-48c2-ae2f-2edf2f7cad59").getName());
	}
	
	@Test
	public void parseDeckTest() {
		List<Card> deck = new ArrayList<>();
		deck.addAll(createCard("21adcfd6-da0e-4f9e-8025-b9c3f662622a", 1));
		deck.addAll(createCard("329b0797-90ac-45d1-9760-75376406e4f8", 1));
		deck.addAll(createCard("2aff424e-8262-4106-9498-3d62a0b07a3e", 2));
		deck.addAll(createCard("97ca695d-325b-4b52-ab04-b44ef50d9830", 1));
		deck.addAll(createCardSingleGem("16c13304-bc0f-455c-8b7b-d0d35b59fdb1", 4, "Major Ruby of Twinstrike", "852e3aa9-25c0-49ed-bd42-b6e508327f1e")); //Mordroms Gift (Add gems!)
		deck.addAll(createCard("93f7ca23-4855-47f3-8b9e-e41805d75981", 4));
		deck.addAll(createCard("d0b768f5-7c2a-4753-86af-8934f0c3a8e7", 4));
		deck.addAll(createCard("978f6df7-ddac-4f3d-a64f-d3d901fc1346", 3));
		deck.addAll(createCard("147dabe1-9cfd-4477-bca9-096ef052ae1b", 2));
		deck.addAll(createCard("4b9a28fc-d67b-45b2-9cf3-f0fc00de1ead", 4));
		deck.addAll(createCard("17f3ed3d-26aa-40fc-a628-55e3dcb567f4", 4));
		deck.addAll(createCard("7b4130f7-3910-4d8c-932b-11f9ecdef74e", 4));
		deck.addAll(createCard("1d6dc6c9-1305-4cda-9402-445bb48de816", 4));
		deck.addAll(createCard("e5c399d1-6075-4977-bb96-88f0a316d52c", 4));
		deck.addAll(createCard("ad8d951e-ee34-4b65-b61d-a41ca2260be7", 4));
		deck.addAll(createCard("dda45f4a-1c9d-4ff9-b27c-9b52ac953eea", 4));
		deck.addAll(createCard("9f0abb6f-5c04-4ffa-857e-6ba05dee0288", 4));
		deck.addAll(createCard("848c21c1-f2aa-4084-8ccc-a1672b01b22c", 1));
		deck.addAll(createCard("74a2ad91-0a44-4dc2-8599-c1fd2cb3e8de", 1));
		deck.addAll(createCard("53a4c0d9-113d-4ebc-8e7e-0cb3b8b81604", 3));
		deck.addAll(createCard("f28dc8ed-11e7-46da-ba60-01138a552185", 1));
		
		List<Card> sideboard = new ArrayList<>();
		sideboard.addAll(createCard("9749c7d1-7708-478a-8e63-d86717d065f2", 2));
		sideboard.addAll(createCard("38ca5807-4bc7-4e5f-b8e7-9cb533c28fea", 3));
		sideboard.addAll(createCard("97ca695d-325b-4b52-ab04-b44ef50d9830", 2));
		sideboard.addAll(createCard("50399a8f-8565-44bb-b854-ab33f7d7e309", 2));
		sideboard.addAll(createCard("525aa0cb-5736-458d-a21c-c06651dd9091", 1));
		sideboard.addAll(createCard("36aba697-7f9b-43e9-b797-108cd1aee6a1", 3));
		sideboard.addAll(createCard("7f67fffe-8b3f-441d-adbb-ccc956a50d97", 2));
		
		SaveDeckMessage s = new SaveDeckMessage();
		s.setMessage("SaveDeck");
		s.setName("UnitTestDeck");
		s.setChampion("Cassia Goldenlight");
		s.setUser("UnitTestHEXUser");
		s.setDeck(deck);
		s.setSideboard(sideboard);
		
		hexService.handleSaveDeckMessage(s, "UnitTest");
		
		HexDeck deckOutput = hexService.getDeckFromUser("unittest");
		assertNotNull(deckOutput);
		assertEquals("UnitTestDeck", deckOutput.getName());
		assertEquals("Cassia Goldenlight", deckOutput.getChampion().getName());
		assertEquals(60, sizeOf(deckOutput.getMain()));
		assertEquals(15, sizeOf(deckOutput.getReserves()));
	}

	private int sizeOf(List<HexDeckCard> cards) {
		int ret = 0;
		for (HexDeckCard card: cards) {
			ret += card.getQuantity();
		}
		return ret;
	}

	private List<Card> createCard(String guid, int number) {
		Card card = new Card();
		ItemGUID cardGuid = new ItemGUID();
		cardGuid.setGuid(guid);
		card.setGuid(cardGuid);
		List<Card> ret = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			ret.add(card);
		}
		return ret;
	}
	
	private List<Card> createCardSingleGem(String guid, int number, String gemName, String gemUuid) {
		Card card = new Card();
		ItemGUID cardGuid = new ItemGUID();
		cardGuid.setGuid(guid);
		card.setGuid(cardGuid);
		Gem gem = new Gem();
		gem.setName(gemName);
		ItemGUID gemGuid = new ItemGUID();
		gemGuid.setGuid(gemUuid);
		List<Gem> gems = new ArrayList<>();
		gems.add(gem);
		card.setGems(gems);
		List<Card> ret = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			ret.add(card);
		}
		return ret;
	}

}
