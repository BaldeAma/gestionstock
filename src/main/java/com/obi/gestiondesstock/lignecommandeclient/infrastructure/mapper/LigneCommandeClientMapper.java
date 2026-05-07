package com.obi.gestiondesstock.lignecommandeclient.infrastructure.mapper;

import com.obi.gestiondesstock.article.domain.entity.Article;
import com.obi.gestiondesstock.article.infrastructure.mapper.ArticleMapper;
import com.obi.gestiondesstock.commandeclient.domain.entity.CommandeClient;
import com.obi.gestiondesstock.commandeclient.infrastructure.mapper.CommandeClientMapper;
import com.obi.gestiondesstock.lignecommandeclient.application.dto.LigneCommandeClientRequestDto;
import com.obi.gestiondesstock.lignecommandeclient.application.dto.LigneCommandeClientResponseDto;
import com.obi.gestiondesstock.lignecommandeclient.domain.entity.LigneCommandeClient;

public class LigneCommandeClientMapper {
    //entity --> dto
    public static LigneCommandeClientResponseDto toResponseDto(LigneCommandeClient commandeClient){
        if(commandeClient == null){
            return null;
        }
        return new LigneCommandeClientResponseDto(
                commandeClient.getId(),
                commandeClient.getArticle()!=null? commandeClient.getArticle().getId() : null,
                commandeClient.getCommandeClient()!=null?commandeClient.getCommandeClient().getId():null,
                commandeClient.getQuantite(),
                commandeClient.getPrixUnitaire(),
                commandeClient.getIdEntreprise()
        );
    }


    //dto --> entity
    public static LigneCommandeClient toEntity(LigneCommandeClientRequestDto dto){
        return  LigneCommandeClient.builder()
                .id(dto.id())
                .article(dto.idArticle()!=null? Article.builder().id(dto.idArticle()).build():null)
                .commandeClient(dto.idCommandeClient() != null ? CommandeClient.builder().id(dto.idCommandeClient()).build():null)
                .quantite(dto.quantite())
                .prixUnitaire(dto.prixUnitaire())
                .idEntreprise(dto.idEntreprise())
                .build();

    }
}
