package vistas.gui;

import controlador.Coordinador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistrarProductoGui extends JDialog implements ActionListener{

    private final JPanel contentPanel = new JPanel();
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JButton btnCancelar;
    private JButton btnRegistrar;

    private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }


    /*
     * Create the dialog.
     * @param b
     * @param ventanaPrincipal
     * @param documento
    */
    public RegistrarProductoGui(VentanaPrincipal ventanaPrincipal, boolean modal) {
        super(ventanaPrincipal,modal);
        setSize( 412, 208);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        setTitle("Gestion de Mascotas");
        iniciarComponentes();


    }


    private void iniciarComponentes() {
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblTitulo = new JLabel("GESTIONAR PRODUCTOS");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        lblTitulo.setBounds(10, 10, 372, 28);
        contentPanel.add(lblTitulo);

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel.setBounds(10, 49, 380, 109);
        contentPanel.add(panel);
        panel.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(24, 11, 71, 21);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setColumns(10);
        txtNombre.setBounds(88, 11, 86, 20);
        panel.add(txtNombre);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(214, 11, 71, 21);
        panel.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setColumns(10);
        txtPrecio.setBounds(269, 11, 86, 20);
        panel.add(txtPrecio);

        JSeparator separator = new JSeparator();
        separator.setBounds(24, 43, 331, 12);
        panel.add(separator);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(271, 66, 89, 23);
        panel.add(btnCancelar);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(172, 66, 89, 23);
        btnRegistrar.addActionListener(this);
        panel.add(btnRegistrar);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}
