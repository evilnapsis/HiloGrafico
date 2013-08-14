

package hilografico;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HiloGrafico extends JFrame {
boolean started1 = false;
boolean started2 = false;

public HiloGrafico(){
super("Control de Hilos");
setSize(450,100);
getContentPane().setLayout(new GridLayout(2,4));
started1=false;

// Objeto que representa el primer hilo.
final HiloMensaje hilo1 = new HiloMensaje("Hilo 1");
// Objeto que representa el segundo hilo.
final HiloMensaje hilo2 = new HiloMensaje("Hilo 2"); 
// hilo1.start();

JLabel label1 = new JLabel("Hilo 1 : ");
final JButton ibtn1 = new JButton("Iniciar");
JLabel slabel1 = new JLabel("Status 1 : ");
final JTextField tf1 = new JTextField("Detenido");

JLabel label2 = new JLabel("Hilo 2 : ");
final JButton ibtn2 = new JButton("Iniciar");
JLabel slabel2 = new JLabel("Status 2 : ");
final JTextField tf2 = new JTextField("Detenido");

ibtn1.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {
if(ibtn1.getText().equals("Iniciar")){
      if(started1==false){ // significa que el hilo no se ha corrido ninguna vez
          started1 = true;
          hilo1.start();
          ibtn1.setText("Detener");
          tf1.setText("Ejecutando : " + hilo1.valor);
      }else {
          hilo1.continuar();
          ibtn1.setText("Detener");
          tf1.setText("Ejecutando : " + hilo1.valor);
      }
}else if(ibtn1.getText().equals("Detener")){
    hilo1.detener();
          ibtn1.setText("Iniciar");
          tf1.setText("Detenido : " + hilo1.valor);
}
  }
});

ibtn2.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {
if(ibtn2.getText().equals("Iniciar")){
      if(started2==false){ // significa que el hilo no se ha corrido ninguna vez
          started2 = true;
          hilo2.start();
          ibtn2.setText("Detener");
          tf2.setText("Ejecutando : " + hilo2.valor);
      }else {
          hilo2.continuar();
          ibtn2.setText("Detener");
          tf2.setText("Ejecutando : " + hilo2.valor);
      }
}else if(ibtn2.getText().equals("Detener")){
    hilo2.detener();
          ibtn2.setText("Iniciar");
          tf2.setText("Detenido : " + hilo2.valor);
}
  }
});

getContentPane().add(label1);
getContentPane().add(ibtn1);
getContentPane().add(slabel1);
getContentPane().add(tf1);

getContentPane().add(label2);
getContentPane().add(ibtn2);
getContentPane().add(slabel2);
getContentPane().add(tf2);

}
/** * Este método inicia la ejecución del programa. 
* * Crea dos objetos de tipo HiloMensaje (hilos) y los inicia. */
 public static void main(String[] args) throws Exception 
{ 

    JFrame myfrm = new HiloGrafico();
    myfrm.setVisible(true);

 //Se inicia la ejecución del primer hilo. 
// hilo2.start();
 //Se inicia la ejecución del segundo hilo.
 //Esta instrucción detiene el hilo principal del programa 
//por dos segundos. Sin embargo, los dos hilos anteriores
 //continúan su ejecución. 
//Thread.currentThread().sleep(2000); 
// System.exit(0);

}
}
