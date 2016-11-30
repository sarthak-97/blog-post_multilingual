package org.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name="login")
@SecondaryTables({
    @SecondaryTable(name="post", pkJoinColumns={
        @PrimaryKeyJoinColumn(name="mob", referencedColumnName="mob") }),
    
})

public class login {
	
private int m;
@Id
	private String mob;

public String getmob() {
		return mob;
	}

	public void setmob(String mob) {
		this.mob = mob;
	}

public int getM() {
	return m;
}

public void setM(int m) {
	this.m = m;
}


}
