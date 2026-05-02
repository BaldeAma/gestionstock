package com.obi.gestiondesstock.ventes.application.service.impl;

import com.obi.gestiondesstock.article.domain.entity.Article;
import com.obi.gestiondesstock.article.infrastructure.repository.ArticleRepository;
import com.obi.gestiondesstock.common.exception.EntityNotFoundException;
import com.obi.gestiondesstock.common.exception.ErrorCodes;
import com.obi.gestiondesstock.common.exception.InvalidEntityException;
import com.obi.gestiondesstock.entreprise.domain.entity.Entreprise;
import com.obi.gestiondesstock.entreprise.infrastructure.repository.EntrepriseRepository;
import com.obi.gestiondesstock.lignevente.domain.entity.LigneVente;
import com.obi.gestiondesstock.lignevente.infrastructure.mapper.LigneVenteMapper;
import com.obi.gestiondesstock.lignevente.infrastructure.repository.LigneVenteRepository;
import com.obi.gestiondesstock.ventes.application.dto.VentesRequestDto;
import com.obi.gestiondesstock.ventes.application.dto.VentesResponseDto;
import com.obi.gestiondesstock.ventes.application.service.VentesService;
import com.obi.gestiondesstock.ventes.domain.entity.Ventes;
import com.obi.gestiondesstock.ventes.infrastructure.mapper.VentesMapper;
import com.obi.gestiondesstock.ventes.infrastructure.repository.VentesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class VentesServiceImpl implements VentesService {

    private final ArticleRepository articleRepository;
    private final EntrepriseRepository entrepriseRepository;
    private final VentesRepository ventesRepository;
    private final LigneVenteRepository ligneVenteRepository;


    @Override
    public VentesResponseDto save(VentesRequestDto dto) {
        //verfier le dto
        if(dto==null){
            throw new IllegalArgumentException("L' objet vente ne peut pas etre null");
        }

        //verfier si idEntreprise existe
        /*
        Optional<Entreprise> entreprise = entrepriseRepository.findById(dto.idEntreprise());
        if(entreprise.isEmpty()){
            throw new EntityNotFoundException("Aucune entreprise avec l'id "+ dto.idEntreprise()+" n'est present en BD", ErrorCodes.ENTREPRISE_NOT_VALID);
        }
        */
        //parcourir la liste ligne de vente, pour verifier si les articles existes
        List<String> articlesErrors = new ArrayList<>();
        if(dto.ligneVentes()!=null){
            dto.ligneVentes().forEach(
                    ligVente ->{
                        Optional<Article> article= articleRepository.findById(ligVente.idArticle());
                        if (article.isEmpty()){
                            articlesErrors.add("L'article avec l'id "+ ligVente.idArticle()+" n'existe pas");
                        }
                    }
            );
        }else {
            throw new IllegalArgumentException("L' objet LigneVente ne peut pas etre null");
        }
        if(!articlesErrors.isEmpty()){
            throw new InvalidEntityException("L'article n'existe pas dans le BDD", ErrorCodes.ARTICLE_NOT_FOUND, articlesErrors);
        }

        Ventes ventes= VentesMapper.toEntity(dto);
        //update dateVente
        ventes.setDateVente(Instant.now());
        //save vente
        Ventes ventesSave= ventesRepository.save(ventes);

        //save ligneVente
        dto.ligneVentes().forEach(
                ligVentes->{
                    LigneVente ligneVente= LigneVenteMapper.toEntity(ligVentes);
                    ligneVente.setId(null);
                    ligneVente.setIdEntreprise(dto.idEntreprise());
                    ligneVente.setVente(ventesSave);
                    ligneVenteRepository.save(ligneVente);
                }
        );
        //update le mouvement de stock --> todo

        return VentesMapper.toResponseDto(ventesSave);
    }

    @Override
    public VentesResponseDto findById(Integer id) {
        return null;
    }

    @Override
    public List<VentesResponseDto> findAll() {
        return List.of();
    }

    @Override
    public List<VentesResponseDto> findByCode(String code) {
        return List.of();
    }
}
