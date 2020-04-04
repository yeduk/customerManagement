package customerManagment.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager {

	@Id
	
	private int id;

	private String pwd;
	public int getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}
	
}
