package se.skaro.hexapi.service;

import se.skaro.hexapi.model.data.HexDeck;

public interface SocketService {

	void sendMessage(String channel, HexDeck deck);

	void saveUser(String message, String username);

	String getUser(String channel);

}
