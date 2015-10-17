//Clase modelo para la instancia de todas las tablas de las interfaces del sistema, 

package Modelo;

import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Samsung
 */
public class MiModelo extends DefaultTableModel{

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
}
