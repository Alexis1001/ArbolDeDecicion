


package principalarbol;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.Serializable;

public class PrincipalArbol implements Serializable {

  
public static void main(String[] args) {
    
boolean bandera = true;
Scanner leer = new Scanner (System.in);
int res=0;
String answer;
String question;
		
Arbol abo = new Arbol();
		
while(true){
System.out.println("Piensa en un transporte y tratare de adivinarlo.");		
Nodo reco,anterior=null,aux=null;		
reco = abo.raiz;		
		
while(reco.si!=null || reco.no!=null){
aux = reco;		

System.out.println(reco.pregunta+" 1)si 2)no 3)no se");
res = leer.nextInt();

if(res == 1){
reco = reco.si;
bandera = true;
         
}else if(res == 2){
  reco = reco.no;
  bandera = false;
     
}else if(res == 3){
Nodo aux2 = reco.si;
Nodo aux3 = reco.no;
System.out.println("Escoge uno de los dos caminos");
	   
if(aux2.si==null && aux2.no==null){            
System.out.println(aux2.respuesta+" (1)");
System.out.println(aux3.respuesta+" (2)");	    
res = leer.nextInt();
}else{
 System.out.println(aux2.pregunta+" (1)");
 System.out.println(aux3.pregunta+" (2)");
 res = leer.nextInt();	
 }
 
if(res == 1){
reco = reco.si;
bandera = true;

}else if(res == 2){
 reco = reco.no;
 bandera = false;
 }
     }				
anterior = reco;
 
}

System.out.println("\nestabas pensadondo en un: "+anterior.respuesta+" 1)si  2)no ");
res = leer.nextInt();

if(res == 1){
System.out.println("Respuesta acertada");

}else{
leer.nextLine();
System.out.println("Valla me la haz puesto dificil.");
System.out.println("Cual era el veiculo que estabas pensando.");
answer=leer.nextLine();

System.out.println("Cual seria la pregunta clave?");
question=leer.nextLine();
abo.insertar(aux,answer,question,bandera);
 
  }
     
System.out.println("Desea jugar de nuevo 1)si 2)no");
res=leer.nextInt();

if(res!=1){
  System.out.println("programa finalizao");
  break;
   }

      } 


 try{
final FileInputStream fis = new FileInputStream("Arbol.bin");         
         final ObjectInputStream ois = new ObjectInputStream(fis);  
         final Object deserializedObject = ois.readObject();
         abo = (Arbol) deserializedObject;
         ois.close();
         }catch (Exception ex){
             abo= new Arbol();
             System.out.println("secreo un arbol nuevo");
         }


    }
    
    

}
