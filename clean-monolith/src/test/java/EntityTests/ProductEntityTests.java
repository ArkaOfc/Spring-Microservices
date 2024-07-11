package EntityTests;

import com.larcangeli.monolith.core.entity.implementation.ProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import org.junit.Test;


public class ProductEntityTests {

    @Test
    void testProduct(){
        IProductEntity product = new ProductEntity("Antonio", 65);
    }
}
