package program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import clase.Angajat;
import clase.Echipa;
import clase.Utilaj;
import dataBase.SQLiteConnection;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch("App");
		
		Scanner scan=new Scanner(System.in);
		System.out.println("nr. utilaje: ");
		int nrUtilaje=scan.nextInt();
		scan.close();
		
		List<Utilaj> listaUtilaje=new Vector<Utilaj>(nrUtilaje);
		for(int i=0;i<nrUtilaje;i++){
			listaUtilaje.add(new Utilaj(3,1200,"motostivuitor"));
		}
		for(int i=0;i<nrUtilaje;i++)
			System.out.println(listaUtilaje.get(i));
		
		
		
		
		//scrierea in fisier text
		try {
			File file=new File("fisier.txt");
			FileWriter writer=new FileWriter(file);
			BufferedWriter buffer=new BufferedWriter(writer);
			for(int i=0;i<nrUtilaje;i++){
				buffer.write(listaUtilaje.get(i).toString());
				buffer.newLine();
			}
			buffer.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//citirea din fiser text
		try {
			File file=new File("fisier.txt");
			FileReader reader=new FileReader(file);
			BufferedReader buffer=new BufferedReader(reader);
			System.out.println("\n\nUtilaje existente in fisierul .txt:\n");
			String line;
			while((line=buffer.readLine())!=null)
			System.out.println(line);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//scrierea in fisier binar
		try {
			FileOutputStream output=new FileOutputStream(new File("fis.dat"));
			ObjectOutputStream writer=new ObjectOutputStream(output);
			writer.writeInt(nrUtilaje);
			for(int i=0;i<nrUtilaje;i++){
				writer.writeObject(listaUtilaje.get(i));
			}
			writer.close();
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//citirea din fiser binar
		try {
			FileInputStream file=new FileInputStream(new File("fis.dat"));
			ObjectInputStream reader=new ObjectInputStream(file);
			System.out.println("\n\nUtilaje existente in fisierul .dat:\n");
			
			int nr=reader.readInt();
			for(int i=0;i<nr;i++){
				System.out.println((Utilaj)reader.readObject());
			}
			reader.close();
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Thread
		Utilaj n1=new Utilaj(10,100,"lopata");
		Utilaj n2=new Utilaj(20,150,"grebla");
		Thread t1=new Thread(n1);
		t1.start();
		Thread t2=new Thread(n2);
		t2.start();
		
		try{
		DocumentBuilderFactory dbf_w=DocumentBuilderFactory.newInstance();
		DocumentBuilder db_w=dbf_w.newDocumentBuilder();
		Document doc_w=db_w.newDocument();
		
		Element casa=doc_w.createElement("case");
		//inca 3 elem mici telefon. ele se adauga la fisierul mare
		Element casa_1=doc_w.createElement("casa");
		//ii punem atirbutul:
		Attr atribut=doc_w.createAttribute("id");
		atribut.setNodeValue("1");
		casa_1.setAttributeNode(atribut);		
		casa_1.appendChild(doc_w.createTextNode("suprafata: 100 costuri: 3589 RON nrCamre: 2"));
		
		
		//se adauga la telefoane:
		casa.appendChild(casa_1);
		
		//se adauga in documentul xml:
		doc_w.appendChild(casa);
		
		try {
			TransformerFactory tf=TransformerFactory.newInstance();
			Transformer t=tf.newTransformer();
			
			DOMSource sursa= new DOMSource(doc_w);
			StreamResult sr=new StreamResult(new File("case.xml"));
			t.transform(sursa,sr);
			
			
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

	
	
	
	
	
	
	
	
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox root=new VBox();
		Scene scena=new Scene(root,600,600);
		stage.setScene(scena);
		stage.show();
		
		
		
		//TextARea
		GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(100);
        gridpane.setVgap(100);
        
        
        
        final TextArea cssEditorFld = new TextArea();
        cssEditorFld.setPrefRowCount(20);
        cssEditorFld.setPrefColumnCount(100);
        cssEditorFld.setWrapText(true);
        cssEditorFld.setPrefWidth(250);
        GridPane.setHalignment(cssEditorFld, HPos.RIGHT);
        gridpane.add(cssEditorFld, 0, 1);
       
        
		
		Label label=new Label("Societate de constructii");
		label.setTranslateX(20);
		label.setTranslateY(10);
		root.getChildren().add(label);
		
		Button buton=new Button("Arata echipele:");
		buton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub

				Map<String, Echipa> arbore=new TreeMap<String,Echipa>();
				for(int i=0;i<3;i++){
					arbore.put("Echipa "+(i+1), new Echipa(i*2));
				}
				

		        String cssDefault = "Echipe:\n";
		        for(Map.Entry<String, Echipa> intrare:arbore.entrySet()){
					cssDefault=cssDefault.concat("\n"+intrare.getKey()+" are un nr de "+intrare.getValue().getNrPersoane()+" persoane ");
		        }
		        cssEditorFld.setText(cssDefault);
				
				
			}
		});
		 root.getChildren().add(gridpane);
		root.getChildren().add(buton);
		
		 
		 Button buton3= new Button("Baza de date angajati");
		 root.getChildren().add(buton3);
		 buton3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				
				//query de interogare a bazei de date:
				String query="select* from Angajati";
				//se realizeaza conectare prin metoda statica din clasa Conectare
				Connection con=SQLiteConnection.conectare();
				List<Angajat> listaAngajati=new Vector<Angajat>();
				try {
					PreparedStatement ob=con.prepareStatement(query);
					ResultSet rezultat=ob.executeQuery();
					while(rezultat.next())
					{					
						System.out.println(rezultat.getString(1));
						System.out.println(rezultat.getString(2));
						System.out.println(rezultat.getInt(3));
						listaAngajati.add(new Angajat(rezultat.getString(1),rezultat.getString(2),Double.parseDouble(rezultat.getString(3))));
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		String cssDefault = "Angajati:\n";
		for(int i=0;i<listaAngajati.size();i++)
			cssDefault=cssDefault.concat("\n"+listaAngajati.get(i));
		cssEditorFld.setText(cssDefault);
				
				
			}
		});
		
			
			
			
			root.getChildren();
			stage.show();
		 
		 
		
	}

}
