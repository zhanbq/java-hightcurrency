package javatuning.ch2.buffer;


public class HeavyMethodDemo {
	public String heavyMethod(int num) {
		int i;
		StringBuffer sb = new StringBuffer();
		boolean flag = false;
		for (i = 2; i <= num; i++) {

			if (flag == true) {
				sb.append("*");
				flag = false;
			}
			if (num % i == 0) {
				sb.append(i);
				flag = true;
				num = num / i;
				while (num % i == 0) {
					num = num / i;

					if (flag == true) {
						sb.append("*");
						flag = false;
					}
					sb.append(i);
					flag = true;

				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		HeavyMethodDemo y = new HeavyMethodDemo();
		System.out.println(y.heavyMethod(100));
		System.out.println(Integer.MAX_VALUE-1);
	}

}
