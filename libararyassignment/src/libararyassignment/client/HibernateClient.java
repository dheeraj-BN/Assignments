package libararyassignment.client;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import libararyassignment.orm.Article;
import libararyassignment.orm.Author;
import libararyassignment.orm.AuthorAddress;
import libararyassignment.orm.Blog;
import libararyassignment.orm.Book;
import libararyassignment.orm.HardBind;
import libararyassignment.orm.Publisher;

public class HibernateClient {
	public static void main(String[] args) {
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(AuthorAddress.class).addAnnotatedClass(Article.class).addAnnotatedClass(Author.class).addAnnotatedClass(Blog.class).addAnnotatedClass(HardBind.class).addAnnotatedClass(Publisher.class).buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.beginTransaction();
		
	Book b=new Book("book3","2A",1000,new Date(99,8,15));
	ses.save(b);
	Publisher p =  new Publisher(1,"dheeraj", "bangalore", 8848896999L);
	
	ses.save(p);
	b.setPublisher(p);
	ses.save(b);
	
	Article a1= new Article("abc.exam.com","abc");
	ses.save(a1);
	Author a=new Author("anuj",85555656656L);
	ses.save(a);
	AuthorAddress a11=new AuthorAddress(69,"jp nagar", "ka", 560104L);
	ses.save(a11);
	a.setAuthoraddress(a11);
	a11.setAuthor(a);
	Blog b1=new Blog("alter", "anujgg@ex.com", 2L);
	ses.save(b1);
	HardBind hb1=new HardBind(10, 900, "2002", 1);
	ses.save(hb1);

	tx.commit();
	ses.close();
	sf.close();
	}

}
