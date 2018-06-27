package br.com.persistence.hql.construction;

public enum JoinType {

    INNER("INNER JOIN"),

    RIGHT("RIGHT OUTER JOIN"),

    LEFT("LEFT OUTER JOIN"),

    JOIN_FETCH("JOIN FETCH");

    JoinType(String joinType) {
        join = joinType;
    }

    private String join;

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

}
