import java.awt.*;
import java.awt.event.*;

//VISUAL STUDIO FA SCHIFO CONTINUA A NON DEBUGGARE E COMPILARE IL CODICE, OLTRE AL FATTO CHE SI BUGGA IN CONTINUAZIONE QUINDI HO USATO JAVAC NEL PROMPT CHE FUINZIONAVA

public class Calcolatrice  {
	public static void main (String[] args) {
		

		Frame frame = new Frame("Calcolatrice");
		frame.pack();
		MenuBar mb = new MenuBar();
		Panel up = new Panel();
		Label l = new Label("Qui inserisco l'output");
		up.add(l);
		frame.add(up);
		Menu m1 = new Menu("Nuovo");
		Menu m2 = new Menu("Apri");
		Menu m3 = new Menu("Salva");
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		MenuItem mi1 = new MenuItem("file");
		MenuItem mi2 = new MenuItem("nuovissimo");
		MenuItem mi3 = new MenuItem("usato");
		MenuItem mi4 = new MenuItem("ciao");
		MenuItem mi5 = new MenuItem("spawn");
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		m1.add(mi4);
		m1.add(mi5);
		MenuItem mii1 = new MenuItem("file");
		MenuItem mii2 = new MenuItem("ciao");
		MenuItem mii3 = new MenuItem("ok");
		MenuItem mii4 = new MenuItem("io");
		MenuItem mii5 = new MenuItem("IA");
		m2.add(mii1);
		m2.add(mii2);
		m2.add(mii3);
		m2.add(mii4);
		m2.add(mii5);
		MenuItem miii1 = new MenuItem("Salva");
		MenuItem miii2 = new MenuItem("Salva in");
		MenuItem miii3 = new MenuItem("Salva per");
		MenuItem miii4 = new MenuItem("Lich King");
		MenuItem miii5 = new MenuItem("DERUBARE ANZIANE");
		m3.add(miii1);
		m3.add(miii2);
		m3.add(miii3);
		m3.add(miii4);
		m3.add(miii5);

		/* 
		TextField t1;
		t1= new TextField("0");
		t1.setSize(400, 100);
		frame.add(t1);
		*/

		
		Panel down = new Panel();
		frame.setLayout(new GridLayout(2,1));
		Button b[] = { new Button("1"), new Button("2"), new Button("3"), new Button("+"), new Button("4"), new Button("5"), new Button("6"), new Button("-"), new Button("7"), new Button("8"), new Button("9"), new Button("/"), new Button("C"), new Button("0"), new Button("="), new Button("*") };
		down.setLayout(new GridLayout(4,4));
		Buffer buffer = new Buffer(l);
		for (int i=0; i<16; i++) {
			b[i].addActionListener(buffer);
			down.add(b[i]);
		}
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.add(down);
		




		frame.setMenuBar(mb);


		//actioin listener


		frame.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent ev) {
					System.exit(0);
				}
			}
		);
		
		frame.setVisible(true);
		

	}
}

class Buffer implements ActionListener {
    private Label l;
    private StringBuilder input = new StringBuilder(); //come string ma mutabile 
    private String operazione = "";
    private double n1 = 0;

    public Buffer(Label l) {
        this.l = l;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String operando = e.getActionCommand();
        switch (operando) {
            case "C":
                input.setLength(0);
                operazione = "";
                n1 = 0;
                l.setText("0");
                break;
            case "=":
                risulta();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if (input.length() > 0) {
                    n1 = Double.parseDouble(input.toString()); //da stringbuilder a string e poi parsedouble per tornare numbero e mantenuto dentro a n1. 
			
                    operazione = operando;
                    input.setLength(0);
                    
                }
                break;
            default:
                input.append(operando);
                l.setText(input.toString());
                break;
        }
    }

    private void risulta() {
        if (input.length() > 0 && operazione != "") {
            double n2 = Double.parseDouble(input.toString());
            double result = 0;
            switch (operazione) {
                case "+":
                    result = n1 + n2;
                    break;
                case "-":
                    result = n1 - n2;
                    break;
                case "*":
                    result = n1 * n2;
                    break;
                case "/":
                    if (n2 != 0) {
                        result = n1 / n2;
                    } else {
                        l.setText("Errore");
                        return;
                    }
                    break;
            }

            l.setText(String.valueOf(result));
            input.setLength(0);
            operazione = "";
            n1 = 0;
        }
    }
}


class Message {
	int risultato;
	private static String text = "";
	public Message(String t){
		if (text.equals("")) {
			text = t;
		} else {
			text += t;
		}
		if (t.equals("C")) {
			text = "";
		}
	}

	public String getText() {
		return text;
	}


}


// più cifre