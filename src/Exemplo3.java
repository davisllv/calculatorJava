import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exemplo3 extends JFrame implements ActionListener{
	
	private JLabel lblValor1, lblValor2, lblResultado;
	private JTextField txtValor1, txtValor2;
	private JButton btnSomar, btnSubtrair, btnMultiplicar, btnDividir, btnLimpar, btnFechar;
	private GridBagConstraints restricoes = new GridBagConstraints();
	private JPanel pnlValores, pnlBotoes, pnlResultado, pnlCalculadora;
	
	public Exemplo3() {
		this.setTitle("Exemplo");
		this.setLocation(700, 350);
		this.setSize(500, 350);
		this.setResizable(false);
		
		Font f = new Font("SansSerif", Font.PLAIN, 20);
		
		lblValor1 = new JLabel("Valor 1", JLabel.RIGHT);
		lblValor1.setFont(f);
		
		txtValor1 = new JTextField(20);
		txtValor1.setFont(f);
		txtValor1.setToolTipText("Digite o Valor 2");
		
		lblValor2 = new JLabel("Valor 2", JLabel.RIGHT);
		lblValor2.setFont(f);
		
		txtValor2 = new JTextField(20);
		txtValor2.setFont(f);
		txtValor2.setToolTipText("Digite o Valor 2");
		
		btnSomar = new JButton("Somar");
		btnSomar.setFont(f);
		btnSomar.setToolTipText("Clique aqui para Somar");
		btnSomar.setMnemonic('+');
		btnSomar.addActionListener(this);
		
		btnSubtrair = new JButton("Subtrair");
		btnSubtrair.setFont(f);
		btnSubtrair.setToolTipText("Clique aqui para Subtrai");
		btnSubtrair.setMnemonic('-');
		btnSubtrair.addActionListener(this);
		
		btnMultiplicar = new JButton("Multiplicar");
		btnMultiplicar.setFont(f);
		btnMultiplicar.setToolTipText("Clique aqui para Multiplicar");
		btnMultiplicar.setMnemonic('*');
		btnMultiplicar.addActionListener(this);
		
		btnDividir = new JButton("Dividir");
		btnDividir.setFont(f);
		btnDividir.setToolTipText("Clique aqui para Dividir");
		btnDividir.setMnemonic('/');
		btnDividir.addActionListener(this);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(f);
		btnLimpar.setToolTipText("Clique aqui para Limpar");
		btnLimpar.setMnemonic('L');
		btnLimpar.addActionListener(this);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setFont(f);
		btnFechar.setToolTipText("Clique aqui para Fechar");
		btnFechar.setMnemonic('F');
		btnFechar.addActionListener(this);
		
		lblResultado = new JLabel("Resultado", JLabel.RIGHT);
		lblResultado.setFont(f);
		
		
		
		restricoes.fill = GridBagConstraints.BOTH;
		restricoes.insets = new Insets(8, 8, 8, 8);
		
		pnlValores = new JPanel(new GridBagLayout());
		
		addGridBag(0, 0, lblValor1, pnlValores);
		addGridBag(1, 0, txtValor1, pnlValores);
		addGridBag(0, 1, lblValor2, pnlValores);
		addGridBag(1, 1, txtValor2, pnlValores);
		
		pnlBotoes = new JPanel(new GridBagLayout());
		
		addGridBag(0, 0, btnSomar, pnlBotoes);
		addGridBag(1, 0, btnSubtrair, pnlBotoes);
		addGridBag(2, 0, btnLimpar, pnlBotoes);
		addGridBag(0, 1, btnMultiplicar, pnlBotoes);
		addGridBag(1, 1, btnDividir, pnlBotoes);
		addGridBag(2, 1, btnFechar, pnlBotoes);
		
		pnlResultado = new JPanel(new GridBagLayout());
		addGridBag(0, 0, lblResultado, pnlResultado);
		
		pnlCalculadora = new JPanel(new GridBagLayout());
		addGridBag(0, 0, pnlValores, pnlCalculadora);
		addGridBag(0, 1, pnlBotoes, pnlCalculadora );
		addGridBag(0, 2, pnlResultado, pnlCalculadora);
		
		Container painel = getContentPane();
		
		painel.add(pnlCalculadora);
		
		
		
	}
	
	public void addGridBag(final int x, final int y, final Component obj, final JPanel pnl) {
		restricoes.gridx = x;
		restricoes.gridy = y;
		pnl.add(obj, restricoes);
	}
	

	
	public void actionPerformed(ActionEvent e) {
		Object buttonClicked = e.getSource();
		
			
		if(buttonClicked == btnSomar) {
			float valor1, valor2, resultado;
			
			try {
				valor1 = Float.parseFloat(txtValor1.getText());	
				
				try {
					valor2 = Float.parseFloat(txtValor2.getText());	
					
					 resultado = valor1 + valor2;
					lblResultado.setText("Resultado: " + resultado);
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "O Valor 2 é Inválido", "Valor 2 Inválido", JOptionPane.ERROR_MESSAGE);
					txtValor2.requestFocus();
					txtValor2.selectAll();
				}
			}catch(Exception erro) {
				JOptionPane.showMessageDialog(null, "O Valor 1 é Inválido", "Valor 1 Inválido", JOptionPane.ERROR_MESSAGE);
				txtValor1.requestFocus();
				txtValor1.selectAll();
			}	
			
			
		}else if(buttonClicked == btnSubtrair) {
		
			float valor1, valor2, resultado;
			
			try {
				valor1 = Float.parseFloat(txtValor1.getText());	
				
				try {
					valor2 = Float.parseFloat(txtValor2.getText());	
					
					 resultado = valor1 - valor2;
					lblResultado.setText("Resultado: " + resultado);
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "O Valor 2 é Inválido", "Valor 2 Inválido", JOptionPane.ERROR_MESSAGE);
					txtValor2.requestFocus();
					txtValor2.selectAll();
				}
			}catch(Exception erro) {
				JOptionPane.showMessageDialog(null, "O Valor 1 é Inválido", "Valor 1 Inválido", JOptionPane.ERROR_MESSAGE);
				txtValor1.requestFocus();
				txtValor1.selectAll();
			}	
		}else if(buttonClicked == btnMultiplicar) {
			
			float valor1, valor2, resultado;
			
			try {
				valor1 = Float.parseFloat(txtValor1.getText());	
				
				try {
					valor2 = Float.parseFloat(txtValor2.getText());	
					
					 resultado = valor1 * valor2;
					lblResultado.setText("Resultado: " + resultado);
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "O Valor 2 é Inválido", "Valor 2 Inválido", JOptionPane.ERROR_MESSAGE);
					txtValor2.requestFocus();
					txtValor2.selectAll();
				}
			}catch(Exception erro) {
				JOptionPane.showMessageDialog(null, "O Valor 1 é Inválido", "Valor 1 Inválido", JOptionPane.ERROR_MESSAGE);
				txtValor1.requestFocus();
				txtValor1.selectAll();
			}	
		}else if(buttonClicked == btnDividir) {
			
	float valor1, valor2, resultado;
			
			try {
				valor1 = Float.parseFloat(txtValor1.getText());	
				
				try {
					valor2 = Float.parseFloat(txtValor2.getText());	
					
					 resultado = valor1/valor2;
					lblResultado.setText("Resultado: " + resultado);
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "O Valor 2 é Inválido", "Valor 2 Inválido", JOptionPane.ERROR_MESSAGE);
					txtValor2.requestFocus();
					txtValor2.selectAll();
				}
			}catch(Exception erro) {
				JOptionPane.showMessageDialog(null, "O Valor 1 é Inválido", "Valor 1 Inválido", JOptionPane.ERROR_MESSAGE);
				txtValor1.requestFocus();
				txtValor1.selectAll();
			}	
		}else if(buttonClicked == btnFechar) {
		System.exit(0);
		}else if(buttonClicked == btnLimpar) {
			txtValor1.setText("");
			txtValor1.requestFocus();
			txtValor2.setText("");
			lblResultado.setText("");
		}
	}

	public static void main(String[] args) {
		Exemplo3 exemplo = new Exemplo3();
		
		exemplo.setVisible(true);

	}

}
