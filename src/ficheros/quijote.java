package ficheros;
import java.io.*;

public class quijote {
	
	public static void main(String[] args) {
		escribir();
		crea_fichero();
		Lee();

	}
	
	static void escribir() {
		
		String frase="En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor. Una olla de algo más vaca que carnero, salpicón las más noches, duelos y quebrantos los sábados, lentejas los viernes, algún palomino de añadidura los domingos, consumían las tres partes de su hacienda. El resto della concluían sayo de velarte, calzas de velludo para las fiestas con sus pantuflos de lo mismo, los días de entre semana se honraba con su vellori de lo más fino. Tenía en su casa una ama que pasaba de los cuarenta, y una sobrina que no llegaba a los veinte, y un mozo de campo y plaza, que así ensillaba el rocín como tomaba la podadera. Frisaba la edad de nuestro hidalgo con los cincuenta años, era de complexión recia, seco de carnes, enjuto de rostro; gran madrugador y amigo de la caza. Quieren decir que tenía el sobrenombre de Quijada o Quesada (que en esto hay alguna diferencia en los autores que deste caso escriben), aunque por conjeturas verosímiles se deja entender que se llama Quijana; pero esto importa poco a nuestro cuento; basta que en la narración dél no se salga un punto de la verdad.";
		
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

