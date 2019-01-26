package org.wahlzeit.model;

import org.wahlzeit.model.Photo;
import org.wahlzeit.annotation.PatternInstance;
import org.wahlzeit.model.Pattern;
import org.wahlzeit.model.PatternManager;

@PatternInstance(
	patternName = "Factory",
	participants = {
		"AbstractProduct",
		"ConcreteProduct"
	}
)
public class PatternPhoto extends Photo {
	private Pattern m_type = null;

	public PatternPhoto(String typename) {
		super();
		//m_type  = PatternManager.createPattern(typename);
	}

	public PatternPhoto(PhotoId myId, String typename) {
		super(myId);
		m_type  = PatternManager.createPattern(typename);
	}

	public String getTypeAsString() {
		return m_type.getType().getTypeAsString();
	}
};
