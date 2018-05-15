package javatuning.ch2.buffer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.junit.Test;

public class FileWriterBufferTest {
	public static final int CIRCLE=100000;
	@Test
	public void testFileWriter() throws IOException {
		Writer writer = new FileWriter(new File("file.txt"));
		long begin=System.currentTimeMillis();
		for (int i = 0; i < CIRCLE; i++) {
			writer.write(i);
		}
		writer.close();
		System.out.println("testFileWriter spend:"+(System.currentTimeMillis()-begin));
	}
	
	@Test
	public void testFileWriterBuffer() throws IOException {
		Writer writer = new BufferedWriter(new FileWriter(new File("file.txt")));
		long begin=System.currentTimeMillis();
		for (int i = 0; i < CIRCLE; i++) {
			writer.write(i);
		}
		writer.close();
		System.out.println("testFileWriterBuffer spend:"+(System.currentTimeMillis()-begin));
		
	}
	
	
}
