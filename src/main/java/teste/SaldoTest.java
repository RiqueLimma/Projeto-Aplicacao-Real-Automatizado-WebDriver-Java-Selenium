package teste;

import core.communs.BaseTest;
import org.junit.Test;
import page.HomePage;

public class SaldoTest extends BaseTest {
    HomePage page = new HomePage();

    @Test
    public void testSaldoConta() {
        page.obterParteTexto();
    }
}
