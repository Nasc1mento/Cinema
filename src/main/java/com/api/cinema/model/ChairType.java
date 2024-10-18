package com.api.cinema.model;

import java.util.HashMap;
import java.util.Map;

public enum ChairType {

	DEFAULT(1), //
	OBESITY(2), //
	DISABILITY(3);

	private final int code;
	private final static Map<Integer, ChairType> values = new HashMap<Integer, ChairType>(ChairType.values().length);

	static {
		for (ChairType chairType : ChairType.values())
			values.put(chairType.code, chairType);
	}

	private ChairType(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public static ChairType fromCode(int code) {
		ChairType chairType = values.get(code);

		if (chairType == null)
			throw new IllegalArgumentException("Invalid code: " + code);

		return chairType;
	}

}
