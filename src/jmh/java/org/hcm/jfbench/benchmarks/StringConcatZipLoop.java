package org.hcm.jfbench.benchmarks;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.infra.Blackhole;

public class StringConcatZipLoop {

	static final int STRING_ARRAY_LENGTH = 1_000;
	static List<String> STRING_LIST = new ArrayList<>();
	static {
		final StringBuilder loge = new StringBuilder(256);
		for (int i = 0; i < STRING_ARRAY_LENGTH; i++) {
			loge.append(UUID.randomUUID().toString()).append(' ').
					append(UUID.randomUUID().toString()).append(' ').
					append(UUID.randomUUID().toString());
			STRING_LIST.add(loge.toString());
		}
	}

	@State(Scope.Thread)
	public static class StreamHolder {
		ZipOutputStream zipOutputStream;

		@Setup(Level.Iteration)
		public void setup() {
			zipOutputStream	= new ZipOutputStream(new DummyOutputStream());
		}

		@TearDown(Level.Iteration)
		public void tearDown() {
			try {
				zipOutputStream.close();
			} catch (IOException ignore) {
				// ignored as we do not care
			}
		}

	}

	@Benchmark
	public void testLoopWithConcat(StreamHolder streamHolder, Blackhole blackhole) throws IOException {
		Iterator<String> stringI = STRING_LIST.iterator();
		streamHolder.zipOutputStream.putNextEntry(new ZipEntry("test"));

		while (stringI.hasNext()) {
			String entryWithNewline = stringI.next() + System.lineSeparator();
			byte[] entryBytes = entryWithNewline.getBytes();
			streamHolder.zipOutputStream.write(entryBytes);
		}
		blackhole.consume(streamHolder.zipOutputStream);
	}

	@Benchmark
	public void testLoopWithDoubleWrite(StreamHolder streamHolder, Blackhole blackhole) throws IOException {
		Iterator<String> stringI = STRING_LIST.iterator();
		streamHolder.zipOutputStream.putNextEntry(new ZipEntry("test"));

		while (stringI.hasNext()) {
			String entryWithNewline = stringI.next() + System.lineSeparator();
			byte[] entryBytes = entryWithNewline.getBytes();
			streamHolder.zipOutputStream.write(entryBytes);
			streamHolder.zipOutputStream.write(System.lineSeparator().getBytes());
		}
		blackhole.consume(streamHolder.zipOutputStream);
	}


	static class DummyOutputStream extends OutputStream {
		@Override public void write(byte[] b) throws IOException {
		}

		@Override public void write(byte[] b, int off, int len) throws IOException {
		}

		@Override public void flush() throws IOException {
		}

		@Override public void close() throws IOException {
		}

		@Override public void write(int b) throws IOException {
		}
	}

}
