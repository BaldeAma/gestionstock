package com.obi.gestiondesstock.client.application.dto;

import com.obi.gestiondesstock.adresse.application.dto.AdresseRequestDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientRequestDto;

import java.util.List;

public record ClientRequestDto(

        String nom,

        String prenom,

        AdresseRequestDto adresse,

        String photo,

        String mail,

        String numTel,

        Integer idEntreprise,

        List<CommandeClientRequestDto> commandeClients
) {}
