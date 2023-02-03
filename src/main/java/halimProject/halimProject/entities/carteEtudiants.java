package halimProject.halimProject.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Data 
@NoArgsConstructor 
@Getter
@Setter
@AllArgsConstructor
@Table
@Builder
public class carteEtudiants {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String matriculeStudent;
	
	private String image;
	@OneToOne
	private Students student;
}
