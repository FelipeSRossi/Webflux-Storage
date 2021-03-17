package com.Storage.Webflux.Storage;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.Storage.Webflux.Storage.document.Character;
import com.Storage.Webflux.Storage.repository.MainRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import static com.Storage.Webflux.Storage.constants.MainConstants.MAIN_ENDPOINT_LOCAL;


@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class WebfluxStorageApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	MainRepository mainRepository;


	@Test
	public void getOneCharacterById(){

		webTestClient.get().uri(MAIN_ENDPOINT_LOCAL.concat("/{id}"),"3")
				.exchange()
				.expectStatus().isOk()
				.expectBody();


	}

	@Test
	public void getOneCharacterNotFound(){

		webTestClient.get().uri(MAIN_ENDPOINT_LOCAL.concat("/{id}"),"10")
				.exchange()
				.expectStatus().isNotFound();

	}


	@Test
	public void deleteCharacter(){

		webTestClient.delete().uri(MAIN_ENDPOINT_LOCAL.concat("/{id}"),"1")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);

	}

}
