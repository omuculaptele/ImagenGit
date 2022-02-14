package institute.immune.imagengit;

public class Muzic {
    private int cancion, imagen;
    private String nombre;

    public Muzic( int a, int b){
        this.cancion = a;
        this.imagen = b;
    }


    public int getCancion() {
        return cancion;
    }

    public void setCancion(int cancion) {
        this.cancion = cancion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
