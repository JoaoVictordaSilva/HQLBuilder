package br.com.persistence.hql.construction;

import br.com.persistence.hql.AbstractHQLBuilder;
import br.com.persistence.hql.interfaces.IClausule;
import br.com.util.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

import static br.com.persistence.hql.AbstractHQLBuilder.Operators.*;

public final class WhereClausule extends AbstractHQLBuilder implements IClausule {

    private final Map<Object, Object> map = new LinkedHashMap<>();

    /**
     * @param field name of the field
     * @param obj   to be compared against field
     * @return
     */
    @Override
    public IClausule equals(Object field, Object obj) {
        putParameterAndAddClausules(field, obj, EQUALS);
        return this;
    }

    /**
     * @param field name of the field
     * @param obj   to be compared against field
     * @return
     */
    @Override
    public IClausule ge(Object field, Object obj) {
        putParameterAndAddClausules(field, obj, GE);
        return this;
    }

    /**
     * @param field name of the field
     * @param obj   to be compared against field
     * @return
     */
    @Override
    public IClausule le(Object field, Object obj) {
        putParameterAndAddClausules(field, obj, LE);
        return this;
    }

    /**
     * @param field name of the field
     * @param obj   to be compared against field
     * @return
     */
    @Override
    public IClausule like(Object field, Object obj) {
        putParameterAndAddClausuleToLikeOperation(field, obj);
        return this;
    }

    /**
     * @param field name of the field
     * @param obj   to be compared against field
     * @return
     */
    @Override
    public IClausule in(Object field, Object... obj) {
        if (Utils.hasNotNull(obj)) {
            builder.appendBackSpace(IN).append(Utils.OPEN_PARENTHESES);
            for (int index = 0; index < obj.length; index++) {
                map.put(field, obj[index]);
                if (index == 0) {
                    builder.append(HQL_OPERATOR).append(obj[index]);
                    continue;
                }
                builder.append(Utils.COMMA).appendBackSpace(HQL_OPERATOR).append(obj[index]);
            }
            builder.append(Utils.CLOSE_PARENTHESES);
        }
        return this;
    }

    /**
     * and operator
     *
     * @return
     */
    @Override
    public IClausule and() {
        builder.appendBackSpace(AND);
        return this;
    }

    /**
     * or operator
     *
     * @return
     */
    @Override
    public IClausule or() {
        builder.appendBackSpace(OR);
        return this;
    }

    /**
     * @return map with values to be set up the parameter in HQL.
     * Example: TypedQuery query = EntityManager.createQuery(hqlBuilder.getClausule(), Foo.class);
     * map.forEach((key, value) -> query.setParameter(key, value);
     * List<Foo> fooList = query.getResultList();
     */
    @Override
    public Map<Object, Object> getMapParameters() {
        return map;
    }

    private void appendClausuleOperator(Object field, Object obj, String operator) {
        builder.appendBackSpace(field)
                .appendBackSpace(operator)
                .appendBackSpace(appendHqlOperator(obj));
    }

    private void appendLikeOperator(Object field, Object obj) {
        builder.appendBackSpace(field)
                .appendBackSpace(LIKE)
                .appendBackSpace(LIKE_OPERATOR)
                .append(appendHqlOperator(obj))
                .append(LIKE_OPERATOR);
    }

    private String appendHqlOperator(Object obj) {
        return HQL_OPERATOR + obj;
    }

    private void putParameterAndAddClausules(Object field, Object obj, String operator) {
        if (Utils.isNotNull(obj)) {
            map.put(field, obj);
            appendClausuleOperator(field, obj, operator);
        }
    }

    private void putParameterAndAddClausuleToLikeOperation(Object field, Object obj) {
        if (Utils.isNotNull(obj)) {
            map.put(field, obj);
            appendLikeOperator(field, obj);
        }
    }

    @Override
    public String getClausule() {
        return builder.toString();
    }
}
