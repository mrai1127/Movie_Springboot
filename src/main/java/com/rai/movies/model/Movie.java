package com.rai.movies.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String imbdbId;
	private String title;
	private String realeseDate;
	private String trailerLink;
	private String poster;

	public Movie() {
	}

	public Movie(Integer id, String imbdbId, String title, String realeseDate, String trailerLink, String poster) {
		this.id = id;
		this.imbdbId = imbdbId;
		this.title = title;
		this.realeseDate = realeseDate;
		this.trailerLink = trailerLink;
		this.poster = poster;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImbdbId() {
		return imbdbId;
	}

	public void setImbdbId(String imbdbId) {
		this.imbdbId = imbdbId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRealeseDate() {
		return realeseDate;
	}

	public void setRealeseDate(String realeseDate) {
		this.realeseDate = realeseDate;
	}

	public String getTrailerLink() {
		return trailerLink;
	}

	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
}
