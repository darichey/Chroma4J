package com.darichey.chroma4j.razer;

import com.darichey.chroma4j.Chroma4J;
import com.darichey.chroma4j.wrapper.NativeWrapper;

import java.awt.*;

public class Keyboard {
	public static final int ROWS = 6;
	public static final int COLUMNS = 22;
	public static final int NUM_KEYS = ROWS * COLUMNS;

	public boolean setKeyColor(int row, int column , Color color) {
		if (!Chroma4J.isDLLLoaded) throw new IllegalStateException("Something has gone horribly wrong.");
		return NativeWrapper.setKeyColor(row, column, color.getRed(), color.getGreen(), color.getBlue());
	}

	public void setAllColor(Color color) {
		for (int row = 0; row < ROWS; row++) {
			for (int column = 0; column < COLUMNS; column++) {
				setKeyColor(row, column, color);
			}
		}
	}

	public enum EFFECT_TYPE {
		NONE,
		BREATHING,
		CUSTOM,
		REACTIVE,
		STATIC,
		SPECTRUMCYCLING,
		WAVE,
		INVALID
	}
}
