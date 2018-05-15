package javatuning.ch6.toolscheck;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.netbeans.lib.profiler.heap.HeapFactory;
import org.netbeans.modules.profiler.oql.engine.api.OQLEngine;
import org.netbeans.modules.profiler.oql.engine.api.OQLEngine.ObjectVisitor;

public class OQLPragram {
	private OQLEngine instance;

	public OQLPragram() {
	}

	@Before
	public void setUp() throws IOException, URISyntaxException {
		instance = new OQLEngine(HeapFactory.createHeap(new File(
				"d:\\heapdump-1333200344576.hprof")));
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testForEachClass() throws Exception {
		System.out.println("heap.forEachClass");
		String query = 
				"select heap.forEachClass(function(obj) { println(obj.name); })";
		instance.executeQuery(query, null);
	}

	@Test
	public void testIntResult() throws Exception {
		final boolean[] rslt = new boolean[] { true };
		instance.executeQuery("select a.toString() from java.lang.String a",
				new ObjectVisitor() {
					int i = 0;

					public boolean visit(Object o) {
						while (i < 20) {// 只显示前20个
							System.out.println(o);
							i++;
							return false;
						}
						return true;
					}
				});
	}

	@Test
	public void testMultivalue() throws Exception {
		instance.executeQuery(
				"select {content:toHtml(v),size:v.elementCount} from java.util.Vector v",
				new ObjectVisitor() {
					public boolean visit(Object o) {
						System.out.println(o);
						return false;
					}
				});
	}
}
