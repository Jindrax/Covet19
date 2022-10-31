package com.javeriana.web.four.covet19.Usuarios.User.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.Admin.PersonCreatedDomainEvent;
import com.javeriana.web.four.covet19.Shared.Domain.Aggregate.AggregateRoot;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.*;
import com.javeriana.web.four.covet19.Shared.Domain.Productos.ProductoConsumedDomainEvent;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthCredentials;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthEntity;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.Exceptions.IncorrectCredentials;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Exceptions.MascotaNotExist;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.ElementoCarritoNotExist;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.UserCarritoEmpty;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects.ElementoCarritoUsuario;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects.MascotaDetails;

import java.util.*;
import java.util.stream.Collectors;

public class User extends AggregateRoot implements AuthEntity {

    private IdPersona userId;
    private NombrePersona userFirstName;
    private PasswordPersona userPassword;
    private CorreoPersona userMail;
    private TelefonoPersona userPhone;
    private CedulaPersona userCedule;
    private DireccionPersona userAdresss;
    private FechaNacimientoPersona userBirth;
    private Optional<List<ElementoCarritoUsuario>> userCarrito;
    private Optional<List<MascotaDetails>> userMascotas;

    public User(IdPersona userId,
                NombrePersona userFirstName,
                PasswordPersona userPassword,
                CorreoPersona userMail,
                TelefonoPersona userPhone,
                CedulaPersona userCedule,
                DireccionPersona userAdresss,
                FechaNacimientoPersona userBirth,
                List<ElementoCarritoUsuario> userCarrito,
                List<MascotaDetails> userMascotas) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userPassword = userPassword;
        this.userMail = userMail;
        this.userPhone = userPhone;
        this.userCedule = userCedule;
        this.userAdresss = userAdresss;
        this.userBirth = userBirth;
        this.userCarrito = Optional.ofNullable(userCarrito);
        this.userMascotas = Optional.ofNullable(userMascotas);
    }

    public static User create(
            IdPersona idPersona,
            NombrePersona nombrePersona,
            PasswordPersona passwordPersona,
            CorreoPersona correoPersona,
            TelefonoPersona telefonoPersona,
            CedulaPersona cedulaPersona,
            DireccionPersona direccionPersona,
            FechaNacimientoPersona fechaNacimientoPersona
    ) {
        User newUser = new User(idPersona, nombrePersona, passwordPersona, correoPersona, telefonoPersona,
                cedulaPersona, direccionPersona, fechaNacimientoPersona, null, null);
        newUser.record(new PersonCreatedDomainEvent(idPersona.value(), correoPersona.value(), User.class.getName()));
        return newUser;
    }

    public Optional<List<HashMap<String, Object>>> getUserMascotas() {
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if (this.userMascotas.isPresent()) {
            response = Optional.of(this.userMascotas.get().stream().map(mascota -> mascota.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public Optional<List<MascotaDetails>> getUserMascotasDetails() {
        return this.userMascotas;
    }

    public Optional<List<HashMap<String, Object>>> getUserCarrito() {
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if (this.userCarrito.isPresent()) {
            response = Optional.of(this.userCarrito.get().stream().map(elemento -> elemento.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public void addElementoCarrito(ElementoCarritoUsuario elementoCarritoDetails) {

        List<ElementoCarritoUsuario> elementoCarritoDetailsList =
                this.userCarrito.isEmpty() ? new ArrayList<>() : this.userCarrito.get();
        if (elementoCarritoDetailsList.contains(elementoCarritoDetails)) {
            updateElementoCarrito(elementoCarritoDetails, true);
        } else {
            elementoCarritoDetailsList.add(elementoCarritoDetails);
            this.userCarrito = Optional.ofNullable(elementoCarritoDetailsList);
        }
    }

    public void vaciarCarrito() {
        List<ElementoCarritoUsuario> elementoCarritoDetailsList = new ArrayList<>();
        this.userCarrito = Optional.ofNullable(elementoCarritoDetailsList);
    }

    public void deleteElementoCarrito(ElementoCarritoUsuario elementoCarritoDetails) {

        if (!this.userCarrito.isEmpty()) {
            List<ElementoCarritoUsuario> elementoCarritoDetailsList = this.userCarrito.get();
            if (elementoCarritoDetailsList.contains(elementoCarritoDetails)) {
                elementoCarritoDetailsList.remove(elementoCarritoDetails);
            } else {
                throw new ElementoCarritoNotExist(elementoCarritoDetails.getIdProducto());
            }
        }
    }

    public boolean updateElementoCarrito(ElementoCarritoUsuario elementoCarritoDetails, boolean esSuma) {
        boolean delete = false;
        if (!this.userCarrito.isEmpty()) {
            List<ElementoCarritoUsuario> elementoCarritoDetailsList = this.userCarrito.get();
            boolean flag = false;
            for (ElementoCarritoUsuario elemento : elementoCarritoDetailsList) {
                if (elemento.equals(elementoCarritoDetails)) {
                    if (esSuma)
                        elemento.sumarCantidad(elementoCarritoDetails);
                    else
                        delete = elemento.restarCantidad(elementoCarritoDetails);
                    flag = true;
                }
            }

            if (flag) {
                this.userCarrito = Optional.ofNullable(elementoCarritoDetailsList);
            } else {
                throw new ElementoCarritoNotExist(elementoCarritoDetails.getIdProducto());
            }

        } else {
            throw new UserCarritoEmpty();
        }
        return delete;
    }

    public boolean updateMascota(MascotaDetails mascota) {
        boolean flag = false;
        if (!this.getUserMascotas().isEmpty()) {
            List<MascotaDetails> mascotas = this.userMascotas.get();
            List<MascotaDetails> mascotasTempo = new ArrayList<>();
            for (MascotaDetails mascotaTemporal : mascotas) {
                if (mascotaTemporal.getIdMascota().equals(mascota.getIdMascota())) {
                    mascotasTempo.add(mascota);
                    flag = true;
                    ;
                } else {
                    mascotasTempo.add(mascotaTemporal);
                }

            }
            if (flag) {
                this.userMascotas = Optional.ofNullable(mascotasTempo);
            } else {
                throw new MascotaNotExist(mascota.getIdMascota());
            }

        }
        return flag;
    }

    public void addMascotasDetails(MascotaDetails mascotaDetails) {
        List<MascotaDetails> mascotaDetailsList =
                this.userMascotas.isEmpty() ? new ArrayList<>() : this.userMascotas.get();
        mascotaDetailsList.add(mascotaDetails);
        this.userMascotas = Optional.ofNullable(mascotaDetailsList);
    }

    public void updateUser(NombrePersona userFirstName) {
        this.userFirstName = userFirstName;
    }

    public boolean equalsById(String otherId) {
        return this.userId.equals(new IdPersona(otherId));
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", userId.value());
            put("nombre", userFirstName.value());
            put("password", userPassword.value());
            put("correo", userMail.value());
            put("telefono", userPhone.value().toString());
            put("cedula", userCedule.value().toString());
            put("direccion", userAdresss.value());
            put("fecha", userBirth.value().toString());
            put("carrito", getUserCarrito());
            put("mascotas", getUserMascotas());

        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userCedule, user.userCedule) &&
                Objects.equals(userMail, user.userMail) &&
                Objects.equals(userAdresss, user.userAdresss) &&
                Objects.equals(userBirth, user.userBirth) &&
                Objects.equals(userFirstName, user.userFirstName) &&
                Objects.equals(userPassword, user.userPassword) &&
                Objects.equals(userPhone, user.userPhone);

    }

    public void update(User user) {
        this.userId = user.userId;
        this.userFirstName = user.userFirstName;
        this.userPassword = user.userPassword;
        this.userMail = user.userMail;
        this.userPhone = user.userPhone;
        this.userCedule = user.userCedule;
        this.userAdresss = user.userAdresss;
        this.userBirth = user.userBirth;
    }

    private User() {
    }

    @Override
    public AuthCredentials getCredentials(String supposedPass) throws IncorrectCredentials {
        if (userPassword.equals(new PasswordPersona(supposedPass))) {
            String authorities = "ROLE_USER";
            return new AuthCredentials(userId.value(), authorities, new HashMap<String, Object>());
        } else {
            throw new IncorrectCredentials("Credenciales incorrectas");
        }
    }

    @Override
    public HashMap<String, Object> dataToAuth() {
        HashMap<String, Object> ret = this.data();
        ret.put("rol", "user");
        return ret;
    }

    public void consumeProducto(String idProducto, int quantity) {
        this.record(new ProductoConsumedDomainEvent(idProducto, quantity));
    }

    public IdPersona getUserId() {
        return userId;
    }

    public CorreoPersona getUserMail() {
        return userMail;
    }
}
