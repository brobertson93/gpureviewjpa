package org.wecancodeit.gpureviewjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wecancodeit.gpureviewjpa.models.Brand;
import org.wecancodeit.gpureviewjpa.models.GPU;
import org.wecancodeit.gpureviewjpa.repository.BrandRepository;
import org.wecancodeit.gpureviewjpa.repository.GpuRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BrandRepository brandRepo;

    @Autowired
    private GpuRepository gpuRepo;

    @Test
    public void brandShouldHaveListOfGPUs(){
        Brand testBrand = new Brand("AMD");
        GPU testGPU = new GPU ("AMD Radeon RX 5700XT","../images/5700xt.fw.png",testBrand,"Etiam sit amet tincidunt ex. Donec dapibus quis risus id malesuada. Morbi nec dapibus diam, nec aliquam ipsum. Nulla vel mi at nisl mollis facilisis. Ut ut consequat dui. Mauris dictum libero et ante mollis, a ornare tellus dapibus. Sed scelerisque in erat in tristique. Integer faucibus ex id orci posuere lobortis. Phasellus egestas nisl elementum eros tincidunt, at dignissim elit tincidunt. Pellentesque nec fringilla augue. Aenean dignissim sagittis diam nec fermentum.");

        brandRepo.save(testBrand);
        gpuRepo.save(testGPU);

        entityManager.flush();
        entityManager.clear();

        Optional<Brand> retrievedBrandOpt = brandRepo.findById(testBrand.getId());
        Brand retrievedBrand = retrievedBrandOpt.get();
        GPU retrievedGPU = gpuRepo.findById(testGPU.getId()).get();

        assertThat(retrievedBrand.getGpus().contains(testGPU));

    }


}
