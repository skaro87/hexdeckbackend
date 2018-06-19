package se.skaro.hexapi.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import se.skaro.hexapi.model.json.ApiMessage;
import se.skaro.hexapi.model.json.SaveDeckMessage;
import se.skaro.hexapi.service.HexService;
import se.skaro.hexapi.service.SocketService;

@RestController
public class HEXListener {

	@Autowired
	private HexService hexService;
	
	@Autowired
	private SocketService socketService;
	
	@PostMapping("/")
	public void handleMessage(@RequestBody ApiMessage message) {
		hexService.handleHEXApiMessage(message);
		if (message instanceof SaveDeckMessage) {
			socketService.sendMessage(((SaveDeckMessage) message).getUser().toLowerCase(), hexService.getDeckFromUser(((SaveDeckMessage) message).getUser().toLowerCase()));			
		}
	}
	
	@PostMapping("/config/{channel}/{user}")
	public ResponseEntity<String> saveIGN (@PathVariable("channel") String channel, @PathVariable("user") String hexIGN) {
		socketService.saveUser(channel, hexIGN);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/config/{channel}")
	public ResponseEntity<String> getUser(@PathVariable("channel") String channel) {
		return new ResponseEntity<>(socketService.getUser(channel), HttpStatus.OK);
	}
	
	@GetMapping("/accepts.txt")
	public String accept() {
		return "SaveDeck";
	}

}
