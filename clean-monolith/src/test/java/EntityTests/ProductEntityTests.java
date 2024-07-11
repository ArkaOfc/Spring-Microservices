package EntityTests;

import com.larcangeli.monolith.core.domain.entities.ProductEntity;
import com.larcangeli.monolith.core.interfaces.IProductEntity;
import org.junit.Test;


public class ProductEntityTests {

    @Test
    void testProduct(){
        IProductEntity product = new ProductEntity("Antonio", 65);
    }
}
