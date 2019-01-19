package org.wahlzeit.model;

import org.wahlzeit.model.Pattern;
import org.wahlzeit.model.PatternType;

import java.util.HashMap;

public class PatternManager {
	private HashMap<Integer, Pattern> m_patterns = new HashMap<Integer, Pattern>();
	protected int m_latestId  = 0;

	public Pattern createPattern(String typename) {
		/*assert valid typename here*/
		PatternType pt = getPatternType(typename);
		int pid = generateId();
		Pattern result = pt.createInstance(pid);
		m_patterns.put(result.getId(), result);
		return result;
	}

	public PatternType getPatternType(String typename) {
		return new PatternType(typename);
	}

	protected int generateId(){
		return m_latestId++;
	}
};
