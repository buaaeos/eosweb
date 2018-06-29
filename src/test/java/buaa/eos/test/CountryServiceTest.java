package buaa.eos.test;

import buaa.eos.service.BlockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import buaa.eos.Application;
import buaa.eos.model.Block;
/*
 * @author liuzh
 * @since 2017/9/2.
*/

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
public class CountryServiceTest {

    @Autowired
    private BlockService blockService;

    @Test
    public void test() {
        Block block = new Block();
//        block.setId(1);
        block.setTimestamp("aaa");
        block.setBlkId("awwe");
        blockService.save(block);

    }
}
