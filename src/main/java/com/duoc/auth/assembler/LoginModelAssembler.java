/*package com.duoc.auth.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;

import com.duoc.auth.controller.LoginControllerV2;
import com.duoc.auth.model.Usuario;

@Component
public class LoginModelAssembler implements RepresentationModelAssembler<Usuario, EntityModel<Usuario>>{

     @Override
    public EntityModel<Usuario> toModel(Usuario usuario) {
        return EntityModel.of(usuario,
                linkTo(methodOn(LoginControllerV2.class).login(null)).withSelfRel()
                
        );
    }





}
    */
