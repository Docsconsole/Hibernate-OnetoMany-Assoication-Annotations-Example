package com.docsconsole.tutorials.hibernate5;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.docsconsole.tutorials.hibernate5.entity.Author;
import com.docsconsole.tutorials.hibernate5.entity.Book;
import com.docsconsole.tutorials.hibernate5.util.HibernateUtil;

public class MainClient {
	public static void main(String[] args) {

		System.out.println("Main method@MainClient");

		// obtains the session
		Author author = new Author();
		author.setAuthorName("Vladimir Nabokov");

		Book book1 = new Book("Vladimir Nabokov", 100.0, author);
		Book book2 = new Book("Vladimir Nabokov", 200.0, author);
		Book book3 = new Book("Vladimir Nabokov", 300.0, author);

		Set<Book> books = new HashSet<Book>();
		books.add(book1);
		books.add(book2);
		books.add(book3);

		author.setBooks(books);

		try {

			// Get Session
			Session session = HibernateUtil.getSessionFactory().openSession();

			System.out.println("Session created");
			// start transaction
			Transaction tx = session.beginTransaction();

			// Save the Model objects
			session.save(author);
			session.save(book1);
			session.save(book2);
			session.save(book3);

			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}