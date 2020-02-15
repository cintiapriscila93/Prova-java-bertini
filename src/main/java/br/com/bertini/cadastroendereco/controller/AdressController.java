package br.com.bertini.cadastroendereco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bertini.cadastroendereco.domain.AddressDto;
import br.com.bertini.cadastroendereco.service.AdressService;



@RestController
@RequestMapping("/endereco")
public class AdressController {

	@Autowired
	AdressService adressService;

	@PostMapping("/{cep}")
	public void createAdress(@PathVariable(value = "cep") String cep) {
		adressService.createAdress(cep);
	}
	
	@GetMapping()
	public List<AddressDto> listAll(String cep){
		return adressService.listAll(cep);
	}
	
	@GetMapping("/{cep}")
	public AddressDto findbycep(@PathVariable(value = "cep") String cep) {
		return adressService.findbycep(cep);
	}

	@DeleteMapping("/{cep}")
	public void deleteAddress(@PathVariable(value = "cep") String cep) {
		adressService.deleteAddress(cep);
	}
}
