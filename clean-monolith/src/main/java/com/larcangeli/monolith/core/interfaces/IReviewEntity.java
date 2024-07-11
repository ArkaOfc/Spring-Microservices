package com.larcangeli.monolith.core.interfaces;

import com.larcangeli.monolith.persistence.model.Product;
import jakarta.persistence.*;

public interface IReviewEntity {
    Long getId();
    String getAuthor();
    String getContent();
    String getSubject();
}
