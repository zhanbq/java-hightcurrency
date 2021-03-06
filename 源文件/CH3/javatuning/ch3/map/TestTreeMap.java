package javatuning.ch3.map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class TestTreeMap {
	Map map;

	public static class Student implements Comparable<Student> {
		public Student(String name, int s) {
			this.name = name;
			this.score = s;
		}

		String name;
		int score;

		@Override
		public int compareTo(Student o) {
			if (o.score < this.score)
				return 1;
			else if (o.score > this.score)
				return -1;
			return 0;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("name:");
			sb.append(name);
			sb.append("  ");
			sb.append("score:");
			sb.append(score);
			return sb.toString();
		}
	}

	public static class StudentDetailInfo {
		Student s;

		public StudentDetailInfo(Student s) {
			// 建立相关学生的详细信息
			this.s = s;
		}

		@Override
		public String toString() {
			return s.name + "'s detail infomation";
		}
	}

	public void initMap() {
		map = new TreeMap();
		Student s1 = new Student("Billy", 70);
		Student s2 = new Student("David", 85);
		Student s3 = new Student("Kite", 92);
		Student s4 = new Student("Cissy", 68);
		map.put(s1, new StudentDetailInfo(s1));
		map.put(s3, new StudentDetailInfo(s3));
		map.put(s2, new StudentDetailInfo(s2));
		map.put(s4, new StudentDetailInfo(s4));
	}

	@Test
	public void testOrderKey() {
		initMap();
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			Student key = (Student) iterator.next();
			System.out.println(key + "->" + map.get(key));
		}
	}

	@Test
	public void testSubMap() {// 建立学生的基本信息
		map = new TreeMap();
		Student s1 = new Student("Billy", 70);
		Student s2 = new Student("David", 85);
		Student s3 = new Student("Kite", 92);
		Student s4 = new Student("Cissy", 68);
		map.put(s1, new StudentDetailInfo(s1));
		map.put(s3, new StudentDetailInfo(s3));
		map.put(s2, new StudentDetailInfo(s2));
		map.put(s4, new StudentDetailInfo(s4));

		// 筛选出成绩介于Cissy和David之间的所有学生
		Map map1 = ((TreeMap) map).subMap(s4, s2);
		for (Iterator iterator = map1.keySet().iterator(); iterator.hasNext();) {
			Student key = (Student) iterator.next();
			System.out.println(key + "->" + map1.get(key));
		}
		System.out.println("subMap end");

		// 筛选出成绩低于Billy的学生
		map1 = ((TreeMap) map).headMap(s1);
		for (Iterator iterator = map1.keySet().iterator(); iterator.hasNext();) {
			Student key = (Student) iterator.next();
			System.out.println(key + "->" + map1.get(key));
		}
		System.out.println("headMap end");

		// 筛选出成绩大于等于Billy的学生
		map1 = ((TreeMap) map).tailMap(s1);
		for (Iterator iterator = map1.keySet().iterator(); iterator.hasNext();) {
			Student key = (Student) iterator.next();
			System.out.println(key + "->" + map1.get(key));
		}
		System.out.println("tailMap end");
	}
}
