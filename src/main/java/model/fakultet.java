package model;

public class fakultet extends Table {
        @Entity(type="INTEGER", size=11, primary = true)
        int id;
        @Entity(type="VARCHAR", size=45)
        String ime;

        public int getId() {
                return id;
        }

        public void setId(int fid) {
                this.id = fid;
        }

        public String getName() {
                return ime;
        }

        public void setName(String ime) {
                this.ime = ime;
        }

}
