package br.processor;

import br.processor.annotation.DataModel;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import util.Preconditions;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

@AutoService(Processor.class)
public class HqlBuilderProcessor extends AbstractProcessor {

    private static final String PACKAGE_NAME = "br.com.hqlbuilder";

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        final Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(DataModel.class);
        elementsAnnotatedWith.forEach(Preconditions::checkAnnotation);
        elementsAnnotatedWith.forEach(this::generateDataModel);
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        final Set<String> supportedAnnotation = new TreeSet<>();
        supportedAnnotation.add(DataModel.class.getCanonicalName());
        return supportedAnnotation;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    private void generateDataModel(Element targetClass) {
        writeTo(DataModelCreator.generateDataModel(targetClass));
    }

    private void writeTo(TypeSpec typeSpec) {
        final JavaFile javaFile = JavaFile.builder(PACKAGE_NAME, typeSpec).build();
        try {
            javaFile.writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
