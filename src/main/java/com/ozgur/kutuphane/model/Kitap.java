package com.ozgur.kutuphane.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kitap")
public class Kitap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "book_name")
	private String bookName;

	@Column(name = "book_subname")
	private String bookSubname;

	@Column(name = "book_series_name")
	private String bookSeriesName;

	@JoinColumn(name = "author_id")
	@ManyToOne
	private Yazar author;

	@ManyToOne
	private YayinEvi publisher;

	@Column(name = "isbn_no")
	private String isbnNo;

	@Column(name = "declaration")
	private String declaration;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookSubname() {
		return bookSubname;
	}

	public void setBookSubname(String bookSubname) {
		this.bookSubname = bookSubname;
	}

	public String getBookSeriesName() {
		return bookSeriesName;
	}

	public void setBookSeriesName(String bookSeriesName) {
		this.bookSeriesName = bookSeriesName;
	}

	public String getIsbnNo() {
		return isbnNo;
	}

	public Yazar getAuthor() {
		return author;
	}

	public void setAuthor(Yazar author) {
		this.author = author;
	}

	public YayinEvi getPublisher() {
		return publisher;
	}

	public void setPublisher(YayinEvi publisher) {
		this.publisher = publisher;
	}

	public void setIsbnNo(String isbnNo) {
		this.isbnNo = isbnNo;
	}

	public String getDeclaration() {
		return declaration;
	}

	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}

}
