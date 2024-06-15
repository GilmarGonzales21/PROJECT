public class techoPeru extends organizacion {

    private String sector;

    public techoPeru(String nombre, String correoElectronico, String ubicacion, String sector) {
        super(nombre, correoElectronico, ubicacion);
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String queEs() {
        return "Una ONG.";
    }

    @Override
    public String aQueSeDedica() {
        return "Se dedica al sector de " + sector + ".";
    }

    @Override
    public String toString() {
        return super.toString() + ", sector='" + sector + '\'' + " }";
    }
}
