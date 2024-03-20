/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance;

public class student {
    private int stuid;
    private String surname;
    private String firstName;
    private String chinName;
    private String clas;
    private String percentage;
    public student(int stuid, String surname, String firstName, String chinName, String clas, String percentage) {
	super();
	this.stuid = stuid;
	this.surname = surname;
	this.firstName = firstName;
	this.chinName = chinName;
	this.clas = clas;
	this.percentage = percentage;
    }
    public int getstuid() {
    	return stuid;
    }
    public String getsurname() {
	return surname;
    }
    public String getfirstName() {
	return firstName;
    }
    public String getchinName() {
   	return chinName;
    }
    public String getclas() {
	return clas;
    }
    public String getpercentage() {
	return percentage;
    }
}
