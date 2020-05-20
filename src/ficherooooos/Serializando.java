package ficherooooos;
import java.io.*;


public class Serializando {

	public static void main(String[] args) {
		
		/*1ºejercicio*/
		//Practica1Tema4: Objetos de tipo Alumno
		
				//OBJETO
		
				Alumno al=new Alumno();
				
				//OBJETO COPIA para CONSTRUCTOR COPIA  (NO LO ESTÁ USANDO)
				
				Alumno alc=new Alumno(al);
				
		/*2ºejercicio*/
		//Practica1Tema4: Array de tipo Alumno 
				
				Alumno[] Clase=new Alumno[5];
				
				Clase[0]=new Alumno("Eustaquio", "Garcia", 5 );
				Clase[1]=new Alumno("Antonia", "Sanchez", 7);
				Clase[2]=new Alumno("Agripino", "Gomez", 3 );
				Clase[3]=new Alumno("Acabasemos", "ya", 9 );
				Clase[4]=new Alumno("Pepe", "eldesiempre", 8);
		
		try {
			
			/*1ºejercicio*/System.out.println("1ºejercicio");
			//Flujo de datos de salida (hacia fuera -> hasta la ruta) la sucesion de bytes del objeto de tipo Alumno
			ObjectOutputStream escribiendo=new ObjectOutputStream(new FileOutputStream("C:/Users/Mariluz/downloads/ObjetoAlumnoEnBytes_Practica3Tema6.txt"));
			
			//Metodo para escribir el objeto de tipo Alumno en bytes(en la ruta)
			escribiendo.writeObject(al);
			
			//Cerramos Flujo de salida
			escribiendo.close();
			
			
			//Flujo de datos de entrada (hacia dentro -> desde la ruta) para recuperar el objeto de bytes
			ObjectInputStream leyendo=new ObjectInputStream(new FileInputStream("C:/Users/Mariluz/downloads/ObjetoAlumnoEnBytes_Practica3Tema6.txt"));
			
			//Metodo para leer el objeto convertido anteriormente en bytes, para devolver otro objeto de tipo Object(hacemos casting para convertir ese tipo object en tipo Alumno)
			Alumno recuperado=(Alumno)leyendo.readObject();
			
			//Comprobamos la lectura
			//System.out.println("El nombre completo del alumno "+recuperado.getNombre()+" "+recuperado.getApellido()+" y su nota media es: "+recuperado.getNotaMedia());
			System.out.println(recuperado.toString());
			
			//Cerramos Flujo de entrada
			leyendo.close();
			
			
			/*2ºejercicio*/ System.out.println("2ºejercicio");
			//Flujo de datos de salida (hacia fuera -> hasta la ruta) la sucesion de bytes del objeto de tipo Alumno
			ObjectOutputStream escribiendo2=new ObjectOutputStream(new FileOutputStream("C:/Users/Mariluz/downloads/ObjetoAlumnoEnBytes_Practica3Tema6.txt"));
			
			//Metodo para escribir el objeto de tipo Alumno en bytes(en la ruta)
			escribiendo2.writeObject(Clase);
			
			//Cerramos Flujo de salida
			escribiendo2.close();
			
			
			//Flujo de datos de entrada (hacia dentro -> desde la ruta) para recuperar el objeto de bytes
			ObjectInputStream leyendo2=new ObjectInputStream(new FileInputStream("C:/Users/Mariluz/downloads/ObjetoAlumnoEnBytes_Practica3Tema6.txt"));
			
			//Metodo para leer el objeto convertido anteriormente en bytes, para devolver otro objeto de tipo Object(hacemos casting para convertir ese tipo object en tipo Alumno)
			Alumno recuperado2[]=(Alumno[])leyendo2.readObject();
			
			//Recorremos el array para leerlo
			for(Alumno e: recuperado2)
			{
				//Comprobamos lectura con el método toString de la clase Alumno
				System.out.println(e);
			}
			
				//otra forma de recorrerlo
				/*for(int i=0; i<recuperado2.length;i++)
				{
					System.out.println("El nombre completo del alumno "+(i+1)+" es:"+recuperado2[i].nombre++" "+recuperado2[i].apellido+" y su nota media es:"+recuperado2[i].notaMedia);
				}*/
			
			//Cerramos Flujo de entrada
			leyendo2.close();
			
		}catch(Exception e)
		{
			System.out.println("No se ha podido convertir el objeto en bytes o no se ha podido recuperar fichero");
			e.printStackTrace();
		}

	}
	
//Practica1Tema4: Clase Alumno	------------------------------------------------------------------------------------------------------------
	
public static class Alumno implements Serializable{
	
	//ATRIBUTOS/MIEMBROS
	
	protected String nombre=" ";
	protected String apellido=" ";
	private static int numalumnos=0;       
	protected double notaMedia=0;	
	
	
	//CONSTRUCTOR por defecto con parámetros dados a capón en el constructor (CONSTRUCTOR QUE ESTÁ USANDO EN EL 1ºEJERCICIO)
	
		Alumno()
			{
				nombre="Benito";
				apellido="Gonzalez";
				notaMedia=7;
				numalumnos++;						
			}
	
	//CONSTRUCTOR (con parámetros de entrada dados a capón en el array) (CONSTRUCTOR QUE ESTÁ USANDO EN EL 2ºEJERCICIO)
	
		Alumno (String nombre, String apellido, double notaMedia)
		{
			this.nombre=nombre;
			this.apellido=apellido;
			this.notaMedia=notaMedia;
			numalumnos++;
		}
		
	//CONSTRUCTOR copia (NO LO ESTÁ USANDO)
	
	Alumno(Alumno alc)
		{
			this.nombre=alc.nombre;
			this.apellido=alc.apellido;
			this.notaMedia=alc.notaMedia;
			numalumnos++;
		}

	
	//METODOS
	
	public String toString()
	{
		return "El nombre completo del alumno es: "+nombre+" "+apellido+" Y su nota media es:"+notaMedia;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNumalumnos() {
		return numalumnos;
	}

	public void setNumalumnos(int numalumnos) {
		this.numalumnos = numalumnos;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}
	
	public double incrementar()
	{
		return notaMedia++;
	}
	
	public void resultado() 
	{
		incrementar();
		this.incrementar();
	}
}

}

