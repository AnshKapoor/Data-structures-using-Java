mport java.awt.*;
import java.awt.event.*;
 
class Calculator implements ActionListener
{
    //Declaring Objects
    Frame f=new Frame();
    Label l1=new Label("First Number");
    Label l2=new Label("Second Number");
    Label l3=new Label("Result");
    
    TextField t1=new TextField();
    TextField t2=new TextField();
    TextField t3=new TextField();
    
    Button b1=new Button("Add");
    Button b2=new Button("Sub");
    Button b3=new Button("Mul");
    Button b4=new Button("Div");
    Button b5=new Button("Cancel");
