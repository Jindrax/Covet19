package com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class MascotaDetails {
    private String idMascota;
    private int edadMascota;
    private String nombreMascota;
    private String tipoMascota;
    private String razaMascota;

    public MascotaDetails(String idMascota, int edadMascota, String nombreMascota, String tipoMascota, String razaMascota) {
        this.idMascota = idMascota;
        this.edadMascota = edadMascota;
        this.nombreMascota = nombreMascota;
        this.tipoMascota = tipoMascota;
        this.razaMascota = razaMascota;
    }

    public HashMap<String, Object> data(){
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", idMascota);
            put("edad", edadMascota);
            put("nombre", nombreMascota );
            put("tipo", tipoMascota);
            put("raza", razaMascota);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MascotaDetails that = (MascotaDetails) o;
        return Objects.equals(idMascota, that.idMascota) && Objects.equals(nombreMascota, that.nombreMascota) && Objects.equals(edadMascota, that.edadMascota) && Objects.equals(tipoMascota, that.tipoMascota)&& Objects.equals(razaMascota, that.razaMascota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMascota, edadMascota, nombreMascota, tipoMascota,razaMascota);
    }

    public String getIdMascota() {
        return this.idMascota;
    }

    public boolean equalsIdMascota(MascotaDetails mascotaDetails) {
        return this.idMascota.equals(mascotaDetails.getIdMascota());
    }

    public MascotaDetails () {}
}
