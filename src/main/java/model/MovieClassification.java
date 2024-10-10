package main.java.model;

public enum MovieClassification {
	
	FREE(1),
	TEN_YEARS(2),
	TWELVE_YEARS(3),
	FOURTEEN_YEARS(4),
	SIXTEEN_YEARS(5),
	EIGHTEEN_YEARS(6);

	
	private final int code;
	
	private MovieClassification(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	
	public static MovieClassification fromCode(int code) {
        for (MovieClassification classification : values()) {
            if (classification.getCode() == code) {
                return classification;
            }
        }
        
        throw new IllegalArgumentException("No constant with code: " + code);
    }
}
