package br.com.bertini.cadastroendereco.converter;

import java.util.function.Function;

import br.com.bertini.cadastroendereco.domain.AddressDto;
import br.com.bertini.cadastroendereco.domain.AddressEntity;

public class ConvertAddressDto implements Function <AddressDto, AddressEntity>{
	
	@Override
	public AddressEntity apply(AddressDto addressDto) {
		
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setBairro(addressDto.getBairro());
		addressEntity.setCep(addressDto.getCep());
		addressEntity.setLocalidade(addressDto.getLocalidade());
		addressEntity.setLogradouro(addressDto.getLogradouro());
		addressEntity.setUf(addressDto.getUf());
		
		return addressEntity;
		
		
	}

}
