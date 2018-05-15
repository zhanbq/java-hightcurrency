package javatuning.ch5.tuning;


/**
 * -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=2
 [GC [DefNew: 4947K->663K(7680K), 0.0088888 secs] 4947K->4759K(17920K), 0.0089497 secs] [Times: user=0.00 sys=0.02, real=0.02 secs] 
[GC [DefNew: 4759K->663K(7680K), 0.0021360 secs] 8855K->4759K(17920K), 0.0021855 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 7680K, used 4862K [0x255e0000, 0x25fe0000, 0x25fe0000)
  eden space 5120K,  82% used [0x255e0000, 0x259f9a10, 0x25ae0000)
  from space 2560K,  25% used [0x25ae0000, 0x25b85e08, 0x25d60000)
  to   space 2560K,   0% used [0x25d60000, 0x25d60000, 0x25fe0000)
 tenured generation   total 10240K, used 4096K [0x25fe0000, 0x269e0000, 0x269e0000)
   the space 10240K,  40% used [0x25fe0000, 0x263e0010, 0x263e0200, 0x269e0000)
 compacting perm gen  total 12288K, used 362K [0x269e0000, 0x275e0000, 0x2a9e0000)
   the space 12288K,   2% used [0x269e0000, 0x26a3a888, 0x26a3aa00, 0x275e0000)
    ro space 8192K,  67% used [0x2a9e0000, 0x2af42d98, 0x2af42e00, 0x2b1e0000)
    rw space 12288K,  53% used [0x2b1e0000, 0x2b850640, 0x2b850800, 0x2bde0000)

 
 
 
 -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=2 -XX:MaxTenuringThreshold=1
 [GC [DefNew: 4947K->663K(7680K), 0.0083661 secs] 4947K->4759K(17920K), 0.0084944 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC [DefNew: 4759K->0K(7680K), 0.0025221 secs] 8855K->4759K(17920K), 0.0025799 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 7680K, used 4198K [0x255e0000, 0x25fe0000, 0x25fe0000)
  eden space 5120K,  82% used [0x255e0000, 0x259f9a10, 0x25ae0000)
  from space 2560K,   0% used [0x25ae0000, 0x25ae0000, 0x25d60000)
  to   space 2560K,   0% used [0x25d60000, 0x25d60000, 0x25fe0000)
 tenured generation   total 10240K, used 4759K [0x25fe0000, 0x269e0000, 0x269e0000)
   the space 10240K,  46% used [0x25fe0000, 0x26485e18, 0x26486000, 0x269e0000)
 compacting perm gen  total 12288K, used 362K [0x269e0000, 0x275e0000, 0x2a9e0000)
   the space 12288K,   2% used [0x269e0000, 0x26a3a888, 0x26a3aa00, 0x275e0000)
    ro space 8192K,  67% used [0x2a9e0000, 0x2af42d98, 0x2af42e00, 0x2b1e0000)
    rw space 12288K,  53% used [0x2b1e0000, 0x2b850640, 0x2b850800, 0x2bde0000)

 *
 */
public class MaxTenuringThreshold {
	public static void main(String args[]){
		byte[] b1,b2,b3;
		b1=new byte[1024*512];
		b2=new byte[1024*1024*4];
		b3=new byte[1024*1024*4];
		b3=null;
		b3=new byte[1024*1024*4];
	}
}
