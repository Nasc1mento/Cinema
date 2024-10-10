package main.java.model;

import java.util.Objects;

public class Movie extends Entity {

	private String title;
	private String description;
	private MovieClassification classification;
	private int duration;
	
	public Movie() {
		
	}

	public Movie(Long id, String title, String description, MovieClassification classification, int duration) {
		super(id);
		this.title = title;
		this.classification = classification;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MovieClassification getClassification() {
		return classification;
	}

	public void setClassification(MovieClassification classification) {
		this.classification = classification;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(super.getId(), other.getId());
	}

	@Override
	public String toString() {
		return "Film [id=" + super.getId() + ", title=" + title + ", duration=" + duration + "]";
	}

}
