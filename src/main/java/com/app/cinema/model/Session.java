package main.java.com.app.cinema.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Session extends Entity {

	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private Long roomId;
	private Long movieId;

	public Session() {

	}

	public Session(LocalDateTime startTime, LocalDateTime endTime, Long id, Long roomId, Long filmId) {
		this.startDateTime = startTime;
		this.endDateTime = endTime;
		this.roomId = roomId;
		this.movieId = filmId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long filmId) {
		this.movieId = filmId;
	}

	public LocalDateTime getStartTime() {
		return startDateTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startDateTime = startTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endTime) {
		this.endDateTime = endTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session other = (Session) obj;
		return Objects.equals(getId(), other.getId());
	}

	@Override
	public String toString() {
		return "Session [id=" + getId() + ", roomId=" + roomId + ", filmId=" + movieId + ", startTime=" + startDateTime
				+ ", endTime=" + endDateTime + "]";
	}

}