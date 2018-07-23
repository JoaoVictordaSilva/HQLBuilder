package util;

import br.processor.annotation.DataModel;

import javax.lang.model.element.Element;
import java.util.List;

public final class Preconditions {

    public static void checkAnnotation(Element targetClass) {
        boolean hasAnnotation = false;
        if (targetClass.getAnnotation(DataModel.class) != null) {
            hasAnnotation = true;
        }
        if (!hasAnnotation)
            throw new IllegalStateException("Annotation @DataModel not found");

    }

}
