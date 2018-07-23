package br.processor;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import java.util.stream.Collectors;

public class DataModelCreator {

    private static final ClassName STRING = ClassName.get(String.class);
    private static final Modifier[] DEFAULT_MODIFIERS = {Modifier.PUBLIC, Modifier.FINAL};

    public static TypeSpec generateDataModel(Element targetClass) {
        return TypeSpec.classBuilder(targetClass.getSimpleName() + "Teste_")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addField(
                        FieldSpec.builder(STRING, "_" + targetClass.getSimpleName().toString(),
                                Modifier.PUBLIC, Modifier.FINAL)
                                .initializer(targetClass.getSimpleName().toString())
                                .build())
                .addFields(generateFields(targetClass))
                .build();
    }

    private static Iterable<FieldSpec> generateFields(Element targetClass) {
        return targetClass.getEnclosedElements()
                .stream()
                .map(it ->
                        FieldSpec.builder(STRING, "_" + it.getSimpleName().toString(),
                                Modifier.PUBLIC, Modifier.FINAL)
                                .initializer(it.getSimpleName().toString())
                                .build())
                .collect(Collectors.toList());
    }


}
