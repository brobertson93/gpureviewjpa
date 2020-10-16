package org.wecancodeit.gpureviewjpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Brand {

    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    @OneToMany(mappedBy = "brand")
    private Collection<GPU> gpus;



    public Brand() {

    }

    public Brand(String brand) {
        this.brand = brand;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(id, brand.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public Collection<GPU> getGpus() {
        return gpus;
    }
}
