package com.amiaka;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.amiaka.BitCoinService.BitCoinService;

@Controller
public class HomController {

	private final BitCoinService bitcoinService;
	
	public HomController(BitCoinService bitcoinService) {
		super();
		this.bitcoinService = bitcoinService;
	}

	@GetMapping("/getBitCoint")
	public String GetBitCoinPrice(Model model) {
	double price = bitcoinService.getBitcoinPrice();
	model.addAttribute("btcPrice", price);
	return "Home";
		}
	
}
