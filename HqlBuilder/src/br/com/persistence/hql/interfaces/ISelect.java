package br.com.persistence.hql.interfaces;

public interface ISelect extends IJoin {

    /**
     * Sample select returning the entire object as parameter passed on constructor
     */
    IJoin select();

    IJoin select(IAggregation agregation);
    /**
     * @param fields name of the fields to be returned in HQL
     */
    IJoin select(IAggregation agregation, String... fields);

    /**
     * @param fields name of the fields to be returned in HQL
     */
    IJoin selectNew(String... fields);

    /**
     * @param clazz with constructor with respectively arguments from select return
     * @param fields name of the fields to be returned in HQL
     */
    IJoin selectNew(Class<?> clazz, String... fields);


}
