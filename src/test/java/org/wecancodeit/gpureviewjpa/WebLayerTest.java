package org.wecancodeit.gpureviewjpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.wecancodeit.gpureviewjpa.models.Brand;
import org.wecancodeit.gpureviewjpa.models.GPU;
import org.wecancodeit.gpureviewjpa.repository.BrandRepository;
import org.wecancodeit.gpureviewjpa.repository.GpuRepository;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.web.servlet.function.ServerResponse.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest


public class WebLayerTest {

    @MockBean
    private GpuRepository gpuRepo;
    @MockBean
    private BrandRepository brandRepo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void brandShouldBeOkayAndReturnBrandsViewWithBrandsModelAttribute () throws Exception {
        mockMvc.perform(get("/brands")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(view().name("brandsView")).andExpect(model().attributeExists("brands"));

    }

    @Test
    public void gpuShouldBeOkayAndReturnGpusViewWithGpusModelAttribute () throws Exception {
        mockMvc.perform(get("/gpus")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(view().name("gpusView")).andExpect(model().attributeExists("gpus"));

    }

    @Test
    public void shouldBeOkForASingleBrandEndpointWithBrandViewAndBrandModelAttribute() throws Exception {
        Brand testBrand = new Brand ("AMD");
        when(brandRepo.findBrandByBrand(testBrand.getBrand())).thenReturn(testBrand);
        mockMvc.perform(get("/brands/AMD")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(view().name("brandView")).andExpect(model().attributeExists("brand"));

    }

    @Test
    public void shouldBeOkForASingleGpuEndpointWithGpuViewAndGpuModelAttribute() throws Exception {
        Brand testBrand = new Brand("AMD");
        GPU testGPU = new GPU ("AMD Radeon RX 5700XT","../images/5700xt.fw.png",testBrand,"Etiam sit amet tincidunt ex. Donec dapibus quis risus id malesuada. Morbi nec dapibus diam, nec aliquam ipsum. Nulla vel mi at nisl mollis facilisis. Ut ut consequat dui. Mauris dictum libero et ante mollis, a ornare tellus dapibus. Sed scelerisque in erat in tristique. Integer faucibus ex id orci posuere lobortis. Phasellus egestas nisl elementum eros tincidunt, at dignissim elit tincidunt. Pellentesque nec fringilla augue. Aenean dignissim sagittis diam nec fermentum.");
        when(gpuRepo.findById(1L)).thenReturn(java.util.Optional.of(testGPU));
        mockMvc.perform(get("/gpus/1")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(view().name("gpuView")).andExpect(model().attributeExists("gpu"));

    }
}
