package com.uspehgp.springdb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.uspehgp.springdb.dao.impls.SQLiteDAO;
import com.uspehgp.springdb.dao.objects.MP3;

public class Start {

	public static void main(String[] args) {
		MP3 mp3 = new MP3();
		mp3.setName("Song name");
		mp3.setAuthor("Song author");

		// new SQLiteDAO().insertWithJDBC(mp3);

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		SQLiteDAO sqLiteDAO = (SQLiteDAO) context.getBean("sqliteDAO");

		sqLiteDAO.insert(mp3);
		
		((ConfigurableApplicationContext)context).close();// закрытие контекста вручную


	}

}
