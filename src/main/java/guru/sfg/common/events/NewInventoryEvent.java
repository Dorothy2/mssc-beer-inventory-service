package guru.sfg.common.events;

import guru.sfg.common.web.model.BeerDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {

	public NewInventoryEvent(BeerDto beerDto) {
		super(beerDto);
	}
	

}

