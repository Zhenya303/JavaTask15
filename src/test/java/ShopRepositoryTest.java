import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "яйца", 50);
    Product product2 = new Product(2, "молоко", 60);
    Product product3 = new Product(3, "хлеб", 40);

    @Test

    public void FindByIdTest(){

        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Product[] expected = {product2};
        Product[] actual = new Product[]{repo.findById(2)};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldRemoveProductByIdTest(){

        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(2);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void notFoundExceptionTest(){

        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });
    }


}
