package com.dev.leadBackEngineerTest.controllers;

import com.dev.leadBackEngineerTest.dto.UserDTO;
import com.dev.leadBackEngineerTest.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Crea un nuevo usuario.
     *
     * @param userDTO Datos del usuario a crear.
     * @return El usuario creado con su ID asignado.
     */
    @Operation(summary = "Crear un nuevo usuario", description = "Este endpoint permite crear un nuevo usuario en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta, faltan o son incorrectos los datos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    /**
     * Actualiza un usuario existente.
     *
     * @param id ID del usuario a actualizar.
     * @param userDTO Datos actualizados del usuario.
     * @return El usuario actualizado.
     */
    @Operation(summary = "Actualizar un usuario", description = "Este endpoint permite actualizar los datos de un usuario existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta, faltan o son incorrectos los datos"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping("/{id}")
    public UserDTO updateUser(@Valid @PathVariable UUID id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    /**
     * Obtiene todos los usuarios.
     *
     * @return Lista de todos los usuarios.
     */
    @Operation(summary = "Obtener todos los usuarios", description = "Este endpoint permite obtener una lista de todos los usuarios en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuarios obtenidos correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id ID del usuario a consultar.
     * @return El usuario correspondiente al ID proporcionado.
     */
    @Operation(summary = "Obtener usuario por ID", description = "Este endpoint permite obtener un usuario por su ID único.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }
}
