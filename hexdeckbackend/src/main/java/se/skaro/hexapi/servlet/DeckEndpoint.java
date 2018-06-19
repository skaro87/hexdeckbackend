package se.skaro.hexapi.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.skaro.hexapi.model.data.HexDeck;
import se.skaro.hexapi.service.HexService;

@RestController()
@RequestMapping("/api/deck")
public class DeckEndpoint {
	
	@Autowired
	private HexService hexService;
	
	@GetMapping("/{user}")
	public ResponseEntity<HexDeck> getDeckFromUser(@PathVariable("user") String user) {
		HexDeck ret = hexService.getDeckFromUser(user);
		if (ret != null) {
			return new ResponseEntity<>(ret, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
