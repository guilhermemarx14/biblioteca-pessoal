package com.poxete.biblioteca_pessoal.usecase.salvar;

import com.poxete.biblioteca_pessoal.model.Editora;
import com.poxete.biblioteca_pessoal.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarEditoraUseCase {
    @Autowired
    EditoraService editoraService;

    public Editora salvar(Editora editora) {
        return editoraService.salvar(editora);
    }
}
