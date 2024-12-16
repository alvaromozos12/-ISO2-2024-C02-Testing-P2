package ESI.UCLM.ES.segundoProblema;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Clase Cliente
class Cliente {
    private int edad;
    private boolean estaEstudiando;
    private boolean viveConPadres;
    private boolean estaTrabajando;

    // Constructor
    public Cliente(int edad, boolean estaEstudiando, boolean viveConPadres, boolean estaTrabajando) {
        this.edad = edad;
        this.estaEstudiando = estaEstudiando;
        this.viveConPadres = viveConPadres;
        this.estaTrabajando = estaTrabajando;
    }

    // Métodos Getters y Setters
    public int getEdad() {
        return edad;
    }

    public boolean isEstaEstudiando() {
        return estaEstudiando;
    }

    public boolean isViveConPadres() {
        return viveConPadres;
    }

    public boolean isEstaTrabajando() {
        return estaTrabajando;
    }
}

// Clase Principal
public class Principal_Test {

	public static String determinarTipoDeCuenta(Cliente cliente) {
	    // Caso 5
	    if (cliente.getEdad() > 25 && cliente.isEstaTrabajando() && cliente.isViveConPadres()) {
	        return "Cuenta Independízate que va siendo hora";
	    }
	    // Caso 6
	    if (cliente.getEdad() > 25 && cliente.isEstaTrabajando() && !cliente.isViveConPadres()) {
	        return "Cuenta Bienvenido a la Vida Adulta";
	    }
	    // Caso 3
	    if (cliente.getEdad() >= 18 && cliente.isEstaTrabajando() && cliente.isViveConPadres()) {
	        return "Cuenta Ahorra ahora que puedes";
	    }
	    // Caso 4
	    if (cliente.getEdad() >= 18 && cliente.isEstaTrabajando() && !cliente.isViveConPadres()) {
	        return "Cuenta Saltando del Nido";
	    }
	    // Caso 1
	    if (cliente.getEdad() < 18 && cliente.isEstaEstudiando() && cliente.isViveConPadres()) {
	        return "Cuenta Confort";
	    }
	    // Caso 2
	    if (cliente.getEdad() < 25 && cliente.isEstaEstudiando() && !cliente.isViveConPadres()) {
	        return "Cuenta Vamos que tú puedes";
	    }

	    throw new IllegalArgumentException("No se puede determinar el tipo de cuenta");
	}


        private Cliente cliente1, cliente2, cliente3, cliente4, cliente5, cliente6;

        @BeforeEach
        public void setUp() {
            cliente1 = new Cliente(16, true, true, false);  // Caso 1
            cliente2 = new Cliente(20, true, false, false); // Caso 2
            cliente3 = new Cliente(19, false, true, true);  // Caso 3
            cliente4 = new Cliente(30, false, true, true);  // Caso 4
            cliente5 = new Cliente(28, false, false, true); // Caso 5
            cliente6 = new Cliente(10, false, false, false); // Caso fuera de condiciones
        }

        @Test
        public void testCaso1_CuentaConfort() {
            assertEquals("Cuenta Confort", Principal_Test.determinarTipoDeCuenta(cliente1),
                "Debería devolver 'Cuenta Confort' para cliente1.");
        }

        @Test
        public void testCaso2_CuentaVamosQueTuPuedes() {
            assertEquals("Cuenta Vamos que tú puedes", Principal_Test.determinarTipoDeCuenta(cliente2),
                "Debería devolver 'Cuenta Vamos que tú puedes' para cliente2.");
        }

        @Test
        public void testCaso3_CuentaAhorraAhoraQuePuedes() {
            assertEquals("Cuenta Ahorra ahora que puedes", Principal_Test.determinarTipoDeCuenta(cliente3),
                "Debería devolver 'Cuenta Ahorra ahora que puedes' para cliente3.");
        }

        @Test
        public void testCaso4_CuentaSaltandoDelNido() {
            Cliente cliente7 = new Cliente(22, false, false, true); // Mayor de 18, trabaja, no vive con padres
            assertEquals(
                "Cuenta Saltando del Nido",
                Principal_Test.determinarTipoDeCuenta(cliente7),
                "Debería devolver 'Cuenta Saltando del Nido' para cliente7."
            );
        }

        @Test
        public void testCaso5_CuentaIndependizateQueVaSiendoHora() {
            assertEquals(
                "Cuenta Independízate que va siendo hora".trim(),
                Principal_Test.determinarTipoDeCuenta(cliente4).trim(),
                "Debería devolver 'Cuenta Independízate que va siendo hora' para cliente4."
            );
        }

        @Test
        public void testCaso6_CuentaBienvenidoALaVidaAdulta() {
            assertEquals(
                "Cuenta Bienvenido a la Vida Adulta".trim(),
                Principal_Test.determinarTipoDeCuenta(cliente5).trim(),
                "Debería devolver 'Cuenta Bienvenido a la Vida Adulta' para cliente5."
            );
        }


        @Test
        public void testExcepcion_NoSePuedeDeterminar() {
            Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Principal_Test.determinarTipoDeCuenta(cliente6),
                "Debería lanzar IllegalArgumentException para cliente6.");

            assertEquals("No se puede determinar el tipo de cuenta", exception.getMessage(),
                "El mensaje de la excepción debería ser 'No se puede determinar el tipo de cuenta'.");
        }
    }
