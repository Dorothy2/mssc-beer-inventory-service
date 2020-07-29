package guru.sfg.brewery.model.events;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {

	public NewInventoryEvent(BeerDto beerDto) {
		super(beerDto);
	}
	

}

