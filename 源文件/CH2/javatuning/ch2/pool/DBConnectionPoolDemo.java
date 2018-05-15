package javatuning.ch2.pool;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

public final class DBConnectionPoolDemo {

	public static Object getInnter(Object con){
		Object re=null;
		Field f;
		try {
			f = con.getClass().getDeclaredField("inner");
			f.setAccessible(true);
			re= f.get(con);
			f.setAccessible(false);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return re;
	}
	
	public static void main(String[] argv) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DataSource unpooled = DataSources
					.unpooledDataSource(
							"jdbc:mysql://127.0.0.1:3306/test",
							"root", "");
			DataSource pooled = DataSources.pooledDataSource(unpooled);
			//DataSource pooled =unpooled;
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;

			con = pooled.getConnection();
			System.out.println("con Class Type is:"+con.getClass().getName());
			Object o1=getInnter(con);
			System.out.println("Inner con Class Type is:"+o1.getClass().getName());
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user");
			while (rs.next())
				System.out.println("Data from DB:"+rs.getString(1));
			rs.close();
			stmt.close();
			con.close();
			
			Thread.sleep(1000);
			con = pooled.getConnection();
			Object o2=getInnter(con);
			if(o1==o2)
				System.out.println("o1 and o2 is same object.");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user");
			while (rs.next())
				System.out.println("Data from DB:"+rs.getString(1));
			rs.close();
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void attemptClose(ResultSet o) {
		try {
			if (o != null)
				o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void attemptClose(Statement o) {
		try {
			if (o != null)
				o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void attemptClose(Connection o) {
		try {
			if (o != null)
				o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private DBConnectionPoolDemo() {
	}
}