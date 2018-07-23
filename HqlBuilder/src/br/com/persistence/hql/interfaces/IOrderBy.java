package br.com.persistence.hql.interfaces;

public interface IOrderBy extends IQuery {

    String orderBy(IOrderByClausule orderBy);

}
