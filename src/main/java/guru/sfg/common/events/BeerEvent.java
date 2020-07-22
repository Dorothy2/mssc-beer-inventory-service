package guru.sfg.common.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

import guru.sfg.common.web.model.BeerDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerEvent implements Serializable {
	
	private static final long serialVersionUID = 5290417671032203893L;
	
	protected BeerDto beerDto;
	
}
