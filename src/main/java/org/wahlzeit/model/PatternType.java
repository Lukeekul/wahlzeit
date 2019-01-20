package org.wahlzeit.model;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import org.wahlzeit.model.Pattern;

public class PatternType {
	private String m_name;
	protected PatternType m_superType = null;
	protected Set<PatternType> m_subTypes = new HashSet<PatternType>();


	public PatternType(String typename) {
		m_name = typename;
	}
	public Pattern createInstance(int id) {
		return new Pattern(this, id);
	}

	public PatternType getSuperType() {
		return m_superType;
	}

	public Iterator<PatternType> getSubTypeIterator() {
		return m_subTypes.iterator();
	}

	public void setSuperType(PatternType pt) {
		assert(pt != null): "Tryied to set null object as SuperType";
		m_superType = pt;
	}

	public void addSubType(PatternType pt) {
		assert(pt != null): "Tryied to set null sub-type";
		pt.setSuperType(this);
		m_subTypes.add(pt);
	}

	public boolean hasInstance(Pattern pattern) {
		assert(pattern != null): "Tryied to ask from null object";
		boolean result = false;
		if(pattern.getType() == this) {
			result = true;
		} else {
			for(PatternType type : m_subTypes) {
				if(type.hasInstance(pattern)){
					result = true;
				}
			}
		}
		return result;
	}

	public boolean isSubtype() {
		boolean result = false;
		if(m_superType != null) {
			result = true;
		}
		return result;
	}

	public String getTypeAsString(){
		return m_name;
	}
};
