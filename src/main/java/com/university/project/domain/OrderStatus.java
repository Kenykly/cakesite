package com.university.project.domain;

import org.springframework.security.core.GrantedAuthority;

public enum OrderStatus implements GrantedAuthority {

    Ожидает_Подтверждения, Подтвржден, Ждет_Оплаты, Оплачен, Готовится, В_доставке, Завершен;

    @Override
    public String getAuthority() {
        return name();
    }
}