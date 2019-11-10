import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * SeckillServiceTest
 *
 * @author Joseph
 * @version 1.0
 * 2019/11/8 16:31
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @Test
    public void testGetSeckillList() throws Exception {

        List<Seckill> list = seckillService.getSeckillList();

        logger.info("list={}", list);
    }

    @Test
    public void testGetById() throws Exception {
        long id = 1000L;
        Seckill seckill = seckillService.getById(id);

        logger.info("seckill={}", seckill);
    }

    @Test
    public void testSeckillLogic() throws Exception {

        long id = 1001;
        Exposer exposer = seckillService.exportSeckillUrl(id);

        if(exposer.isExposed())
        {
            logger.info("exposer={}",exposer);
            long phone=13502171127L;
            String md5=exposer.getMd5();

            try {

                SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
                logger.info("result={}",execution);

            }catch (RepeatKillException e)
            {
                logger.error(e.getMessage());
            }catch (SeckillCloseException e)
            {
                logger.error(e.getMessage());
            }

        }else {
            logger.warn("exposer={}",exposer);
        }


    }


    @Test
    public void executeSeckillProcedure()
    {
        long seckillId=1000;
        long phone=1368011101;

        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if(exposer.isExposed())
        {
            String md5=exposer.getMd5();
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);

            logger.info(execution.getStateInfo());
        }


    }
}
