package com.darichey.chroma4j;

import java.io.*;

public class Chroma4J {
	private static Chroma4J instance;
	public boolean isDLLLoaded = false;

	private Chroma4J() {}

	public static Chroma4J getInstance() {
		if (instance == null) {
			instance = new Chroma4J();
		}
		return instance;
	}

	public void setupDLLDir() {
		InputStream dllStream = getClass().getClassLoader().getResourceAsStream(Reference.NAME + ".dll");
		FileOutputStream fos = null;
		try {
			File tmp = File.createTempFile(Reference.NAME, ".tmp");
			fos = new FileOutputStream(tmp);
			byte[] buf = new byte[1024];
			int r = dllStream.read(buf);
			while (r != -1) {
				fos.write(buf, 0, r);
				r = dllStream.read(buf);
			}
			fos.close();
			System.load(tmp.getAbsolutePath());
			isDLLLoaded = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
