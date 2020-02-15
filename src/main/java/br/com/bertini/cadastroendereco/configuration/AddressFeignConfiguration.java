package br.com.bertini.cadastroendereco.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.bertini.cadastroendereco.repository.AddressRepositoryApi;
import feign.Feign;
import feign.Logger.Level;
import feign.Request.Options;
import feign.form.FormEncoder;
import feign.gson.GsonDecoder;

@Configuration
public class AddressFeignConfiguration {
	
	@Value(value = "${endereco.endpoint}")
	private String enderecoEndpoint;
	
	@Bean
	public AddressRepositoryApi cepClient() {
		
		return Feign.builder().encoder(new FormEncoder())
				.decoder (new GsonDecoder())
				.options(new Options(2000, 2000))
				.logger(new feign.Logger.ErrorLogger())
				.logLevel(Level.FULL)
				.target(AddressRepositoryApi.class, enderecoEndpoint);
		
	}
	
}
