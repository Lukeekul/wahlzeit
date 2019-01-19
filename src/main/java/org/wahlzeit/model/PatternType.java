package org.wahlzeit.model;

import org.wahlzeit.model.Pattern;

public class PatternType {
	private String name;
	
	public PatternType(String typename) {
			name = typename;
	}
	public Pattern createInstance(int id) {
		return new Pattern(this, id);
	}

};
