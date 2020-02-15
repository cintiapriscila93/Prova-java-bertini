package br.com.bertini.cadastroendereco.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bertini.cadastroendereco.converter.ConvertAddressDto;
import br.com.bertini.cadastroendereco.converter.ConvertAddressEntity;
import br.com.bertini.cadastroendereco.domain.AddressDto;
import br.com.bertini.cadastroendereco.domain.AddressEntity;
import br.com.bertini.cadastroendereco.repository.AddressRepositoryApi;
import br.com.bertini.cadastroendereco.repository.AddressRepositoryData;
import br.com.bertini.cadastroendereco.service.AdressService;

@Service
public class AdressServiceImpl implements AdressService{

	@Autowired
	AddressRepositoryApi addressRepositoryApi;
	
	@Autowired
	AddressRepositoryData addressRepositoryData;
	
	@Override
	public void createAdress(String cep) {

		AddressDto addressDto = addressRepositoryApi.getEndereco(cep);
		
		ConvertAddressDto convertAddressDto = new ConvertAddressDto();
		
		AddressEntity AdressEntity = convertAddressDto.apply(addressDto);
		
		addressRepositoryData.save(AdressEntity);
		
		
	}
	

	@Override
	public List<AddressDto> listAll(String cep) {
		List<AddressDto> listAddressDto = new ArrayList<>(); 
		
		List<AddressEntity> listAddressEntity = addressRepositoryData.findAll();
		
		ConvertAddressEntity convertAddressEntity = new ConvertAddressEntity();
		
		listAddressEntity.forEach(addresDto -> {
			AddressDto AddressDto = convertAddressEntity.apply(addresDto);	
			listAddressDto.add(AddressDto);
		});
		
		return listAddressDto;
	}
	
	@Override
	public AddressDto findbycep(String cep) {

		AddressEntity addressEntity = addressRepositoryData.findByCep(cep);

		ConvertAddressEntity convertAddressEntity = new ConvertAddressEntity();

		AddressDto addressDto = convertAddressEntity.apply(addressEntity);

		return addressDto;
	}
	
	@Override
	public void deleteAddress(String cep) {
		
		AddressEntity addressEntity = addressRepositoryData.findByCep(cep);
					
		addressRepositoryData.delete(addressEntity);
			

	}

}
