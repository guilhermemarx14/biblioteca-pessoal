package com.poxete.biblioteca_pessoal;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

class ArquiteturaTest {
    public static final String CAMINHO_PROJETO = "com.poxete.biblioteca_pessoal";
    // Importa todas as classes do pacote "com.example"
    private final JavaClasses importedClasses = new ClassFileImporter().importPackages(CAMINHO_PROJETO);

    @Test
    void controllersSoPodemImportarUseCases() {
        ArchRuleDefinition.classes()
                .that()
                .resideInAPackage("..controller")
                .should()
                .onlyHaveDependentClassesThat()
                .resideInAnyPackage("..usecase")
                .check(importedClasses);
    }

    @Test
    void useCasesSoPodemImportarUseCasesOuServices() {
        ArchRuleDefinition.noClasses()
                .that()
                .resideInAPackage("..usecase..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage("..controller..", "..repository..")
                .check(importedClasses);
    }

    //TODO: aprofundar nesses testes
}
