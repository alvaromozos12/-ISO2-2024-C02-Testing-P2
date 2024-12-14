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

// Clase principal Banco
public class Principal {

    public static String determinarTipoDeCuenta(Cliente cliente) {
        // Caso 1
        if (cliente.getEdad() < 18 && cliente.isEstaEstudiando() && cliente.isViveConPadres()) {
            return "Cuenta Confort";
        }
        // Caso 2
        if (cliente.getEdad() < 25 && cliente.isEstaEstudiando() && !cliente.isViveConPadres()) {
            return "Cuenta Vamos que tú puedes";
        }
        // Caso 3
        if (cliente.getEdad() >= 18 && cliente.isEstaTrabajando() && cliente.isViveConPadres()) {
            return "Cuenta Ahorra ahora que puedes";
        }
        // Caso 4
        if (cliente.getEdad() >= 18 && cliente.isEstaTrabajando() && !cliente.isViveConPadres()) {
            return "Cuenta Saltando del Nido";
        }
        // Caso 5
        if (cliente.getEdad() > 25 && cliente.isEstaTrabajando() && cliente.isViveConPadres()) {
            return "Cuenta Independízate que va siendo hora";
        }
        // Caso 6
        if (cliente.getEdad() > 25 && cliente.isEstaTrabajando() && !cliente.isViveConPadres()) {
            return "Cuenta Bienvenido a la Vida Adulta";
        }

        // Si ninguna condición se cumple
        throw new IllegalArgumentException("No se puede determinar el tipo de cuenta");
    }

    //AQUI HACER EL TESTING PERO SE HACE UNO A UNO
    // Método main para probar el código
    public static void main(String[] args) {
        try {
            Cliente cliente1 = new Cliente(16, true, true, false);
            Cliente cliente2 = new Cliente(20, true, false, false);
            Cliente cliente3 = new Cliente(19, false, true, true);
            Cliente cliente4 = new Cliente(30, false, true, true);
            Cliente cliente6 = new Cliente(28, true, false, true); // No cumple condiciones

            System.out.println(determinarTipoDeCuenta(cliente1)); // Cuenta Confort
            System.out.println(determinarTipoDeCuenta(cliente2)); // Cuenta Vamos que tú puedes
            System.out.println(determinarTipoDeCuenta(cliente3)); // Cuenta Ahorra ahora que puedes
            System.out.println(determinarTipoDeCuenta(cliente4)); // Cuenta Independízate que va siendo hora

            // Este caso lanzará la excepción
            System.out.println(determinarTipoDeCuenta(cliente6));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
