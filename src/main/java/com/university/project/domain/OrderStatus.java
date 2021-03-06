package com.university.project.domain;

import org.springframework.security.core.GrantedAuthority;

public enum OrderStatus implements GrantedAuthority {

    //https://devcolibri.com/%D0%BA%D0%B0%D0%BA-%D1%81%D0%BE%D1%85%D1%80%D0%B0%D0%BD%D0%B8%D1%82%D1%8C-enum-%D0%B2-%D0%B1%D0%B4-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D1%83%D1%8F-jpa/
    Ожидает_Подтверждения, Подтвержден, Ждет_Оплаты, Оплачен, Готовится, В_доставке, Завершен;

    @Override
    public String getAuthority() {
        return name();
    }
}