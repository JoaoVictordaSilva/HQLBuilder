package br.com.persistence.hql.interfaces;

public interface IHaving extends IOrderBy {

    IOrderBy having(IClausule clausule);

}
