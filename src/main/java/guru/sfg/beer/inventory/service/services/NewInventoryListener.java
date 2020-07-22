package guru.sfg.beer.inventory.service.services;

import javax.jms.Destination;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import guru.sfg.beer.inventory.service.config.JmsConfig;
import guru.sfg.beer.inventory.service.domain.BeerInventory;
import guru.sfg.common.events.NewInventoryEvent;
import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import guru.sfg.common.web.model.BeerDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewInventoryListener {
	
	private final BeerInventoryRepository beerInventoryRepository;

	@Transactional
	@JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
	public void listen(NewInventoryEvent event) {
		
		log.debug("Got inventory: " + event.toString());
		BeerDto beerDto = event.getBeerDto();
		
		beerInventoryRepository.save(BeerInventory.builder()
			.beerId(beerDto.getId())
			.upc(beerDto.getUpc())
			.quantityOnHand(beerDto.getQuantityOnHand())
			.build()
		);
		
	}
}
