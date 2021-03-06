package com.example.Capstone.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.Capstone.entities.User;


@Entity
public class Orders {
	
	@Id
	@GeneratedValue(
		strategy= GenerationType.AUTO,
	    generator="native"
	)
	@GenericGenerator(
	    name = "native",
	    strategy = "native"
	)
	private Integer id;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=true)
	private User user;
	
	private String status;
	
	private String albums;
	
	private String songs;

	private Float price;
	
	public Orders(Date orderDate, User user) {
		super();
		
		this.orderDate = orderDate;
		this.user = user;
	}
	public Orders(Date orderDate, User user, String status,String albums,String songs, Float price) {
		this.orderDate = orderDate;
		this.user = user;
		this.status=status;
		this.albums=albums;
		this.songs=songs;
		this.price=price;
	}
	
	public Orders() {
		
	}
//	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy="orders")
//    private List<Music> musics;
	public String getAlbums() {
		return albums;
	}
	public void setAlbums(String albums) {
		this.albums = albums;
	}
	public String getSongs() {
		return songs;
	}
	public void setSongs(String songs) {
		this.songs = songs;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getId() {
		return id;
	}

//	public void setId(Integer id) {
//		this.id = id;
//	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
