import java.util.Random;

public class Persona {
   private final char SEXO_POR_DEFECTO = 'H';
   private final int IMC_NO_VALIDO = -2;
   private final int IMC_BAJO = -1;
   private final int IMC_NORMAL = 0;
   private final int IMC_ALTO = 1;

   private String nombre = "";
   private int edad = 0;
   private String DNI;
   private char sexo = SEXO_POR_DEFECTO;
   private double peso = 0;
   private double altura = 0;

   public Persona() {
      this.DNI = generaDNI();
   }

   public Persona(String nombre, int edad, char sexo) {
      this.nombre = nombre;
      this.edad = edad;
      this.DNI = generaDNI();
      this.sexo = sexo;
   }

   public Persona(String nombre, int edad, char sexo, double peso, double altura) {
      this.nombre = nombre;
      this.edad = edad;
      this.DNI = generaDNI();
      this.sexo = comprobarSexo(sexo);
      this.peso = peso;
      this.altura = altura;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String valor) {
      this.nombre = valor;
   }

   public int getEdad() {
      return edad;
   }

   public void setEdad(int valor) {
      this.edad = valor;
   }

   public String getDNI() {
      return DNI;
   }

   public char getSexo() {
      return sexo;
   }

   public void setSexo(char valor) {
      this.sexo = comprobarSexo(valor);
   }

   public double getPeso() {
      return peso;
   }

   public void setPeso(double valor) {
      this.peso = valor;
   }

   public double getAltura() {
      return altura;
   }

   public void setAltura(double valor) {
      this.altura = valor;
   }

   public int calcularIMC() {
      double IMC = peso / Math.pow(altura, 2);

      if (peso == 0 || altura == 0) {
         return IMC_NO_VALIDO;
      }

      if (IMC < 20) {
         return IMC_BAJO;
      } else if (IMC > 25) {
         return IMC_ALTO;
      } else {
         return IMC_NORMAL;
      }
   }

   public boolean esMayorDeEdad() {
      return edad >= 18;
   }

   public char comprobarSexo(char sexo) {
      if (sexo == 'H' || sexo == 'M') {
         return sexo;
      } else {
         return SEXO_POR_DEFECTO;
      }
   }

   public String toString() {
      return "Persona { " +
            "nombre='" + nombre + '\''+
            ", edad=" + edad +
            ", DNI='" + DNI + '\'' +
            ", sexo=" + sexo +
            ", peso=" + peso +
            ", altura=" + altura +
            " }";
   }

   private String generaDNI() {
      int numero = numeroAleatorio();
      char letra = letraDNI(numero);

      return String.valueOf(numero) + letra;
   }

   private int numeroAleatorio() {
      Random random = new Random();

      int numero = random.nextInt(99999999);

      return numero;
   }

   private char letraDNI(int dni) {
      char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

      // calcualr resto
      int resto = dni % 23;

      //obtener letra DNI
      char letra = letrasDNI[resto];

      return letra;
   }
}
