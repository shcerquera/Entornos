import java.util.Scanner;

public class ComplementoPersona {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.println("Vamos a crear varias personas. Se te va a pedir que introduzcas varios datos. ¡Vamos con el primero!");

      System.out.print("Nombre: ");
      String nombre = sc.next();

      System.out.print("Edad: ");
      int edad = sc.nextInt();

      System.out.print("Sexo (M para Mujer y H para Hombre): ");
      char sexo = sc.next().charAt(0);

      System.out.print("Peso: ");
      double peso = sc.nextDouble();

      System.out.print("Altura: ");
      double altura = sc.nextDouble();

      Persona objetoPrimero = new Persona(nombre, edad, sexo, peso, altura);

      Persona objetoSegundo = new Persona(nombre, edad, sexo);

      Persona objetoTercero = new Persona();

      objetoTercero.setNombre(nombre);
      objetoTercero.setEdad(edad);
      objetoTercero.setSexo(sexo);
      objetoTercero.setPeso(peso);
      objetoTercero.setAltura(altura);

      Persona[] personas = { objetoPrimero, objetoSegundo, objetoTercero };

      for (int index = 0; index <= 2; index++) {
         Persona personaActual = personas[index];

         int imcDeLaPersona = personaActual.calcularIMC();

         System.out.print("\nLa persona llamada " + personaActual.getNombre());

         switch (imcDeLaPersona) {
            case -2:
               System.out.print(" no tiene información sobre su peso y/o altura.");
               break;
            case -1:
               System.out.print(" está por debajo de su peso ideal.");
               break;
            case 0:
               System.out.print(" está en su peso ideal.");
               break;
            case 1:
               System.out.print(" tiene sobrepeso.");
               break;
         }

         boolean esMayorDeEdad = personaActual.esMayorDeEdad();

         System.out.print("\nEsta persona");

         if (esMayorDeEdad) {
            System.out.print(" es mayor de edad.");
         } else {
            System.out.print(" NO es mayor de edad.");
         }

         String todaLaInformacionDeLaPersona = personaActual.toString();

         System.out.println("\nAquí puedes ver toda la información de la persona #" + (index + 1) + ":\n" + todaLaInformacionDeLaPersona);
      }
   }
}