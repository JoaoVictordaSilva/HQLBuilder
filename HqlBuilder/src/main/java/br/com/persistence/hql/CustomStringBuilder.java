package br.com.persistence.hql;

import static br.com.util.Utils.SPACE;

public class CustomStringBuilder {

    private transient StringBuilder builder = new StringBuilder();

    public CustomStringBuilder() {

    }

    public CustomStringBuilder append(String string) {
        builder.append(string);
        return this;
    }

    public CustomStringBuilder append(Object string) {
        builder.append(string);
        return this;
    }

    public CustomStringBuilder appendBackSpace(String string) {
        builder.append(SPACE).append(string);
        return this;
    }

    public CustomStringBuilder appendBackSpace(Object string) {
        builder.append(SPACE).append(string);
        return this;
    }

    public CustomStringBuilder appendFrontSpace(String string) {
        builder.append(string).append(SPACE);
        return this;
    }

    public CustomStringBuilder appendSpace(String string) {
        builder.append(SPACE).append(string).append(SPACE);
        return this;
    }

    public String toString() {
        return builder.toString();
    }


}
