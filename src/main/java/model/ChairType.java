package main.java.model;

public enum ChairType {
	
	DEFAULT(1),
	OBSESITY(2),
	DISABILITY(3);
	
	private final int code;
	
	ChairType (int code) {
		this.code = code;
	}
	
	
	public int getCode() {
		return this.code;
	}
	
	public ChairType fromCode(int code) {
		for (ChairType type : ChairType.values()) {
			if (type.getCode() == code)
				return type;
		}

		throw new IllegalArgumentException("No constant with code: " + code);
	}
}
