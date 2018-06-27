package br.com.persistence.hql.interfaces;

public interface IGroupBy extends IOrderBy {

    IHaving groupBy(String... groupBy);

}
