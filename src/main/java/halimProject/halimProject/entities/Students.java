package halimProject.halimProject.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Students {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStudent;
	
	private String name;
	
	private String Lastname;
	
	
	
	@ManyToMany(targetEntity = Teachers.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			  name = "teacher_student", 
			  joinColumns = @JoinColumn(name = "Students_idStudent",referencedColumnName = "idStudent"), 
			  inverseJoinColumns = @JoinColumn(name = "Teachers_idTeacher",referencedColumnName = "idTeachers"))
	@JsonManagedReference
	private List<Teachers> teachers;
	
	@OneToOne(mappedBy = "student")
	@JsonIgnore
	private carteEtudiants carteEtudiant;
	
	@ManyToOne
	@JoinColumn(name = "groups")
	private Groups groups;
	
	
	
}
