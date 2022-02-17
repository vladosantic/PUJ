package model;

public class sektor extends Table {
    @Entity(type="INTEGER", size=11, primary = true)
    int id;
    @Entity(type="VARCHAR", size=45)
    String zgrada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return zgrada;
    }

    public void setName(String zgrada) {
        this.zgrada = zgrada;
    }

}
