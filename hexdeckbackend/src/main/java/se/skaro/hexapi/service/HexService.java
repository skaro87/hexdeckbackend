package se.skaro.hexapi.service;

import se.skaro.hexapi.model.data.HexDeck;
import se.skaro.hexapi.model.json.ApiMessage;

public interface HexService {
	
	void handleHEXApiMessage(ApiMessage message);

	HexDeck getDeckFromUser(String user);

}
