package org.wecancodeit.gpureviewjpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.gpureviewjpa.models.Brand;

public interface BrandRepository extends CrudRepository<Brand, Long> {
     Brand findBrandByBrand(String brand);


}
