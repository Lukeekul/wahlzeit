package org.wahlzeit.model;

import org.wahlzeit.model.PatternType;

public class Pattern {
	protected PatternType m_patternType = null;
	protected int m_id = 0;

	public Pattern(PatternType patternType, int id) {
		m_patternType = patternType;
		m_id = id;
	}

	public int getId() {
		return m_id;
	}
};
