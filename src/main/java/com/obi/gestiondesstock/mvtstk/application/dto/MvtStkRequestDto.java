package com.obi.gestiondesstock.mvtstk.application.dto;

import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.mvtstk.domain.enums.SourceMvtStk;
import com.obi.gestiondesstock.mvtstk.domain.enums.TypeMvtStk;

import java.math.BigDecimal;
import java.time.Instant;

public record MvtStkRequestDto(

        Instant dateMvt,

        BigDecimal quantite,

        ArticleRequestDto article,

        TypeMvtStk typeMvt,

        SourceMvtStk sourceMvt,

        Integer idEntreprise
) {
}
