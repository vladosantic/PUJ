package model;

public class stol extends Table{
        @Entity(type="INTEGER", size=11, primary = true)
        int id;
        @Entity(type="VARCHAR", size=45)
        String status;
        @Entity(type = "INTEGER", size = 11)
        @ForeignKey(table = "sektor", attribute = "id")
        int sektor_fk;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStats() {
            return status;
        }

        public void setStats(String status) {
            this.status = status;
        }

        public sektor getSektor() throws Exception {
            return (sektor) Table.get(sektor.class, sektor_fk);
        }

        public void setSektor_fk(int sektor_fk) {
            this.sektor_fk = sektor_fk;
        }
}
