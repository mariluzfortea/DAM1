package ficheros;
import java.io.*;

public class quijote {
	
	public static void main(String[] args) {
		escribir();
		crea_fichero();
		Lee();

	}
	
	static void escribir() {
		
		String frase="En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que viv�a un hidalgo de los de lanza en astillero, adarga antigua, roc�n flaco y galgo corredor. Una olla de algo m�s vaca que carnero, salpic�n las m�s noches, duelos y quebrantos los s�bados, lentejas los viernes, alg�n palomino de a�adidura los domingos, consum�an las tres partes de su hacienda. El resto della conclu�an sayo de velarte, calzas de velludo para las fiestas con sus pantuflos de lo mismo, los d�as de entre semana se honraba con su vellori de lo m�s fino. Ten�a en su casa una ama que pasaba de los cuarenta, y una sobrina que no llegaba a los veinte, y un mozo de campo y plaza, que as� ensillaba el roc�n como tomaba la podadera. Frisaba la edad de nuestro hidalgo con los cincuenta a�os, era de complexi�n recia, seco de carnes, enjuto de rostro; gran madrugador y amigo de la caza. Quieren decir que ten�a el sobrenombre de Quijada o Quesada (que en esto hay alguna diferencia en los autores que deste caso escriben), aunque por conjeturas veros�miles se deja entender que se llama Quijana; pero esto importa poco a nuestro cuento; basta que en la narraci�n d�l no se salga un punto de la verdad.";
		
		FileWriter escritura=null;
		
		try {
		
			escritura=new FileWriter("C:\\Users\\Mariluz\\Quijote.txt");
			
			for(int i=0; i<frase.length();i++) {
				
				escritura.write(frase.charAt(i));
			}
			
			escritura.close();
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	static void crea_fichero() {
		
		try {
			
			FileReader fichero = new FileReader("C:\\Users\\Mariluz\\Quijote.txt");
			FileWriter fichero2 = new FileWriter("C:\\Users\\Mariluz\\Quijote_lineas.txt");
			
			BufferedWriter escritura = new BufferedWriter (fichero2);
			
			int codigo = fichero.read();
			char caracter;
			String frase="";
			
			while(codigo!=-1) {
				
				caracter = (char)codigo;
				
				if(caracter==','||caracter=='.'||caracter==';') {
					escritura.write(frase);
					escritura.newLine();
					escritura.flush();
					frase="";
				}else {
					frase=frase+caracter;
				}
				codigo=fichero.read();
			}
			
			fichero.close();
			fichero2.close();
		}catch(IOException e) {
			System.out.println("Error al crear al archivo");
		}
	}		


	
	public static void Lee() {
		
		try {
			FileReader archivo = new FileReader("C:\\Users\\Mariluz\\Quijote_lineas.txt");
			
			BufferedReader mibuffer= new BufferedReader(archivo);
			
			String linea="";
			
			while(linea!=null) {
				
				linea=mibuffer.readLine();
				
				if(linea!=null)
					System.out.println(linea);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado el archivo");
		}
		
	}
}

