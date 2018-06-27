package br.com.persistence.hql.interfaces;

import br.com.persistence.hql.construction.JoinType;

public interface IJoin extends IWhere {

    IJoin join(String field);

    IJoin leftJoin(String field);

    IJoin rightJoin(String field);

    IJoin joinFetch(String field);

    IJoin alias(String alias);

}