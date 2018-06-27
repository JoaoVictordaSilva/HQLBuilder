import br.com.persistence.hql.HQLBuilder;
import br.com.persistence.hql.construction.Aggregation;
import br.com.persistence.hql.construction.WhereClausule;
import br.com.persistence.hql.interfaces.IClausule;

public class test {
    /**
     * Create DataModel, this DataModel will define the alias from HQLBuilder and also defined in DataModel the attributes
     * from annotated class
     *
     * Example:
     * @DataModel(alias = "foo") Optional, if not defined the alias will be the name of the annotated class
     * public class Foo {
     *
     *     private String myFoo;
     *
     *     private String yourFoo;
     *
     *     @Transient
     *     private String ourFoo;
     *
     * }
     *
     * builded class
     *
     * public class FooDataModel {
     *
     *
     *     public static final String _fooAlias = "foo";
     *
     *     public static final String _myFoo = "myFoo";
     *
     *     public static final String _yourFoo = "yourFoo";
     *
     *
     * }
     *
     *
     *
     */
    public static void main(String[] args) {
        HQLBuilder HQLBuilder = new HQLBuilder(Teste.class);
        IClausule equals = new WhereClausule().equals(1, 2);
        HQLBuilder.select(new Aggregation().sum("s.valorAprovado"))
                .join("a").alias("alunos")
                .join("s")
                .where(equals).getClausule();
    }

    public class Teste {

        String nome;

        String sobrenome;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getSobrenome() {
            return sobrenome;
        }

        public void setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
        }
    }

}
