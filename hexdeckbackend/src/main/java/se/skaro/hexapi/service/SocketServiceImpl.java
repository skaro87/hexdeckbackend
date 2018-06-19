package se.skaro.hexapi.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import se.skaro.hexapi.model.data.HexDeck;

@Component
public class SocketServiceImpl implements SocketService {
	
	 @Autowired
	 private SimpMessagingTemplate template;
	 
	 private Map<String, String> channelMap = new HashMap<>();
	 
	 @PostConstruct
	 public void init() {
		 
	 }
	 
	 @Override
	 public void sendMessage(String hexIGN, HexDeck deck) {
		 if (channelMap.containsKey(hexIGN)){
			 template.convertAndSend("/deck-socket/"+channelMap.get(hexIGN), deck);			 
		 }
	 }

	@Override
	public void saveUser(String channelName, String hexIGN) {
		channelMap.put(hexIGN, channelName);
		
	}

	@Override
	public String getUser(String channel) {
		for (Map.Entry<String, String> entry : channelMap.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    if (value.equals(channel)){
		    	return key;		    	
		    }
		}
		return null;
	}
}
