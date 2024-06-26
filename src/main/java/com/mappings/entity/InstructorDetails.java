package com.mappings.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="instructor_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDetails {
	public InstructorDetails(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel; this.hobby = hobby;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "youtube_channel")
	private String youtubeChannel;
	@Column(name = "hobby")
	private String hobby;
}