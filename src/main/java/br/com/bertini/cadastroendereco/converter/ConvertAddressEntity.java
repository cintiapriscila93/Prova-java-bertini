package br.com.bertini.cadastroendereco.converter;

import java.util.function.Function;

import br.com.bertini.cadastroendereco.domain.AddressDto;
import br.com.bertini.cadastroendereco.domain.AddressEntity;

public class ConvertAddressEntity implements Function <AddressEntity, AddressDto>{
	
	@Override
	public AddressDto apply(AddressEntity addressEntity) {
		
		AddressDto addressDto = new AddressDto();
		addressDto.setBairro(addressEntity.getBairro());
		addressDto.setCep(addressEntity.getCep());
		addressDto.setLocalidade(addressEntity.getLocalidade());
		addressDto.setLogradouro(addressEntity.getLogradouro());
		addressDto.setUf(addressEntity.getUf());
		
		return addressDto;
		
		
	}

}
