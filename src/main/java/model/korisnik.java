package model;

public class korisnik extends Table {
    @Entity(type = "INTEGER", size = 11, primary = true)
    int id;
    @Entity(type = "VARCHAR", size = 45)
    String ime;
    @Entity(type = "VARCHAR", size = 45)
    String prezime;
    @Entity(type = "VARCHAR", size = 45)
    String k_ime;
    @Entity(type = "VARCHAR", size = 45)
    String email;
    @Entity(type = "VARCHAR", size = 45)
    String lozinka;
    @Entity(type = "VARCHAR", size = 45)
    String broj_telefona;
    @Entity(type = "VARCHAR", size = 45)
    String adresa;
    @Entity(type = "INTEGER", size = 11)
    @ForeignKey(table = "fakultet", attribute = "id")
    int fakultet_fk;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public String getPassword(){return lozinka;}

    public String getUsername() {
        return k_ime;
    }

    public void setUsername(String username) {
        this.k_ime = username;
    }

    public void setPassword(String pass){this.lozinka = pass;}

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhNumber() {
        return this.broj_telefona;
    }

    public void setPhNumber(String phNumber) {
        this.broj_telefona = phNumber;
    }

    public String getAddress() {
        return this.adresa;
    }

    public void setAddress(String adresa) {
        this.adresa = adresa;
    }

    public fakultet getFakultet() throws Exception {
        return (fakultet) Table.get(fakultet.class, fakultet_fk);
    }

    public void setFakultet_fk(int fakultet_fk) {
        this.fakultet_fk = fakultet_fk;
    }
}
