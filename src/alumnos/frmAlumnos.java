package alumnos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmAlumnos extends JFrame{
    private JTextField txtNombre;
    private JTextField txtPaterno;
    private JTextField txtMaterno;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JComboBox cmbSexo;
    private JCheckBox chkDiscapacidad;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel pnlPrincipal;
    private JTextField txtCurp;
    private BotonGuardarListener botonGuardarListener; //Es la interface que se creo para concetar el main con el frame

    public frmAlumnos() {
        //se utiliza solo el set Title porque se debe extender el frame a la clase del frame de alumno
        setTitle("Alumnos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(pnlPrincipal);
        //se debe poblar al iniciar la ventana para que ya tenga la informacion en el combo box
        poblarComboBox();
        setLocationRelativeTo(null);

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarDatos();
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

    private void poblarComboBox(){ //metodo del combo box que se pobla con la enum de los generos
        DefaultComboBoxModel <Genero> comboBoxModel = (DefaultComboBoxModel<Genero>) cmbSexo.getModel();

        for(Genero genero : Genero.values()){
            comboBoxModel.addElement(genero);
        }
    }

    public void setBotonGuardarListener(BotonGuardarListener listener){
        this.botonGuardarListener = listener;
    }

    private void enviarDatos(){
        String nombre = txtNombre.getText();
        String paterno = txtPaterno.getText();
        String materno = txtMaterno.getText();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();
        String sexo = cmbSexo.getSelectedItem().toString();
        String curp = txtCurp.getText();
        Boolean discapacidad = chkDiscapacidad.isSelected();

        alumno dato = new alumno(nombre, paterno, materno, curp, telefono, correo, discapacidad);

        if(botonGuardarListener != null){
            botonGuardarListener.guardando(dato);
        }
        Borrar();
    }
}
