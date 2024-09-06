package alumnos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmAlumnos {
    private JTextField txtNombre;
    private JTextField txtPaterno;
    private JTextField txtMaterno;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JComboBox cmbSexo;
    private JCheckBox chkDiscapacidad;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel pnlAlumnos;
    private JTextField txtCurp;

    public frmAlumnos() {
        poblarComboBox();
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Borrar();
            }
        });
    }

    private void Borrar(){
        txtNombre.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        cmbSexo.setSelectedIndex(0);
        txtCurp.setText("");
        chkDiscapacidad.setSelected(false);

    }

    private void poblarComboBox(){
        DefaultComboBoxModel <Genero> comboBoxModel = (DefaultComboBoxModel<Genero>) cmbSexo.getModel();

        for(Genero genero : Genero.values()){
            comboBoxModel.addElement(genero);
        }
    }
}
