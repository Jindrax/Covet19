package com.javeriana.web.four.covet19.Shared.Domain.Index.Domain.Ports;

import com.javeriana.web.four.covet19.Shared.Domain.Index.Domain.Index;

import java.util.Optional;

public interface IndexRepository {
    Optional<Index> find(String email);
    void save(Index index);
}
