package br.com.persistence.hql.interfaces;

public interface IAggregation extends IQuery {

    IAggregation sum(String field);

    IAggregation count();

    IAggregation count(String field);

    IAggregation min(String field);

    IAggregation max(String field);

    IAggregation average(String field);

}
