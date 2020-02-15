package br.com.bertini.cadastroendereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bertini.cadastroendereco.domain.AddressEntity;

public interface AddressRepositoryData extends JpaRepository<AddressEntity, Long> {
	
	public AddressEntity findByCep(String cep);
	public AddressEntity removeByCep(String cep);

}
