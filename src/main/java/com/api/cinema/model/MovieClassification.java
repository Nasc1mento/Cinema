package com.api.cinema.model;

import java.util.HashMap;
import java.util.Map;

public enum MovieClassification {

	FREE(1), //
	AGE_10(2), //
	AGE_12(3), //
	AGE_14(4), //
	AGE_16(5), //
	AGE_18(6);

	private final int code;
	private static final Map<Integer, MovieClassification> values = new HashMap<Integer, MovieClassification>(
			MovieClassification.values().length);

	static {
		for (MovieClassification movieClassification : MovieClassification.values())
			values.put(movieClassification.code, movieClassification);
	}

	private MovieClassification(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public static MovieClassification fromCode(int code) {
		MovieClassification movieClassification = values.get(code);

		if (movieClassification == null)
			throw new IllegalArgumentException("Invalid code: " + code);

		return movieClassification;
	}
	
	public static int fromMovieClassification(MovieClassification movieClassification) {
		return movieClassification.code;
	}

}
