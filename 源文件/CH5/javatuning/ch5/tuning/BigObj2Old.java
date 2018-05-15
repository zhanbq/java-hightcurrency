package javatuning.ch5.tuning;

/**
 * -XX:+PrintGCDetails -Xmx20M -Xms20M
[GC [DefNew: 273K->128K(1408K), 0.0016809 secs] 273K->151K(20352K), 0.0017382 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 1408K, used 1177K [0x255e0000, 0x25760000, 0x25760000)
  eden space 1280K,  82% used [0x255e0000, 0x256e66e0, 0x25720000)
  from space 128K, 100% used [0x25740000, 0x25760000, 0x25760000)
  to   space 128K,   0% used [0x25720000, 0x25720000, 0x25740000)
 tenured generation   total 18944K, used 23K [0x25760000, 0x269e0000, 0x269e0000)
   the space 18944K,   0% used [0x25760000, 0x25765e68, 0x25766000, 0x269e0000)
 compacting perm gen  total 12288K, used 362K [0x269e0000, 0x275e0000, 0x2a9e0000)
   the space 12288K,   2% used [0x269e0000, 0x26a3a810, 0x26a3aa00, 0x275e0000)
    ro space 8192K,  67% used [0x2a9e0000, 0x2af42d98, 0x2af42e00, 0x2b1e0000)
    rw space 12288K,  53% used [0x2b1e0000, 0x2b850640, 0x2b850800, 0x2bde0000)
    
    -XX:+PrintGCDetails -Xmx20M -Xms20M -XX:PretenureSizeThreshold=1000000

Heap
 def new generation   total 1408K, used 298K [0x255e0000, 0x25760000, 0x25760000)
  eden space 1280K,  23% used [0x255e0000, 0x2562aba8, 0x25720000)
  from space 128K,   0% used [0x25720000, 0x25720000, 0x25740000)
  to   space 128K,   0% used [0x25740000, 0x25740000, 0x25760000)
 tenured generation   total 18944K, used 1024K [0x25760000, 0x269e0000, 0x269e0000)
   the space 18944K,   5% used [0x25760000, 0x25860010, 0x25860200, 0x269e0000)
 compacting perm gen  total 12288K, used 362K [0x269e0000, 0x275e0000, 0x2a9e0000)
   the space 12288K,   2% used [0x269e0000, 0x26a3a810, 0x26a3aa00, 0x275e0000)
    ro space 8192K,  67% used [0x2a9e0000, 0x2af42d98, 0x2af42e00, 0x2b1e0000)
    rw space 12288K,  53% used [0x2b1e0000, 0x2b850640, 0x2b850800, 0x2bde0000)

 *
 */
public class BigObj2Old {
	public static void main(String args[]){
		byte[] b1;
		b1=new byte[1024*1024];
	}
}
