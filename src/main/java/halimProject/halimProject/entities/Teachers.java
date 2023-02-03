package halimProject.halimProject.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Teachers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTeachers;

	private String name;

	private String Lastname;

	@ManyToMany(mappedBy = "teachers", fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Students> students;
}
