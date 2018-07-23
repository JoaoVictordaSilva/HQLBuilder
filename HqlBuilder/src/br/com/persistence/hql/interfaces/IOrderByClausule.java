package br.com.persistence.hql.interfaces;

import br.com.persistence.hql.construction.Direction;

public interface IOrderByClausule extends IQuery {

    IOrderByClausule orderBy(String field);

    IOrderByClausule orderBy(String field, Direction direction);

}
