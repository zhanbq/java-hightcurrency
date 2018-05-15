package javatuning.ch5.tuning;

/**
 * -XX:+PrintGCDetails -Xmx20M -Xms20M
 * 
[GC [DefNew: 273K->128K(1408K), 0.0015069 secs] 273K->151K(20352K), 0.0015577 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC [DefNew: 1152K->0K(1408K), 0.0019740 secs] 1175K->1175K(20352K), 0.0020433 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC [DefNew: 1024K->0K(1408K), 0.0016379 secs] 2199K->2199K(20352K), 0.0017052 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC [DefNew: 1024K->0K(1408K), 0.0017293 secs] 3223K->3223K(20352K), 0.0017810 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 1408K, used 1049K [0x255e0000, 0x25760000, 0x25760000)
  eden space 1280K,  82% used [0x255e0000, 0x256e66e0, 0x25720000)
  from space 128K,   0% used [0x25720000, 0x25720000, 0x25740000)
  to   space 128K,   0% used [0x25740000, 0x25740000, 0x25760000)
 tenured generation   total 18944K, used 3223K [0x25760000, 0x269e0000, 0x269e0000)
   the space 18944K,  17% used [0x25760000, 0x25a85e58, 0x25a86000, 0x269e0000)
 compacting perm gen  total 12288K, used 362K [0x269e0000, 0x275e0000, 0x2a9e0000)
   the space 12288K,   2% used [0x269e0000, 0x26a3a880, 0x26a3aa00, 0x275e0000)
    ro space 8192K,  67% used [0x2a9e0000, 0x2af42d98, 0x2af42e00, 0x2b1e0000)
    rw space 12288K,  53% used [0x2b1e0000, 0x2b850640, 0x2b850800, 0x2bde0000)

-XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn6M

Heap
 def new generation   total 5568K, used 4559K [0x255e0000, 0x25be0000, 0x25be0000)
  eden space 4992K,  91% used [0x255e0000, 0x25a53f58, 0x25ac0000)
  from space 576K,   0% used [0x25ac0000, 0x25ac0000, 0x25b50000)
  to   space 576K,   0% used [0x25b50000, 0x25b50000, 0x25be0000)
 tenured generation   total 14336K, used 0K [0x25be0000, 0x269e0000, 0x269e0000)
   the space 14336K,   0% used [0x25be0000, 0x25be0000, 0x25be0200, 0x269e0000)
 compacting perm gen  total 12288K, used 362K [0x269e0000, 0x275e0000, 0x2a9e0000)
   the space 12288K,   2% used [0x269e0000, 0x26a3a880, 0x26a3aa00, 0x275e0000)
    ro space 8192K,  67% used [0x2a9e0000, 0x2af42d98, 0x2af42e00, 0x2b1e0000)
    rw space 12288K,  53% used [0x2b1e0000, 0x2b850640, 0x2b850800, 0x2bde0000)


 * @author Administrator
 *
 */
public class PutInEden {
	public static void main(String args[]){
		byte[] b1,b2,b3,b4;
		b1=new byte[1024*1024];
		b2=new byte[1024*1024];
		b3=new byte[1024*1024];
		b4=new byte[1024*1024];
	}
}
