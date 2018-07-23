package br.com.persistence.hql.interfaces;

public interface IWhere extends IGroupBy {

    IGroupBy where(IClausule clausule);
}
