import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Convertisseur extends JFrame implements ActionListener{
	
	private JTextField txtMontant = new JTextField();
	private JButton btEuros = new JButton("Euros");
	private JButton btDevise = new JButton("Francs");
	private JButton btQuitter = new JButton("Quitter");
	private JButton btApropos = new JButton("A propos");
	private JButton btTaux = new JButton("Taux");
	private JButton btAc = new JButton("AC");


	private float taux;
	private String devise;
	
	//les menus
	private JMenu mnFichier = new JMenu("Fichier");
	private JMenu mnOperations = new JMenu("Opérations");
	private JMenu mnAide = new JMenu("Aide");
	
	private JMenuItem itemEuros = new JMenuItem("Euros");
	private JMenuItem itemDevise = new JMenuItem("Devise");
	private JMenuItem itemQuitter = new JMenuItem("Quitter");
	private JMenuItem itemTaux = new JMenuItem("Taux");
	private JMenuItem itemAc = new JMenuItem("AC");
	private JMenuItem itemApropos = new JMenuItem("A propos");
	
	private JMenuBar uneBarre = new JMenuBar();
	
	public Convertisseur () {
		this.taux = (float) 6.56;
		this.devise = "Francs"; 
		
		//on change le titre de la fenetre
		this.setTitle("My Convertisseur 2024 ");
		//emplacement et taille de la fenetre
		this.setBounds(200, 200, 500, 300);
		//arret de l'application sur clic crois
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pas de redimensio, de la fenetre
		this.setResizable(false);
		//fixer la couleur de fond pour le panel
		this.getContentPane().setBackground(Color.gray);
		//pas de style par defaut
		this.setLayout(null);
		
		//placer les objets graphiques
		this.btEuros.setBounds(20, 40, 100, 40);
		this.add(this.btEuros);
		this.txtMontant.setBounds(140, 40, 100, 40);
		this.add(this.txtMontant);
		this.btDevise.setBounds(260, 40, 100, 40);
		this.add(this.btDevise);
		
		this.btTaux.setBounds(20, 100, 100, 40);
		this.add(this.btTaux);
		this.btAc.setBounds(140, 100, 100, 40);
		this.add(this.btAc);
		this.btApropos.setBounds(260, 100, 100, 40);
		this.add(this.btApropos);
		
		this.btQuitter.setBounds(20, 160, 340, 40);
		this.add(this.btQuitter);
		
		//rendre les boutons ecoutables
		this.btEuros.addActionListener(this);
		this.btDevise.addActionListener(this);
		this.btQuitter.addActionListener(this);
		this.btTaux.addActionListener(this);
		this.btApropos.addActionListener(this);
		this.btAc.addActionListener(this);

		//construction des menus 
		this.mnFichier.add(this.itemQuitter);
		this.mnOperations.add(this.itemEuros);
		this.mnOperations.add(this.itemDevise);
		this.mnOperations.add(this.itemTaux);
		this.mnOperations.add(this.itemAc);
		this.mnAide.add(this.itemApropos);
		
		this.uneBarre.add(this.mnFichier);
		this.uneBarre.add(this.mnOperations);
		this.uneBarre.add(this.mnAide);
		
		this.setJMenuBar(this.uneBarre);
		
		//rendre les items cliquables 
		this.itemAc.addActionListener(this);
		this.itemQuitter.addActionListener(this);
		this.itemApropos.addActionListener(this);
		this.itemEuros.addActionListener(this);
		this.itemDevise.addActionListener(this);
		this.itemTaux.addActionListener(this);
		
		//rendre visible la fenetrre 
		this.setVisible(true);
	}
	
	public static void main(String [] args) {
		//instanciation de la classe convertisseur 
		Convertisseur unConvertisseur = new Convertisseur ();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAc || e.getSource() ==this.itemAc) {
			this.txtMontant.setText("");
		}
		else if (e.getSource() == this.btApropos || e.getSource() ==this.itemApropos) {
			JOptionPane.showMessageDialog(this, "\n Convertisseur réalisé 01-24" + "\n Classe SLAM 2A" +"\n Droits réservés IRIS PARIS");
		}
		else if (e.getSource() == this.btQuitter || e.getSource() ==this.itemQuitter) {
			int retour = JOptionPane.showConfirmDialog(this,
							"Voulez-vous quitter l'application ?",
							"Quitter l'application", 
							JOptionPane.YES_NO_OPTION);
			if (retour == 0 ) {
				this.dispose(); //detruire l'appliction
			}
		}
		else if (e.getSource() == this.btEuros || e.getSource() ==this.itemEuros) {
			float mt = 0;
			try {
				mt = Float.parseFloat(this.txtMontant.getText());
				mt = mt / this.taux;
				this.txtMontant.setText(mt + "");
			}
			catch (NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, 
						"Attention au format du montant");
				this.txtMontant.setText("");
			}
		}
		
		else if (e.getSource() == this.btDevise || e.getSource() ==this.itemDevise) {
			float mt = 0;
			try {
				mt = Float.parseFloat(this.txtMontant.getText());
				mt = mt * this.taux;
				this.txtMontant.setText(mt + "");
			}
			catch (NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, 
						"Attention au format du montant");
				this.txtMontant.setText("");
			}
		}
		else if (e.getSource() == this.btTaux) {
			try {
				this.devise= JOptionPane.showInputDialog("donner la nouvelle devise : ");
				this.taux= Float.parseFloat(JOptionPane.showInputDialog("nouveau taux: "));
				this.btDevise.setText(this.devise);
			}
			catch (NumberFormatException exp) {
				this.devise = "Francs";
				this.taux = (float) 6.56;
				JOptionPane.showMessageDialog(this, "Erreur de saisie de new devise ");
			}
			
		}
	}
}
		


