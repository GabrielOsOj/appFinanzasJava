package graphs;

import com.gbcomp.proyjavaybdd.model.dto.DTOtransaction;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author cuent
 */
public class Grafico {
    
    DefaultPieDataset datos;
    JFreeChart chart;
    
    public Grafico() {
   
    }
    
    public JPanel crearGrafico(ArrayList<DTOtransaction> transacciones) {
        this.cargarDatos(transacciones);
        this.cargarGrafico();
        return this.getGrafico();
                
    }
    
    private void cargarDatos(ArrayList<DTOtransaction> transacciones) {
        
        this.datos = new DefaultPieDataset();
        
        for (DTOtransaction t : transacciones) {
            
            this.datos.setValue(t.getNombreCategoria(), t.getTotal());
            
        }
        
    }
    
    private void cargarGrafico() {
        
        this.chart = ChartFactory.createPieChart(
                "Gastos totales",
                datos,
                true,
                false,
                false);
        
    }
    
    public JPanel getGrafico() {
        
        return new ChartPanel(this.chart);
    }
    
}
