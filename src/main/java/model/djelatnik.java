package model;

public class djelatnik extends Table{
    @Entity(type="INTEGER", size=11, primary = true)
    int id;
    @Entity(type="VARCHAR", size=45)
    String ime;
    @Entity(type="VARCHAR", size=45)
    String prezime;
    @Entity(type="VARCHAR", size=45)
    String email;
    @Entity(type="VARCHAR", size=45)
    String lozinka;
    @Entity(type="VARCHAR", size=45)
    String broj_telefona;
    @Entity(type="VARCHAR", size=45)
    String smjena;

    public int getId() {
        return id;
    }

    public void setId(int did) {
        this.id = did;
    }

    public String getName() {
        return ime;
    }

    public void setName(String name) {
        this.ime = name;
    }
    public String getLastName() {
        return prezime;
    }

    public void setLastName(String Lname) {
        this.prezime = Lname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhNumber() {
        return this.broj_telefona;
    }

    public void setPhNumber(String phNumber){
        this.broj_telefona = phNumber;
    }

    public String getShift(){
        return this.smjena;
    }

    public void setShift(String smjena) {
        this.smjena = smjena;
    }

}
