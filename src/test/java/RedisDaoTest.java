import com.seckill.dao.SeckillDao;
import com.seckill.dao.cache.RedisDao;
import com.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * RedisDaoTest
 *
 * @author Joseph
 * @version 1.0
 * 2019/11/9 21:04
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest {

    private long id=1001L;
    @Autowired
    private RedisDao redisDao;


    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void testSeckill() throws Exception{

        Seckill seckill = redisDao.getSeckill(id);

        if(seckill==null)
        {
            seckill=seckillDao.queryById(id);
            if(seckill!=null)
            {
                String result = redisDao.putSeckill(seckill);
                System.out.println(result);
                seckill = redisDao.getSeckill(id);

                System.out.println(seckill);

            }
        }
    }
}
