package unsch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaBancariaTest {

    /*
    @Test
    void depositoDebeIncrementarSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.depositar(500);
        assertEquals(1500, cuenta.obtenerSaldo());
    }

    //AGREGANDO RETIRO
    @Test
    void retiroDebeDisminuirSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.retirar(40);
        assertEquals(60, cuenta.obtenerSaldo());
    }
    */


    @Test
    void retirarConSaldoInsuficiente() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.retirar(500);
        assertEquals(100, cuenta.getSaldo());
    }

    @Test
    void retirarMontoNegativo() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.retirar(-200);
        assertEquals(1000, cuenta.getSaldo());
    }

    @Test
    void depositarMontoValido() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.depositar(500);
        assertEquals(1500, cuenta.getSaldo());
    }


    @Test
    void transferirDinero() {
        CuentaBancaria origen =
                new CuentaBancaria(1000);
        CuentaBancaria destino =
                new CuentaBancaria(500);
        origen.transferir(destino, 200);
        assertEquals(800, origen.getSaldo());
        assertEquals(700, destino.getSaldo());
    }

    //PRUEBAS UNITARIAS
    @Test
    void transferirMontoExitoso() {
        CuentaBancaria origen = new CuentaBancaria(1000);
        CuentaBancaria destino = new CuentaBancaria(500);
        origen.transferir(destino, 300);
        assertEquals(700, origen.getSaldo());
        assertEquals(800, destino.getSaldo());
    }

    @Test
    void transferirSaldoInsuficiente() {
        CuentaBancaria origen = new CuentaBancaria(100);
        CuentaBancaria destino = new CuentaBancaria(500);
        origen.transferir(destino, 200);
        assertEquals(100, origen.getSaldo());
        assertEquals(500, destino.getSaldo());
    }

    @Test
    void transferirMontoInvalido() {
        CuentaBancaria origen = new CuentaBancaria(1000);
        CuentaBancaria destino = new CuentaBancaria(500);
        origen.transferir(destino, -50);
        assertEquals(1000, origen.getSaldo());
        assertEquals(500, destino.getSaldo());
    }
}
