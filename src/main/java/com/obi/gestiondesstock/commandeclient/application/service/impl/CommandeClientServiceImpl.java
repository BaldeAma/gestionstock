package com.obi.gestiondesstock.commandeclient.application.service.impl;

import com.obi.gestiondesstock.article.domain.entity.Article;
import com.obi.gestiondesstock.article.infrastructure.repository.ArticleRepository;
import com.obi.gestiondesstock.client.domain.entity.Client;
import com.obi.gestiondesstock.client.infrastructure.repository.ClientRepository;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientRequestDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientResponseDto;
import com.obi.gestiondesstock.commandeclient.application.service.CommandeClientService;
import com.obi.gestiondesstock.commandeclient.domain.entity.CommandeClient;
import com.obi.gestiondesstock.commandeclient.infrastructure.mapper.CommandeClientMapper;
import com.obi.gestiondesstock.commandeclient.infrastructure.repository.CommandeClientRepository;
import com.obi.gestiondesstock.common.domain.enums.EtatCommande;
import com.obi.gestiondesstock.common.exception.EntityNotFoundException;
import com.obi.gestiondesstock.common.exception.ErrorCodes;
import com.obi.gestiondesstock.common.exception.InvalidEntityException;
import com.obi.gestiondesstock.lignecommandeclient.domain.entity.LigneCommandeClient;
import com.obi.gestiondesstock.lignecommandeclient.infrastructure.mapper.LigneCommandeClientMapper;
import com.obi.gestiondesstock.lignecommandeclient.infrastructure.repository.LigneCommandeClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommandeClientServiceImpl implements CommandeClientService {

    private final ArticleRepository articleRepository;
    private final ClientRepository clientRepository;
    private final CommandeClientRepository commandeClientRepository;
    private final LigneCommandeClientRepository ligneCommandeClientRepository;

    @Override
    public CommandeClientResponseDto save(CommandeClientRequestDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("l' objet commande Client ne peut pas etre null");
        }
        //verifier le client existe BD via l'id client, modifier le clientrequestDto en rajoutant l'idclient
//        log.info("idClient "+ dto.client().id());
        Optional<Client> client = clientRepository.findById(dto.client().id());
        if (client.isEmpty()) {
            throw new EntityNotFoundException("Aucun client avec l'id " + dto.client().id() + " n'est present en BD", ErrorCodes.CLIENT_NOT_FOUND);
        }
        //verifier que les articles existes en BD
        List<String> articlesErrors = new ArrayList<>();
        if (dto.ligneCommandeClients() != null) {
            dto.ligneCommandeClients().forEach(
                    ligCmdClt -> {
                        if (ligCmdClt.article() != null) {
                            //verifier que chaque existe en BD
                            Optional<Article> article = articleRepository.findById(ligCmdClt.article().id());
                            if (article.isEmpty()) {
                                articlesErrors.add("L'article avec l'id " + ligCmdClt.article().id() + " n'existe pas");
                            }
                        } else {
                            articlesErrors.add("Impossible d'enregistrer une commande avec un article NULL");
                        }
                    }
            );
        }
        if (!articlesErrors.isEmpty()) {
            throw new InvalidEntityException("L'article n'existe pas dans la BD", ErrorCodes.ARTICLE_NOT_FOUND, articlesErrors);
        }
        //Mise a jour de la date de commande --> todo
        //enregistrer la commandeclient
        CommandeClient commandeClient = CommandeClientMapper.toEntity(dto);
        //injecter le vrai client recuperer en base avant insertion
        commandeClient.setClient(client.get());
        //initialiser l'etat de la commande
        commandeClient.setEtatCommande(EtatCommande.EN_PREPARATION);
        //modifier la date de commande
        commandeClient.setDateCommande(Instant.now());
        CommandeClient savedCommandeClient = commandeClientRepository.save(commandeClient);
        //enregistrer la lignecommandeclient --> assigner saveCommandeClient à ligneCommandeClient
        if (dto.ligneCommandeClients() != null) {
            dto.ligneCommandeClients().forEach(ligCmdClt -> {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientMapper.toEntity(ligCmdClt);
                ligneCommandeClient.setId(null);
                ligneCommandeClient.setCommandeClient(savedCommandeClient);
                ligneCommandeClient.setIdEntreprise(dto.idEntreprise());
                LigneCommandeClient savedLigneCommandeClient = ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }

        return CommandeClientMapper.toResponse(savedCommandeClient);
    }

    @Override
    public List<CommandeClientResponseDto> findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("le code ne peut pas etre null");
        }
        return commandeClientRepository
                .findCommandeClientByCode(code)
                .stream()
                .map(CommandeClientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CommandeClientResponseDto findById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("l'id est obligatoire ");
        }
        return commandeClientRepository.findById(id)
                .map(CommandeClientMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Aucune commande client n'a ete trouve avec l' id " + id, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public List<CommandeClientResponseDto> findAll() {

        return commandeClientRepository
                .findAll()
                .stream()
                .map(CommandeClientMapper::toResponse)
                .collect(Collectors.toList());
    }
}
