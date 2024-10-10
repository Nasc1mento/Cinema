package main.java.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Session extends Entity {

	private Long roomId;
	private Long filmId;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;

	public Session(Long id, Long roomId, Long filmId, LocalDateTime startTime, LocalDateTime endTime) {
		super(id);
		this.roomId = roomId;
		this.filmId = filmId;
		this.startDateTime = startTime;
		this.endDateTime = endTime;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public LocalDateTime getStartTime() {
		return startDateTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startDateTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endDateTime;
	}

	public void setEndTime(LocalDateTime endTime) {
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
		return "Session [id=" + getId() + ", roomId=" + roomId + ", filmId=" + filmId + ", startTime=" + startDateTime
				+ ", endTime=" + endDateTime + "]";
	}

}