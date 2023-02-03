package halimProject.halimProject.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Groups {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGroup;

	private String nameGroup;

	@JsonIgnore
	@OneToMany(mappedBy = "groups", cascade = CascadeType.ALL)
	private List<Students> students;
}
