package com.dj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Main {

	public static void main(String[] args) {
		try {

			// weblogic »·¾³ÏÂÊ¹ÓÃ
			Hashtable ht = new Hashtable();
			ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			ht.put(Context.PROVIDER_URL, "t3://192.168.1.66:7001");
			ht.put(Context.SECURITY_PRINCIPAL, "weblogic");// ÓÃ»§Ãû
			ht.put(Context.SECURITY_CREDENTIALS, "p@ssw0rd");// ÃÜÂë

			Context ctx;
			ctx = new InitialContext(ht);

			DataSource source = (DataSource) ctx.lookup("test");
			Connection connection = source.getConnection();
			String sql = "select name from user where id = 1";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("name"));

				System.out.println(55555);

				System.out.println(444444);

				System.out.println(33333333);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
