package net.codejava;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "document")
public class Document {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;
  
  @Column(name="empid")
  private long empid;


  @Lob
  private byte[] data;
  

  public Document() {
  }

 

  public Document(Long id, String name, long empid) {
	this.id = id;
	this.name = name;
	this.empid = empid;
	
}



public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }



public long getEmpid() {
	return empid;
}



public void setEmpid(long empid) {
	this.empid = empid;
}



public void setId(Long id) {
	this.id = id;
}

}