package uk.co.blackpepper.common.model;

public interface Identifiable<T> {
	
	T getId();
	
	void setId(T identifier);
}
