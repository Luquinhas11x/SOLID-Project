package com.training.rh.tributacao;

import java.math.BigDecimal;

public interface ReajusteTributavel extends Reajuste{
    BigDecimal valorImpostoRenda();
}
