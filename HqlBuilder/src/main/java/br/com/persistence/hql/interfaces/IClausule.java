package br.com.persistence.hql.interfaces;

import java.util.Map;

public interface IClausule extends IQuery {

    IClausule equals(Object field, Object obj);

    IClausule ge(Object field, Object obj);

    IClausule le(Object field, Object obj);

    IClausule like(Object field, Object obj);

    IClausule in(Object field, Object... obj);

    IClausule and();

    IClausule or();

    Map<Object, Object> getMapParameters();

}
