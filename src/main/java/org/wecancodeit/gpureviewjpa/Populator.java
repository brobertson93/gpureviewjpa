package org.wecancodeit.gpureviewjpa;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.gpureviewjpa.models.Brand;
import org.wecancodeit.gpureviewjpa.models.GPU;
import org.wecancodeit.gpureviewjpa.repository.BrandRepository;
import org.wecancodeit.gpureviewjpa.repository.GpuRepository;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {
    @Resource
    private GpuRepository gpuRepo;
    @Resource
    private BrandRepository brandRepo;
    @Override
    public void run(String... args) throws Exception {

        Brand amd = new Brand("AMD");
        Brand nvidia = new Brand("Nvidia");
        brandRepo.save(amd);
        brandRepo.save(nvidia);

        GPU gpuOne = new GPU("RTX 3080", "../images/3080.png", nvidia, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam pharetra lorem quis dolor sollicitudin semper. In non congue nulla. Aliquam maximus lacus quis metus rhoncus laoreet. Integer ultricies ipsum nec ipsum malesuada imperdiet sed vitae odio. In nec leo fringilla, tincidunt dolor sit amet, congue felis. Etiam finibus sem sit amet feugiat porta. Morbi eros enim, feugiat vel venenatis sed, malesuada vel ante. Vivamus tempus placerat tellus a tristique. Duis eros nibh, euismod nec sem ac, tempus facilisis ante. Sed tincidunt purus massa, at lacinia massa rhoncus vel. Vivamus quis urna ac augue lacinia convallis non eu libero. Suspendisse potenti. Ut ultricies ipsum faucibus arcu pellentesque, sit amet semper lorem auctor. Donec fermentum aliquet rhoncus. Pellentesque consectetur eleifend massa eget tempor.");
        GPU gpuTwo = new GPU("RTX 3090", "../images/3090.png", nvidia, "Etiam sit amet tincidunt ex. Donec dapibus quis risus id malesuada. Morbi nec dapibus diam, nec aliquam ipsum. Nulla vel mi at nisl mollis facilisis. Ut ut consequat dui. Mauris dictum libero et ante mollis, a ornare tellus dapibus. Sed scelerisque in erat in tristique. Integer faucibus ex id orci posuere lobortis. Phasellus egestas nisl elementum eros tincidunt, at dignissim elit tincidunt. Pellentesque nec fringilla augue. Aenean dignissim sagittis diam nec fermentum.");
        GPU gpuThree = new GPU("AMD Radeon RX 5700XT", "../images/5700xt.fw.png", amd, "Etiam sit amet tincidunt ex. Donec dapibus quis risus id malesuada. Morbi nec dapibus diam, nec aliquam ipsum. Nulla vel mi at nisl mollis facilisis. Ut ut consequat dui. Mauris dictum libero et ante mollis, a ornare tellus dapibus. Sed scelerisque in erat in tristique. Integer faucibus ex id orci posuere lobortis. Phasellus egestas nisl elementum eros tincidunt, at dignissim elit tincidunt. Pellentesque nec fringilla augue. Aenean dignissim sagittis diam nec fermentum.");
        GPU gpuFour = new GPU("AMD Radeon RX 5600XT", "../images/5600xt.fw.png", amd, "Etiam sit amet tincidunt ex. Donec dapibus quis risus id malesuada. Morbi nec dapibus diam, nec aliquam ipsum. Nulla vel mi at nisl mollis facilisis. Ut ut consequat dui. Mauris dictum libero et ante mollis, a ornare tellus dapibus. Sed scelerisque in erat in tristique. Integer faucibus ex id orci posuere lobortis. Phasellus egestas nisl elementum eros tincidunt, at dignissim elit tincidunt. Pellentesque nec fringilla augue. Aenean dignissim sagittis diam nec fermentum.");

        gpuRepo.save(gpuOne);
        gpuRepo.save(gpuTwo);
        gpuRepo.save(gpuThree);
        gpuRepo.save(gpuFour);


    }







    }

