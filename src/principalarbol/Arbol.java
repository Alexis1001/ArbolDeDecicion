
package principalarbol;
import java.io.Serializable;


public class Arbol implements Serializable{
 private static final long SerialVersionUID=1;
 
Nodo raiz= new Nodo();
Nodo hijo1=new Nodo();
Nodo hijo2=new Nodo();

public Arbol(){
raiz.pregunta ="¿El transporte terrestre?";
hijo1.respuesta ="tsuru";
hijo2.respuesta ="elicoptero";
raiz.si = hijo1;
raiz.no = hijo2;
}    

public void insertar(Nodo reco,String answer,String question,boolean bandera){
Nodo padre = new Nodo();
Nodo hijo = new Nodo();

hijo.respuesta = answer;
padre.pregunta = question;
	   	
if(bandera == true){
padre.no = reco.si;
padre.si = hijo;
reco.si = padre;
}else{
    padre.no = reco.no;
    padre.si = hijo;
    reco.no = padre;
	    }
System.out.println("se introdujo");
	  }   
    
private void preOrder (Nodo reco){

if (reco != null){
System.out.print(reco.pregunta);
preOrder (reco.si);
preOrder (reco.no);
          }
      }

}
