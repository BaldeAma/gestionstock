package com.obi.gestiondesstock.client.application.dto;

import com.obi.gestiondesstock.adresse.application.dto.AdresseDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ClientRequestDto(

        //@NotNull(message = "L'id est obligatoire")
        Integer id,

        @NotNull(message = "le nom est obligatoire")
        String nom,

        @NotNull(message = "le prenom est obligatoire")
        String prenom,

        @Valid
        AdresseDto adresse,

        String photo,

        @NotNull(message = "le mail est obligatoire")
        String mail,

        String numTel,

        Integer idEntreprise,

        List<CommandeClientRequestDto> commandeClients
) {}
