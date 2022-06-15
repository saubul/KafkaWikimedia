package ru.saubulprojects.kafkaconsumerdatabase.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wikimedias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WikimediaDataEntity {

	@Id
	@SequenceGenerator(name = "wikimediaData_id_sequence", sequenceName = "wikimediaData_id_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wikimediaData_id_sequence")
	private Long id;

	@Column(name = "data", columnDefinition = "VARCHAR(10000)")
	private String data;
	
	public WikimediaDataEntity(String data) {
		this.data = data;
	}
	
}
