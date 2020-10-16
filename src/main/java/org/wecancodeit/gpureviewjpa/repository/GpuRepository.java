package org.wecancodeit.gpureviewjpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.gpureviewjpa.models.GPU;

public interface GpuRepository extends CrudRepository<GPU,Long> {
}
