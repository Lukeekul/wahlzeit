package org.wahlzeit.model;

import org.wahlzeit.model.Photo;
import org.wahlzeit.annotation.PatternInstance;

@PatternInstance(
	patternName = "Factory",
	participants = {
		"AbstractProduct",
		"ConcreteProduct"
	}
)
public class PatternPhoto extends Photo {

	public PatternPhoto() {
		super();
	}

	public PatternPhoto(PhotoId myId) {
		super(myId);
	}
	
}
