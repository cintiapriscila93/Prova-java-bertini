package br.com.bertini.cadastroendereco.service;

import java.util.List;

import br.com.bertini.cadastroendereco.domain.AddressDto;

public interface AdressService {
	
	public void createAdress(String cep);
	
	public List<AddressDto> listAll(String cep);

	public AddressDto findbycep(String cep);
	
	public void deleteAddress(String cep);
}
