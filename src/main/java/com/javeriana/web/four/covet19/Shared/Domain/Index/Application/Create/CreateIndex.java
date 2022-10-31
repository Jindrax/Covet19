package com.javeriana.web.four.covet19.Shared.Domain.Index.Application.Create;

import com.javeriana.web.four.covet19.Shared.Domain.Index.Domain.Index;
import com.javeriana.web.four.covet19.Shared.Domain.Index.Domain.Ports.IndexRepository;

public class CreateIndex {
    private final IndexRepository indexRepository;

    public CreateIndex(IndexRepository indexRepository) {
        this.indexRepository = indexRepository;
    }

    public void execute(String email, String referenceId, String rol){
        indexRepository.save(Index.create(email, referenceId, rol));
    }
}
