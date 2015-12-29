package com.darichey.chroma4j;

public class Chroma4J {
	private static Chroma4J instance;

	private Chroma4J() {}

	public static Chroma4J getInstance() {
		if (instance == null) {
			instance = new Chroma4J();
		}
		return instance;
	}
}
