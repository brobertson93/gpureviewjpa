package org.wecancodeit.gpureviewjpa.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class GPU {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
   @Lob
    private String description;
    private String imageUrl;
@ManyToOne
    private Brand brand;
    public GPU() {

    }

    public GPU(String name, String imageUrl, Brand brand, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.brand = brand;
        this.description = description;

    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Brand getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GPU gpu = (GPU) o;
        return Objects.equals(id, gpu.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
