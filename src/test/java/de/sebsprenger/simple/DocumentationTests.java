package de.sebsprenger.simple;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class DocumentationTests {

    ApplicationModules modules = ApplicationModules.of(SimpleApplication.class);

    @Test
    void documentation() {
        var canvasOptions = Documenter.CanvasOptions.defaults()
//                .revealInternals()
                ;

        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml()
                .writeModuleCanvases(canvasOptions)
                .writeAggregatingDocument(Documenter.DiagramOptions.defaults(), canvasOptions)
        ;
    }

}