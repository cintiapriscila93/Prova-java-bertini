package br.com.bertini.cadastroendereco.repository;

import br.com.bertini.cadastroendereco.domain.AddressDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers("Content-Type:application/x-www-form-urlencoded")
public interface AddressRepositoryApi {
	@RequestLine("GET ws/{cep}/json")
	AddressDto getEndereco(@Param(value = "cep") String cep);

}