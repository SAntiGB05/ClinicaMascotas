package vistas.gui;

import controlador.Coordinador;
import modelo.vo.MascotaVo;

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

public class RegistrarMascotaGui extends JDialog implements ActionListener{

    private final JPanel contentPanel = new JPanel();
    private JTextField txtIdDueno;
    private JTextField txtNombre;
    private JTextField txtRaza;
    private JComboBox comboBox;
    private JComboBox comboBox_1;
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
    public RegistrarMascotaGui(VentanaPrincipal ventanaPrincipal, boolean modal, String documento) {
        super(ventanaPrincipal,modal);
        setSize( 408, 288);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        setTitle("Gestion de Mascotas");
        iniciarComponentes(documento);


    }


    private void iniciarComponentes(String documento) {
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblTitulo = new JLabel("GESTIONAR MASCOTAS");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        lblTitulo.setBounds(10, 10, 372, 28);
        contentPanel.add(lblTitulo);

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel.setBounds(10, 49, 370, 192);
        contentPanel.add(panel);
        panel.setLayout(null);

        JLabel lblDueno = new JLabel("Id Due\u00F1o:");
        lblDueno.setBounds(199, 17, 71, 21);
        panel.add(lblDueno);

        txtIdDueno = new JTextField();
        txtIdDueno.setText(documento);
        txtIdDueno.setBounds(269, 17, 86, 20);
        panel.add(txtIdDueno);
        txtIdDueno.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(24, 49, 71, 21);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setColumns(10);
        txtNombre.setBounds(88, 49, 86, 20);
        panel.add(txtNombre);

        JLabel lblRaza = new JLabel("Raza:");
        lblRaza.setBounds(214, 49, 71, 21);
        panel.add(lblRaza);

        txtRaza = new JTextField();
        txtRaza.setColumns(10);
        txtRaza.setBounds(269, 49, 86, 20);
        panel.add(txtRaza);

        JSeparator separator = new JSeparator();
        separator.setBounds(24, 127, 331, 12);
        panel.add(separator);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(271, 150, 89, 23);
        panel.add(btnCancelar);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(172, 150, 89, 23);
        btnRegistrar.addActionListener(this);
        panel.add(btnRegistrar);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(24, 81, 71, 21);
        panel.add(lblSexo);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Macho", "Hembra"}));
        comboBox.setBounds(88, 81, 86, 22);
        panel.add(comboBox);

        JLabel lblColor = new JLabel("Color:");
        lblColor.setBounds(214, 82, 71, 21);
        panel.add(lblColor);

        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Blanco", "Negro", "Caf\u00E9", "Gris", "Manchas"}));
        comboBox_1.setBounds(269, 81, 86, 22);
        panel.add(comboBox_1);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            // Crear un objeto MascotaVo (asumiendo que existe una clase MascotaVo)
            MascotaVo miMascota = new MascotaVo();

            // Asignar los valores de los campos de texto al objeto MascotaVo
            miMascota.setIdDueno(txtIdDueno.getText());
            miMascota.setNombre(txtNombre.getText());
            miMascota.setRaza(txtRaza.getText()); // Aquí se asume que txtTelefono es para la raza
            miMascota.setSexo((String) comboBox.getSelectedItem()); // Obtener el valor del JComboBox de sexo
            miMascota.setColorMascota((String) comboBox_1.getSelectedItem()); // Obtener el valor del JComboBox de color

            // Llamar al método del coordinador para registrar la mascota
            miCoordinador.RegistrarMascota(miMascota);
        } else if (e.getSource() == btnCancelar) {
            // Cerrar la ventana si se hace clic en "Cancelar"
            this.dispose();
        }
    }
}
