package model;

public class rezervacija extends Table{
    @Entity(type="INTEGER", size = 11, primary = true)
    int id;
    @Entity(type="VARCHAR", size = 45)
    String pocetak;
    @Entity(type="VARCHAR", size = 45)
    String kraj;
    @Entity(type = "INTEGER", size = 11)
    @ForeignKey(table = "korisnik", attribute = "id")
    int korisnik_fk;
    @Entity(type = "INTEGER", size = 11)
    @ForeignKey(table = "stol", attribute = "id")
    int stol_fk;
    @Entity(type = "INTEGER", size = 11)
    @ForeignKey(table = "djelatnik", attribute = "id")
    int djelatnik_fk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return pocetak;
    }

    public void setStart(String start) {
        this.pocetak = start;
    }

    public String getEnd() {
        return kraj;
    }

    public void setEnd(String end) {
        this.kraj = end;
    }

    public korisnik getKorisnik() throws Exception {
        return (korisnik) Table.get(korisnik.class, korisnik_fk);
    }

    public void setKorisnik_fk(int korisnik_fk) {
        this.korisnik_fk = korisnik_fk;
    }

    public stol getStol() throws Exception {
        return (stol) Table.get(stol.class, stol_fk);
    }

    public void setStol_fk(int stol_fk) {
        this.stol_fk = stol_fk;
    }

    public djelatnik getDjelatnik() throws Exception {
        return (djelatnik) Table.get(djelatnik.class, djelatnik_fk);
    }

    public void setDjelatnik_fk(int djelatnik_fk) {
        this.djelatnik_fk = djelatnik_fk;
    }
}
